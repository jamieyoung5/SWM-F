FROM openjdk:18
COPY ./target/classes /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "com.napier.sem.App"]
