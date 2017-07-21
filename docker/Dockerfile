FROM openjdk:8u92-jdk-alpine

EXPOSE 8080

ADD build/libs/app.jar app.jar
ENTRYPOINT java -jar app.jar

HEALTHCHECK --interval=5m --timeout=3s \
 CMD curl -f http://localhost:8080/health || exit 1
