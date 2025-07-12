#FROM maven:3.8.4-openjdk-17 as builder
#MAINTAINER alexUser
#COPY target/hungman-0.0.1-SNAPSHOT.jar app-1.0.0.jar
#ENTRYPOINT ["java","-jar","/app-1.0.0.jar"]
#FROM maven:3.8.4-openjdk-17 as builder
#WORKDIR /app
#COPY . /app/.
#RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip=true

#FROM eclipse-temurin:17-jre-alpine
#WORKDIR /app
#COPY --from=builder /app/target/*.jar /app/*.jar
#EXPOSE 9096
#ENTRYPOINT ["java", "-jar", "/app/*.jar"]
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

