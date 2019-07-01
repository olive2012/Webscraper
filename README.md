# Webscraper
Extracts from website www.lrt.lt TV shows which are currently playing on LRT channels. 
You can choose either LT or EN (default) language.
Data automatically refreshes after 10 sec.

## Docker
The docker image can be pulled from [cloud.docker.com] under 
```bash 
docker pull olive2012/webscraper:latest
```

To start application please enter

```bash 
docker run -p 5000:8080 olive2012/webscraper:latest
```
## CENTOS Server on digitalocean.com

http://webscraper.paidem.lt
