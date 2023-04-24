FROM openjdk:18
COPY ./target/SWM-F.jar /app/SWM-F.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "SWM-F.jar"]

