# Webscraper
Extracts currently playing shows on LRT channels from website www.lrt.lt. 
You can choose either LT or EN (default) language.
Data automatically refreshes every 10 sec (for demostration purposes).

## Docker
The docker image can be pulled from DockerHub using 
```bash 
docker pull olive2012/webscraper:latest
```

To start application please enter

```bash 
docker run -p 8080:8080 --restart always -d -t olive2012/webscraper:latest
```
## DEMO hosted on digitalocean.com droplet

http://webscraper.paidem.lt
