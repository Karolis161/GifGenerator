FROM openjdk:11
MAINTAINER maintainer ="Karolis"
COPY build/libs/GifGenerator.jar GifGenerator.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/GifGenerator.jar", "-web -webAllowOthers -tcp -tcpAllowOthers -browser"]