//package com.stackroute.bookmark.servicetestcase;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.bookmark.controller.BookmarkController;
//import com.stackroute.bookmark.exception.BookmarkNameNotFoundException;
//import com.stackroute.bookmark.exception.UserNotFoundException;
//import com.stackroute.bookmark.model.Bookmark;
//import com.stackroute.bookmark.model.Movie;
//import com.stackroute.bookmark.model.User;
//import com.stackroute.bookmark.repository.BookmarkRepository;
//import com.stackroute.bookmark.service.BookmarkService;
//import com.stackroute.bookmark.service.BookmarkServiceImpl;
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
//
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import org.bson.types.ObjectId;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//@ExtendWith(MockitoExtension.class)
//public class ServiceTestCases {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Mock
//    private BookmarkRepository bookmarkRepository;
//
//    @InjectMocks
//    private BookmarkServiceImpl bookmarkService;
//
//    private Movie movie1;
//    private Bookmark bookmark1;
//    User user1=new User("Ram@gmail.com",null);
//
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
//        mockMvc= MockMvcBuilders.standaloneSetup(bookmarkService).build();
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
//
////    @Test
////	public void givenBookmarkToSaveReturnSavedBookmarkFailure(){
////        when(bookmarkRepository.findById(user1.getUserEmail())).thenReturn(Optional.ofNullable(user1));
////        when(bookmarkRepository.save(any())).thenReturn(user1);
////		assertThrows(UserNotFoundException.class,()->bookmarkService.deleteBookmark(bookmark1.getBookmarkId(),user1.getUserEmail()));
////		verify(bookmarkRepository,times(0)).save(user1);
////		verify(bookmarkRepository,times(1)).findById(user1.getUserEmail());
////	}
//
//
//
//    @Test
//	public void givenBookmarkToSaveReturnSavedBookmark() throws UserNotFoundException, BookmarkNameNotFoundException {
//        when(bookmarkRepository.findById(user1.getUserEmail())).thenReturn(Optional.ofNullable(user1));
//        when(bookmarkRepository.save(any())).thenReturn(user1);
//        assertEquals(user1,bookmarkService.createBookmark(bookmark1,user1.getUserEmail()));
//		verify(bookmarkRepository,times(1)).save(user1);
//		verify(bookmarkRepository,times(3)).findById(user1.getUserEmail());
//
//	}
//
////    @Test
////	public void givenBookmarkToDeleteShouldDeleteSuccess()throws UserNotFoundException, BookmarkNameNotFoundException {
////		when(bookmarkRepository.findById(user1.getUserEmail())).thenReturn(Optional.ofNullable(user1));
////		when(bookmarkRepository.save(any())).thenReturn(user1);
////		assertEquals(user1,bookmarkService.deleteBookmark(eq(121),user1.getUserEmail()));
////		verify(bookmarkRepository,times(1)).deleteById(user1.getUserEmail());
////		verify(bookmarkRepository,times(3)).findById(user1.getUserEmail());
////
////	}
//
//
//    @Test
//	public void givenBookmarkToDeleteShouldDeleteFailure() {
//		when(bookmarkRepository.findById(user1.getUserEmail())).thenReturn(Optional.ofNullable(null));
//		assertThrows(UserNotFoundException.class,()->bookmarkService.deleteBookmark(bookmark1.getBookmarkId(),user1.getUserEmail()));
//	}
//
//
//
//}
