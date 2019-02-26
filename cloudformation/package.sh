#!/usr/bin/env bash

. vars.sh

rm -rf packaged-lambdas.yaml
sam package \
    --template-file lambdas.yaml \
    --s3-bucket ${S3_BUCKET} \
    --output-template-file packaged-lambdas.yaml
