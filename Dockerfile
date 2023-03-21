FROM openjdk:18
COPY ./target/SWM-F.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SWM-F.jar"]