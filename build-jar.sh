#!/bin/bash

# build frontend
cd ./frontend/
npm run build
cd ..

# clean public resources from spring boot project
rm -rf ./src/main/resources/public/*
mkdir -p ./src/main/resources/public

# move react build result to spring boot public resources
# (embed react app files to be served by spring boot)
cp -r ./frontend/build/* ./src/main/resources/public/

# build and package jar
mvn clean package