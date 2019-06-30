#!/bin/bash

# -t - terminate container after exit
# -p 5000:8080 - map our host's 5000 port to container's 8080 pot
docker run -t -p 5000:8080 webscraper

# webscraper is now available on http://localhost:5000/