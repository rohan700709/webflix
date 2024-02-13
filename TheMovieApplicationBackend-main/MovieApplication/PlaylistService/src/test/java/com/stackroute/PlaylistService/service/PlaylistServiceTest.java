//package com.stackroute.PlaylistService.service;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.PlaylistService.controller.PlaylistController;
//import com.stackroute.PlaylistService.domain.Movie;
//import com.stackroute.PlaylistService.domain.Playlist;
//import com.stackroute.PlaylistService.domain.User;
//import com.stackroute.PlaylistService.exception.PlayListNameNotFoundException;
//import com.stackroute.PlaylistService.exception.UserNotFoundException;
//import com.stackroute.PlaylistService.repository.PlaylistRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class PlaylistServiceTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Mock
//    PlaylistRepository playlistRepository;
//
//    @InjectMocks
//    PlayListServiceImpl playlistServiceImpl;
//
//    private Movie movie1;
//    private Playlist playlist1;
//    User user1 = new User("anuja@gmail.com", null);
//
//    @BeforeEach
//    public void setUp(){
//        movie1 = new Movie(1, "Rockstar", "Ranveer Kapoor", "Action", 4.5f);
//        List<Movie> movieList1 = new ArrayList<>();
//        movieList1.add(movie1);
//        playlist1 = new Playlist(10, "Favourites", movieList1);
//        List<Playlist> playlist2 = new ArrayList<>();
//        playlist2.add(playlist1);
//
//
//    }
//
//    @AfterEach
//    public void tearDown(){
//        movie1 = null;
//        playlist1 = null;
//    }
//
//    @Test
//    public void givenPlaylistToSaveReturnSavedPlaylist() throws UserNotFoundException
//    {
//        when(playlistRepository.findById(user1.getUserEmail())).thenReturn(Optional.ofNullable(user1));
//        when(playlistRepository.save(any())).thenReturn(user1);
//        assertEquals(user1,playlistServiceImpl.createPlaylist(playlist1, user1.getUserEmail()));
//        verify(playlistRepository,times(1)).save(user1);
//        verify(playlistRepository,times(3)).findById(user1.getUserEmail());
//    }
//
////    @Test
////    public void givenProductToSaveReturnProductFailure(){
////        when(playlistRepository.findById(user1.getUserEmail())).thenReturn(Optional.ofNullable(user1));
////        assertThrows(UserNotFoundException.class,()->playlistServiceImpl.createPlaylist(playlist1, user1.getUserEmail()));
////        verify(playlistRepository,times(0)).save(any());
////        verify(playlistRepository,times(1)).findById(any());
////    }
////
////    @Test
////    public void givenPlaylistToDeleteShouldDeleteSuccess() throws UserNotFoundException, PlayListNameNotFoundException {
////        when(playlistRepository.findById(user1.getUserEmail())).thenReturn(Optional.ofNullable(user1));
////        User user2 =playlistServiceImpl.deletePlayList(playlist1.getPlaylistId(), user1.getUserEmail());
////        assertEquals(user1, user2);
////        verify(playlistRepository,times(1)).findById(any());
////        verify(playlistRepository,times(1)).deleteById(any());
////    }
//
//    @Test
//    public void givenPlaylistToDeleteShouldDeleteFailure() throws UserNotFoundException {
//        when(playlistRepository.findById(user1.getUserEmail())).thenReturn(Optional.ofNullable(null));
//        assertThrows(UserNotFoundException.class,()->playlistServiceImpl.deletePlayList(playlist1.getPlaylistId(),user1.getUserEmail()));
//        verify(playlistRepository,times(1)).findById(any());
//        verify(playlistRepository,times(0)).deleteById(any());
//    }
////
////    @Test
////    public void givenProductToGetAllDetails() throws PlayListNameNotFoundException {
////        List<User> userList=new ArrayList<>();
////        userList.add(user1);
////        when(playlistRepository.getPlaylistByPlaylistName(playlist1.getPlaylistName())).thenReturn(userList);
////        List<User> productListExpected = playlistServiceImpl.getAllPlaylist(playlist1.getPlaylistName(), user1.getUserEmail());
////        assertEquals(productListExpected, userList);
////    }
//
//
////    @Test
////    public void givenProductToGetAllDetailsFailure() throws PlayListNameNotFoundException {
////        List<User> userList=new ArrayList<>();
////        userList.add(user1);
////        when(playlistRepository.getPlaylistByPlaylistName(playlist1.getPlaylistName())).thenReturn(userList);
////        assertThrows(PlayListNameNotFoundException.class, ()->playlistServiceImpl.getAllPlaylist(playlist1.getPlaylistName(), user1.getUserEmail()));
////    }
//
//}
