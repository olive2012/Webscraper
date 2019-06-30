#!/bin/bash
cd frontend/
npm run build
cd ..
rm -rf ./src/main/resources/public/*
mkdir -p ./src/main/resources/public
pwd
cp -r ./frontend/build/* ./src/main/resources/public/