FROM openjdk
WORKDIR usr/lib
ENV MONGO_DATABASE=muzixdetailsdb
ENV MONGO_URL=mongodb://localhost:27017/muzixdetailsdb
ADD ./target/UserService-0.0.1-SNAPSHOT.jar /usr/lib/UserService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","UserService-0.0.1-SNAPSHOT.jar"]