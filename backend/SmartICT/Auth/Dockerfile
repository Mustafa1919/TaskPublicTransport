FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} auth.jar
CMD  apt-get update -y
EXPOSE 8091
ENTRYPOINT ["java","-jar","auth.jar"]