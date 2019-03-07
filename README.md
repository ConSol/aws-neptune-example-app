# AWS Neptune demo application

### Create a new AWS Neptune instance
dd

### bcd
test ad hoc query 1:
```json
{
  "skill1": "Java EE 8",
  "skill2": "PostgreSQL",
  "skill3": "TDD",
  "certificate": "OCP Java SE 8",
  "customer": "Big Brother Corporation",
  "availableFrom": 1516492800000,
  "availableTo": 1516665600000
}
```

result:
```json
[
  {
    "firstName": [
      "Bob"
    ],
    "lastName": [
      "Smith"
    ],
    "id": [
      10
    ],
    "position": [
      "software engineer"
    ]
  }
]
```

test ad hoc query 2:
```json
{
  "skill1": "Java EE 8",
  "skill2": "PostgreSQL",
  "skill3": "TDD",
  "certificate": "OCP Java SE 8",
  "customer": "Space Logistics AG",
  "availableFrom": 1514764800000,
  "availableTo": 1517443200000
}
```

result:
```json
[
  {
    "firstName": [
      "Alice"
    ],
    "lastName": [
      "Brown"
    ],
    "id": [
      20
    ],
    "position": [
      "senior software engineer"
    ]
  },
  {
    "firstName": [
      "Bob"
    ],
    "lastName": [
      "Smith"
    ],
    "id": [
      10
    ],
    "position": [
      "software engineer"
    ]
  }
]
```

### load csv data
tried -- did not work

