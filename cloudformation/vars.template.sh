#!/usr/bin/env bash

# TODO:
# cp vars.template.sh vars.sh
# vim vars.sh
# adjust the variables

S3_BUCKET=s3-bucket-name-for-storing-lambda-zip-artifacts
STACK_NAME=my-neptune-app

ROLE_ARN=arn:aws:iam::1234567890:role/service-role/RoleForLambdaFunctions
SECURITY_GROUP_IDS=sg-1234567
SUBNET_IDS=subnet-123,subnet-456,subnet-789
NEPTUNE_ENDPOINT=foo.bar.baz.neptune.amazonaws.com
NEPTUNE_PORT=8182
TAG_USER=Max.Mustermann
