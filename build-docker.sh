#!/bin/bash
# run this after build-jar.sh !!

# copy jar to docker "code" folder
cp ./target/webscraper-0.0.1-snapshot.jar ./docker/code/webscraper.jar

cd docker

# build docker image from Dockerfile in current directory and tag it with "webscraper"
docker build -t webscraper ./