//package com.stackroute.PlaylistService.repository;
//
//import com.stackroute.PlaylistService.controller.PlaylistController;
//import com.stackroute.PlaylistService.domain.Movie;
//import com.stackroute.PlaylistService.domain.Playlist;
//import com.stackroute.PlaylistService.domain.User;
//import com.stackroute.PlaylistService.service.PlaylistService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static com.mongodb.assertions.Assertions.assertNotNull;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
//
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class PlaylistRepositoryTest {
//
//    @Autowired
//    private PlaylistRepository playlistRepository;
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
//        user1 = new User("anuja@gmail.com", null);
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
//    public void givenPlaylistToSaveReturnPlaylist(){
//        playlistRepository.save(user1);
//        User user = playlistRepository.findById(user1.getUserEmail()).get();
//        assertNotNull(user);
//        assertThat(Arrays.asList(user1.getPlaylist()).equals(Arrays.asList(user.getPlaylist()))).isTrue();
//    }
//
//    @Test
//    public void givenPlaylistToSaveReturnPlaylistNotTrue(){
//        playlistRepository.save(user1);
//        User user = playlistRepository.findById(user1.getUserEmail()).get();
//        assertNotNull(user);
//        assertThat(Arrays.asList("anuja").equals(Arrays.asList(user.getPlaylist()))).isFalse();
//    }
//
////    @Test
////    public void givenTrackReturnAllProduct(){
////        playlistRepository.save(user1);
////        User userList = playlistRepository.findAll();
////        assertEquals(1,userList);
////        assertEquals("Mobile", .get(0).getProductName());
////    }
//}
