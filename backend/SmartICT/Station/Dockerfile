FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} station.jar
CMD  apt-get update -y
EXPOSE 8094
ENTRYPOINT ["java","-jar","station.jar"]