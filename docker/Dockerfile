FROM openjdk:12

RUN mkdir /code

COPY code/* /code/

EXPOSE 8080

CMD ["java","-jar","/code/webscraper.jar"]