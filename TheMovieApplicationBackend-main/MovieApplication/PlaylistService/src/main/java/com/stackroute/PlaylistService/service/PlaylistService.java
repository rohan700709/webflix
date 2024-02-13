package com.stackroute.PlaylistService.service;

import com.stackroute.PlaylistService.domain.Movie;
import com.stackroute.PlaylistService.domain.Playlist;
import com.stackroute.PlaylistService.domain.User;
import com.stackroute.PlaylistService.exception.MovieAlreadyExists;
import com.stackroute.PlaylistService.exception.PlayListNameNotFoundException;
import com.stackroute.PlaylistService.exception.PlaylistNameAlreadyExists;
import com.stackroute.PlaylistService.exception.UserNotFoundException;

import java.util.List;

public interface PlaylistService {

//    User createPlaylist(Playlist playlist,String userEmail) throws UserNotFoundException;
    User addMovieToPlaylist(Movie movie,String userEmail, String playlistName) throws UserNotFoundException, MovieAlreadyExists;
    User deletePlayList(String playlistName,String userEmail) throws UserNotFoundException, PlayListNameNotFoundException;
    User deleteMovieFromPlayList(int id, String playlistName,String userEmail) throws UserNotFoundException;
    List<Movie> getAllPlaylist(String playlistName, String userEmail) throws Exception;
    List<String> getPlaylistName(String userEmail) throws UserNotFoundException;
    User createNewPlayList(String userEmail,String playListName) throws PlaylistNameAlreadyExists;
}
