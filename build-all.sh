#!/bin/bash

for P in $(find . -name pom.xml | xargs dirname) ; do
  pushd $P
  mvn clean verify
  popd
done
