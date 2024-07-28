FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} eureka.jar
CMD  apt-get update -y
EXPOSE 9761
ENTRYPOINT ["java","-jar","eureka.jar"]