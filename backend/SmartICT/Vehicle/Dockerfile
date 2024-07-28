FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} vehicle.jar
CMD  apt-get update -y
EXPOSE 8095
ENTRYPOINT ["java","-jar","vehicle.jar"]