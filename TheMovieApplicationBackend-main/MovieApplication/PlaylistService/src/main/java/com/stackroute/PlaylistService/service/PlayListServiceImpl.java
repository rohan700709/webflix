package com.stackroute.PlaylistService.service;

//import com.stackroute.PlaylistService.config.Consumer;
import com.stackroute.PlaylistService.domain.Movie;
import com.stackroute.PlaylistService.domain.Playlist;
import com.stackroute.PlaylistService.domain.User;
import com.stackroute.PlaylistService.exception.MovieAlreadyExists;
import com.stackroute.PlaylistService.exception.PlayListNameNotFoundException;
import com.stackroute.PlaylistService.exception.PlaylistNameAlreadyExists;
import com.stackroute.PlaylistService.exception.UserNotFoundException;
import com.stackroute.PlaylistService.rabbitmq.domain.MovieDTO;
import com.stackroute.PlaylistService.repository.NewPlaylistRepository;
import com.stackroute.PlaylistService.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayListServiceImpl implements PlaylistService {

    private NewPlaylistRepository playlistRepository;

    @Autowired
    public PlayListServiceImpl(NewPlaylistRepository playlistRepository){
        this.playlistRepository=playlistRepository;
    }


    @Override
    public User addMovieToPlaylist(Movie movie, String userEmail, String playlistName) throws UserNotFoundException, MovieAlreadyExists {
        System.out.println("66 in S");
        if(playlistRepository.findById(userEmail).isEmpty())
        {
            User user = new User();
            user.setUserEmail(userEmail);
            playlistRepository.save(user);
        }
        System.out.println("72 in S");
        User user = playlistRepository.findById(userEmail).get();
        List<Playlist> playlists = user.getPlaylist();
        System.out.println("76 in S");
        Playlist p1 = new Playlist();
        for(Playlist p : playlists){
            if(p.getPlaylistName().equals(playlistName)){
                p1=p;

            }
        }
        playlists.remove(p1);
        List<Movie> movieList = p1.getMovieList();
        List<Movie> newMovieList = new ArrayList<>();

        if(!movieList.isEmpty()){
            for(Movie m : movieList){
                if(m.getId()==movie.getId()){
                    throw new MovieAlreadyExists();
                }
            }
            movieList.add(movie);
            p1.setMovieList(movieList);
        }
        else{
            for(Movie m : newMovieList){
                if(m.getId()==movie.getId()){
                    throw new MovieAlreadyExists();
                }
            }
            newMovieList.add(movie);
            p1.setMovieList(newMovieList);
        }
        playlists.add(p1);
        user.setPlaylist(playlists);
        playlistRepository.save(user);
        return user;
    }

    @Override
    public User deletePlayList(String playlistName, String userEmail) throws UserNotFoundException, PlayListNameNotFoundException {
        if(playlistRepository.findById(userEmail).isEmpty())
        {
            User user = new User();
            user.setUserEmail(userEmail);
            playlistRepository.save(user);
        }

        User user = playlistRepository.findById(userEmail).get();
        List<Playlist> playlists = user.getPlaylist();
        Playlist playlist = new Playlist();
        for(Playlist p : playlists){
            if(p.getPlaylistName().equals(playlistName)){
                playlists.remove(p);
                user.setPlaylist(playlists);
                playlistRepository.save(user);
            }
        }
        return user;
    }

    @Override
    public User deleteMovieFromPlayList(int id, String playlistName, String userEmail) throws UserNotFoundException {
        if(playlistRepository.findById(userEmail).isEmpty())
        {
            User user = new User();
            user.setUserEmail(userEmail);
            playlistRepository.save(user);
        }

        System.out.println("112 in delete ");
        User user = playlistRepository.findById(userEmail).get();
        System.out.println("114 in delete ");
        List<Playlist> playlistList = user.getPlaylist();
        System.out.println("116 in delete ");
        List<Movie> movieList = new ArrayList<>();
        System.out.println("118 in delete ");
        Playlist p1 = new Playlist();
        for(Playlist p : playlistList){
            if(p.getPlaylistName().equals(playlistName)){
                p1=p;
                movieList = p1.getMovieList();
                playlistList.remove(p1);
                user.setPlaylist(playlistList);
                System.out.println("124 in delete ");
                for(Movie m : movieList){
                    if(m.getId()==id){
                        System.out.println("129 in delete ");
                        movieList.remove(m);
                        p1.setMovieList(movieList);
                        System.out.println("133 in delete ");
                        System.out.println("134 in delete ");
                        playlistList.add(p1);
                        user.setPlaylist(playlistList);
                        System.out.println("136 in delete ");
                        playlistRepository.save(user);
                        System.out.println("138 in delete ");

                    }
                }
            }
        }

        System.out.println("142 in delete ");
        return user;
    }

    @Override
    public List<Movie> getAllPlaylist(String playlistName, String userEmail) throws PlayListNameNotFoundException {
        if(playlistRepository.findById(userEmail).isEmpty())
        {
            throw new PlayListNameNotFoundException();
        }

        User user = playlistRepository.findById(userEmail).get();

        List<Playlist> playlist2 = user.getPlaylist();
        Playlist p1 = new Playlist();
        for(Playlist p : playlist2){

            if(p.getPlaylistName().equals(playlistName)){
                p1 = p;
                System.out.println("136 "+p1);

            }
        }
        System.out.println("139 "+p1.getMovieList());
        return p1.getMovieList();
//        System.out.println(playlist2);
//        return playlistRepository.getPlaylistByPlaylistName("playlist1");

    }

    @Override
    public List<String> getPlaylistName(String userEmail) throws UserNotFoundException {
        System.out.println("161 in S "+userEmail);
        if(playlistRepository.findById(userEmail).isEmpty())
        {
            User user = new User();
            user.setUserEmail(userEmail);
            playlistRepository.save(user);
        }

        User user = playlistRepository.findById(userEmail).get();
        System.out.println("163 in S "+user);
        List<String> playlistName = new ArrayList<>();
        System.out.println("165 in S "+playlistName);
        if(user.getPlaylist()==null){
            return playlistName;
        }
        else{
            for(Playlist p : user.getPlaylist())
            {
                playlistName.add(p.getPlaylistName());

            }
            return playlistName;

        }

    }

    @Override
    public User createNewPlayList(String userEmail, String playlistName) throws PlaylistNameAlreadyExists {
        System.out.println("72 in S");
        if(playlistRepository.findById(userEmail).isEmpty())
        {
            User user = new User();
            user.setUserEmail(userEmail);
            playlistRepository.save(user);
        }

        User user = playlistRepository.findById(userEmail).get();
            if (user.getPlaylist() == null) {
                List<Playlist> playlists = new ArrayList<>();
                Playlist playlist = new Playlist();
                System.out.println("196 in S");
                playlist.setPlaylistId((int) Math.random() * 1000);
                playlist.setPlaylistName(playlistName);
                System.out.println("199 in S " + playlist);

                playlists.add(playlist);
                System.out.println("202 in S " + playlists);

                user.setPlaylist(playlists);
                System.out.println("205 in S " + user);
                List<Movie> movieList = new ArrayList<>();
                playlist.setMovieList(movieList);
                System.out.println("209 in S " + playlist);
                playlistRepository.save(user);
                System.out.println("210 in S " + user);
            } else {
                List<Playlist> playlists = user.getPlaylist();
                for (Playlist p : playlists) {

                    if (p.getPlaylistName().equals(playlistName)) {

                        throw new PlaylistNameAlreadyExists();
                    }
                }
                System.out.println("76 in S");
                Playlist playlist = new Playlist();
                System.out.println("78 in S");
                playlist.setPlaylistId((int) Math.random() * 1000);

                System.out.println("80 in S");
                playlist.setPlaylistName(playlistName);
                System.out.println("82 in S");
                playlists.add(playlist);
                user.setPlaylist(playlists);
                System.out.println("91 in S");
                user.setPlaylist(playlists);
                List<Movie> movieList = new ArrayList<>();
                playlist.setMovieList(movieList);
                System.out.println("93 in S");
                playlistRepository.save(user);
                System.out.println("95 in S");


            }
        return user;


    }


}
