# FROM maven:3.5-jdk-8-alpine
# EXPOSE 8080
# VOLUME /temp
# ADD target/*.jar 
# ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]
FROM alpine/git
WORKDIR /app
RUN git clone https://github.com/mysticflower/javaapi.git 

FROM maven:3.5-jdk-8-alpine
WORKDIR /app
COPY --from=0 /app/javaapi /app 
RUN mvn install 

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=1 /app/target/javaapi-1.5.1.jar /app 
CMD ["java -jar javaapi-1.5.1.jar"] 