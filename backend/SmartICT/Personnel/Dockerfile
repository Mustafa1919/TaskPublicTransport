FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} personnel.jar
CMD  apt-get update -y
EXPOSE 8092
ENTRYPOINT ["java","-jar","personnel.jar"]