FROM maven:3.8.6-openjdk-11 AS base
WORKDIR /app
COPY pom.xml /app/pom.xml
RUN mvn dependency:go-offline

FROM base AS development
EXPOSE 8080 8000
CMD [ "mvn", "spring-boot:run", "-Dspring-boot.run.jvmArguments='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000'" ]

FROM base AS build
COPY src /app/src
RUN mvn package -DskipTests

FROM openjdk:11.0-jre
COPY --from=build /app/target/*.jar /app/drone-feeder.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/app/drone-feeder.jar" ]