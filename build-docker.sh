#!/bin/bash
# run this after build-jar.sh !!

# copy jar to docker "code" folder
cp ./target/webscraper-0.0.1-snapshot.jar ./docker/code/webscraper.jar

cd docker

docker login --username=olive2012 --email=ana.sachova@gmail.com

# build docker image from Dockerfile in current directory and tag it with "webscraper"
docker build -t olive2012/webscraper ./
docker push olive2012/webscraper