#!/usr/bin/env bash

. vars.sh

sam deploy \
    --stack-name ${STACK_NAME} \
    --template-file packaged-lambdas.yaml \
    --parameter-overrides RoleArn=${ROLE_ARN} \
                          SecurityGroupIds=${SECURITY_GROUP_IDS} \
                          SubnetIds=${SUBNET_IDS} \
                          NeptuneEndpoint=${NEPTUNE_ENDPOINT} \
                          NeptunePort=${NEPTUNE_PORT} \
                          TagUser=${NEPTUNE_PORT}
