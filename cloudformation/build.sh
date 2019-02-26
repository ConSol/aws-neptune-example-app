#!/usr/bin/env bash

. vars.sh

pushd ..
mvn clean install
popd
