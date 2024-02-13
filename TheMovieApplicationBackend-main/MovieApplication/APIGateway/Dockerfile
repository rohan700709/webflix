FROM openjdk
WORKDIR usr/lib
EXPOSE 9000
ADD ./target/APIGateway-0.0.1-SNAPSHOT.jar /usr/lib/APIGateway-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","APIGateway-0.0.1-SNAPSHOT.jar"]