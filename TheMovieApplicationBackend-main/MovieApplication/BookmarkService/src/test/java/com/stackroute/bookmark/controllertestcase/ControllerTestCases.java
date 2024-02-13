//package com.stackroute.bookmark.controllertestcase;
//
//import com.stackroute.bookmark.controller.BookmarkController;
//import com.stackroute.bookmark.exception.BookmarkNameNotFoundException;
//import com.stackroute.bookmark.exception.UserNotFoundException;
//import com.stackroute.bookmark.model.Bookmark;
//import com.stackroute.bookmark.model.Movie;
//import com.stackroute.bookmark.model.User;
//import com.stackroute.bookmark.service.BookmarkService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.PropertyEditorRegistrySupport;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@ExtendWith(MockitoExtension.class)
//public class ControllerTestCases {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Mock
//    BookmarkService bookmarkService;
//
//    @InjectMocks
//    BookmarkController bookmarkController;
//
//    private Movie movie1;
//    private Bookmark bookmark1;
//    User user1=new User("Ram@gmail.com",null);
//
//    @BeforeEach
//    public void setUp(){
//
//        movie1=new Movie(12,"Titanic","Rambo","Action",4.5F);
//        bookmark1=new Bookmark(121,"English",movie1);
//        List<Bookmark> bookmark2=new ArrayList<>();
//        bookmark2.add(bookmark1);
//        user1=new User("Ram@gmail.com",null);
//
//
//        mockMvc= MockMvcBuilders.standaloneSetup(bookmarkController).build();
//    }
//
//    @AfterEach
//    public void tearDown(){
//        movie1=null;
//        bookmark1=null;
//    }
//
//    private static String jsonToString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            return "Error Processing JSON !!";
//        }
//    }
//
//
//        @Test
//    public void givenBookmarkToSaveReturnSaveBookmark()throws Exception
//    {
//        when(bookmarkService.createBookmark(any(),eq("Ram@gmail.com"))).thenReturn(user1);
//        mockMvc.perform(post("/api/v1/bookmarkservice/Ram@gmail.com")
//        .contentType(MediaType.APPLICATION_JSON)
//        .content(jsonToString(bookmark1)))
//                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
//        verify(bookmarkService,times(1)).createBookmark(any(), eq("Ram@gmail.com"));
//    }
//
//    @Test
//    public void givenBookmarkToSaveBookmarkFailure()throws Exception
//    {
//        when(bookmarkService.createBookmark(any(), eq("Ram@gmail.com"))).thenThrow(UserNotFoundException.class);
//        mockMvc.perform(post("/api/v1/bookmarkservice/Ram@gmail.com")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonToString(bookmark1)))
//                .andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
//        verify(bookmarkService,times(1)).createBookmark(any(), eq("Ram@gmail.com"));
//    }
//
//    @Test
//    public void givenBookmarkNameDeleteBookmarkSuccess() throws Exception
//    {
//        when(bookmarkService.deleteBookmark(eq(121), eq("Ram@gmail.com"))).thenReturn(user1);
//        mockMvc.perform(delete("/api/v1/bookmarkservice/bookmark/Ram@gmail.com/121")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//        verify(bookmarkService,times(1)).deleteBookmark(anyInt(), anyString());
//    }
//
//    @Test
//    public void givenBookmarkNameDeleteBookmarkFailure() throws Exception
//    {
//        when(bookmarkService.deleteBookmark(eq(121), eq("Ram@gmail.com"))).thenThrow(BookmarkNameNotFoundException.class);
//        mockMvc.perform(delete("/api/v1/bookmarkservice/bookmark/Ram@gmail.com/121")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
//        verify(bookmarkService,times(1)).deleteBookmark(anyInt(),anyString());
//    }
//
//    @Test
//    public void givenBookmarkNameGetBookmarkSuccess() throws Exception
//    {
//        when(bookmarkService.getAllBookmark(anyString(), anyString())).thenReturn(Arrays.asList(user1));
//        mockMvc.perform(get("/api/v1/bookmarkservice/bookmark/Ram@gmail.com/English")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//        verify(bookmarkService,times(1)).getAllBookmark(anyString(),anyString());
//    }
//
//    @Test
//    public void givenBookmarkNameGetBookmarkFailure() throws Exception
//    {
//        when(bookmarkService.getAllBookmark(anyString(), anyString())).thenThrow(BookmarkNameNotFoundException.class);
//        mockMvc.perform(get("/api/v1/bookmarkservice/bookmark/Ram@gmail.com/English")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isInternalServerError()).andDo(MockMvcResultHandlers.print());
//        verify(bookmarkService,times(1)).getAllBookmark(anyString(),anyString());
//    }
//
////    @Test
////    public void givenProductCodeShouldReturnProduct() throws Exception {
////        when(bookmarkService.getAllBookmark(book.getBookmarkName(), user.getUserEmail())).thenReturn(java.util.Optional.ofNullable.get());
////
////        mockMvc.perform(get("/api/v1/profile/aishwarya@gmail.com")).andExpect(status().isFound()).andDo(MockMvcResultHandlers.print());
////
////        verify(ideapreneurProfileService, times(1)).getProfile(anyString());
////    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
