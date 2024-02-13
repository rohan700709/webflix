package com.stackroute.PlaylistService.repository;

import com.stackroute.PlaylistService.domain.Playlist;
import com.stackroute.PlaylistService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends MongoRepository<User, String> {

}
