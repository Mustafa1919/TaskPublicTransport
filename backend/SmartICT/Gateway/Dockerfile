FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} gateway.jar
CMD  apt-get update -y
EXPOSE 8090
ENTRYPOINT ["java","-jar","gateway.jar"]