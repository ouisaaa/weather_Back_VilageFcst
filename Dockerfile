FROM openjdk:17-jdk

LABEL authors="uhweng_"

#파일 이름
ARG JAR_FILE=build/libs/weather-1.0-SNAPSHOT.jar

#도커 파일을 만든다
ADD ${JAR_FILE} docker-weather-1.0.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/.urandom","-jar","/docker-weather-1.0-SNAPSHOT.jar"]