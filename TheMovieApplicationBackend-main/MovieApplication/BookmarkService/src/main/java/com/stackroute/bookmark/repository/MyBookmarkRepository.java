package com.stackroute.bookmark.repository;

import com.stackroute.bookmark.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookmarkRepository extends MongoRepository<User, String> {
}
