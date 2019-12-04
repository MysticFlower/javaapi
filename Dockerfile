FROM openjdk:8
EXPOSE 8080
VOLUME /temp
ADD target/*.jar spring-boot-docker.jar
ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]