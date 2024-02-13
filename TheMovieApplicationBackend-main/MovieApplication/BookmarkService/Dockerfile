FROM openjdk
WORKDIR usr/lib
ENV MONGO_DATABASE=bookmarkdb
ENV MONGO_URL=mongodb://localhost:27017/playlistdb
ADD ./target/BookmarkService-0.0.1-SNAPSHOT.jar /usr/lib/BookmarkService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","BookmarkService-0.0.1-SNAPSHOT.jar"]

