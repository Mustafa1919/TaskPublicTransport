FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} route.jar
CMD  apt-get update -y
EXPOSE 8093
ENTRYPOINT ["java","-jar","route.jar"]