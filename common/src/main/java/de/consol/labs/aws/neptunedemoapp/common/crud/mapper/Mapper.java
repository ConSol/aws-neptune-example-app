package de.consol.labs.aws.neptunedemoapp.common.crud.mapper;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class Mapper {

    public Map<String, Object> object2Properties(final Object object) {
        return getPropertyName2FieldMapping(object)
                .entrySet()
                .stream()
                .map(e -> Pair.of(e.getKey(), getPropertyValue(object, e.getValue())))
                .filter(p -> Objects.nonNull(p.getValue()))
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue));
    }

    public <T> T properties2Object(final Map<String, Object> properties, final Class<T> targetClass) {
        if (properties == null || properties.isEmpty()) {
            return null;
        }
        final Map<String, Object> defensiveCopy = new HashMap<>(properties);
        final T object;
        try {
            object = targetClass.newInstance();
        } catch (final InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException(targetClass.getCanonicalName() + " could not be instantiated", e);
        }
        getPropertyName2FieldMapping(object).forEach(
                (propertyName, field) -> {
                    final Object value = defensiveCopy.get(propertyName);
                    if (value != null) {
                        field.setAccessible(true);
                        try {
                            field.set(object, value);
                        } catch (final IllegalAccessException e) {
                            throw new IllegalArgumentException(getFieldFullName(targetClass, field) + " could not be written");
                        }
                    }
                }
        );
        return object;
    }

    private static Map<String, Field> getPropertyName2FieldMapping(final Object object) {
        return getRelevantFields(object).stream().collect(
                Collectors.toMap(Mapper::getPropertyName, f -> f)
        );
    }

    private static List<Field> getRelevantFields(final Object object) {
        if (object == null) {
            return Collections.emptyList();
        }
        return Arrays.stream(object.getClass().getDeclaredFields())
                .filter(Objects::nonNull)
                .filter(f -> f.getAnnotation(Property.class) != null)
                .collect(Collectors.toList());
    }

    private static String getPropertyName(final Field field) {
        final Property annotation = field.getAnnotation(Property.class);
        if (annotation == null) {
            throw new IllegalArgumentException(getFieldFullName(field) + " must be annotated with " + Property.class.getCanonicalName());
        }
        final String value = annotation.value();
        return StringUtils.isBlank(value) ? field.getName() : value;
    }

    private Object getPropertyValue(final Object object, final Field f) {
        f.setAccessible(true);
        try {
            return f.get(object);
        } catch (final IllegalAccessException e) {
            throw new IllegalArgumentException(getFieldFullName(object, f) + " could not be read", e);
        }
    }

    private static String getFieldFullName(final Field field) {
        return getFieldFullName(field.getDeclaringClass(), field);
    }

    private static String getFieldFullName(final Object object, final Field field) {
        return getFieldFullName(object.getClass(), field);
    }

    private static String getFieldFullName(final Class<?> cls, final Field field) {
        return String.format("%s#%s ", cls.getCanonicalName(), field.getName());
    }
}
