package com.stackroute.bookmark.repository;

import com.stackroute.bookmark.model.Bookmark;
import com.stackroute.bookmark.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkRepository extends MongoRepository<User,String> {

    @Query("{'bookmark.bookmarkName':{$in:[?0]}}")
    List<User> getBookmarkByBookmarkName(String bookmarkName);

    @Query("{'bookmark.bookmarkName':{$in:[?0]}}")
    Bookmark getBookmarkNameByName(String bookmarkName);

}
