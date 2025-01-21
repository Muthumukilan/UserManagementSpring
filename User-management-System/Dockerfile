FROM openjdk:17-jdk-slim
EXPOSE 8080
ADD target/spring-docker1.jar spring-docker1.jar
ENTRYPOINT ["java","-jar","/spring-docker1.jar"]