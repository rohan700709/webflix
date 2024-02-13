//package com.stackroute.PlaylistService.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.PlaylistService.domain.Movie;
//import com.stackroute.PlaylistService.domain.Playlist;
//import com.stackroute.PlaylistService.domain.User;
//import com.stackroute.PlaylistService.exception.PlayListNameNotFoundException;
//import com.stackroute.PlaylistService.exception.UserNotFoundException;
//import com.stackroute.PlaylistService.service.PlaylistService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@ExtendWith(MockitoExtension.class)
//public class PlaylistControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Mock
//    PlaylistService playlistService;
//
//    @InjectMocks
//    PlaylistController playlistController;
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
//        user1 = new User("anuja@gmail.com", null);
//
//        mockMvc= MockMvcBuilders.standaloneSetup(playlistController).build();
//    }
//
//    @AfterEach
//    public void tearDown(){
//        movie1 = null;
//        playlist1 = null;
//    }
//
//    private static String jsonToString(final Object o) throws JsonProcessingException
//    {
//        String result;
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            //we are converting json data into using ObjectMapper class
//            String jsonContent = mapper.writeValueAsString(o);
//            result=jsonContent;
//            return result;
//
//        }
//        catch (JsonProcessingException e)
//        {
//            result="JsonProcessingException";
//        }
//        return result;
//    }
//
//    @Test
//    public void givenPlaylistToSaveReturnSavePlaylist() throws Exception
//    {
//        when(playlistService.createPlaylist(any(), eq("anuja@gmail.com"))).thenReturn(user1);
//        mockMvc.perform(post("/api/v1/playlistservice/anuja@gmail.com")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonToString(playlist1)))
//                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
//        verify(playlistService,times(1)).createPlaylist(any(), eq("anuja@gmail.com"));
//    }
//
//    @Test
//    public void givenPlaylistToSavePlaylistFailure()throws Exception
//    {
//        when(playlistService.createPlaylist(any(), eq("anuja@gmail.com"))).thenThrow(UserNotFoundException.class);
//        mockMvc.perform(post("/api/v1/playlistservice/anuja@gmail.com")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonToString(playlist1)))
//                .andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
//        verify(playlistService,times(1)).createPlaylist(any(), eq("anuja@gmail.com"));
//    }
//
//    @Test
//    public void givenPlaylistNameDeletePlaylistSuccess() throws Exception
//    {
//        when(playlistService.deletePlayList(eq(10), eq("anuja@gmail.com"))).thenReturn(user1);
//        mockMvc.perform(delete("/api/v1/playlistservice/playlist/anuja@gmail.com/10")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//        verify(playlistService,times(1)).deletePlayList(anyInt(), anyString());
//    }
//
//    @Test
//    public void givenPlaylistNameDeletePlaylistFailure() throws Exception
//    {
//        when(playlistService.deletePlayList(eq(10), eq("anuja@gmail.com"))).thenThrow(PlayListNameNotFoundException.class);
//        mockMvc.perform(delete("/api/v1/playlistservice/playlist/anuja@gmail.com/10")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
//        verify(playlistService,times(1)).deletePlayList(anyInt(),anyString());
//    }
//
//    @Test
//    public void givenPlaylistNameGetPlaylistSuccess() throws Exception
//    {
//        when(playlistService.getAllPlaylist(anyString(), anyString())).thenReturn(Arrays.asList(user1));
//        mockMvc.perform(get("/api/v1/playlistservice/playlist/anuja@gmail.com/Favourites")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//        verify(playlistService,times(1)).getAllPlaylist(anyString(),anyString());
//    }
//
//    @Test
//    public void givenPlaylistNameGetPlaylistFailure() throws Exception
//    {
//        when(playlistService.getAllPlaylist(anyString(), anyString())).thenThrow(PlayListNameNotFoundException.class);
//        mockMvc.perform(get("/api/v1/playlistservice/playlist/anuja@gmail.com/Favourites")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isInternalServerError()).andDo(MockMvcResultHandlers.print());
//        verify(playlistService,times(1)).getAllPlaylist(anyString(),anyString());
//    }
//
//
//
//
//}
