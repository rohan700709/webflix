package com.stackroute.PlaylistService.repository;

import com.stackroute.PlaylistService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewPlaylistRepository extends MongoRepository<User, String> {
}
