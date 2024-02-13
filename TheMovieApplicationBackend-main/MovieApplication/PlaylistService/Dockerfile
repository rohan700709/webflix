FROM openjdk
WORKDIR usr/lib
ENV MONGO_DATABASE=playlistdb
ENV MONGO_URL=mongodb://localhost:27017/playlistdb
ADD ./target/PlaylistService-0.0.1-SNAPSHOT.jar /usr/lib/PlaylistService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","PlaylistService-0.0.1-SNAPSHOT.jar"]

