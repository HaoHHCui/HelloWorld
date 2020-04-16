FROM docker.io/openjdk:8-slim

COPY /home/jenkins/agent/workspace/helloworld-mvn/target/HelloWorld-0.0.1-SNAPSHOT.jar /data/helloworld/target/
WORKDIR /data/helloworld


EXPOSE 8080

CMD ["java", "-jar", "target/HelloWorld-0.0.1-SNAPSHOT.jar"]