FROM docker.io/openjdk:8-slim

RUN  mkdir -p /data/helloworld/target/
COPY target/HelloWorld-0.0.1-SNAPSHOT.jar /data/helloworld/target/
WORKDIR /data/helloworld

EXPOSE 8080

CMD ["java", "-jar", "target/HelloWorld-0.0.1-SNAPSHOT.jar"]
