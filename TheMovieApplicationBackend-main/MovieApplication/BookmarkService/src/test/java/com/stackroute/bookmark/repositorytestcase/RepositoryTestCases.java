//package com.stackroute.bookmark.repositorytestcase;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.bookmark.controller.BookmarkController;
//import com.stackroute.bookmark.model.Bookmark;
//import com.stackroute.bookmark.model.Movie;
//import com.stackroute.bookmark.model.User;
//import com.stackroute.bookmark.repository.BookmarkRepository;
//import com.stackroute.bookmark.service.BookmarkService;
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
//
//import static com.mongodb.assertions.Assertions.assertNotNull;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
//
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class RepositoryTestCases {
//
//    @Autowired
//    BookmarkRepository bookmarkRepository;
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
//        //mockMvc= MockMvcBuilders.standaloneSetup(bookmarkRepository).build();
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
//    @Test
//    public void givenBookmarkToSaveReturnBookmark(){
//        bookmarkRepository.save(user1);
//        User user = bookmarkRepository.findById(user1.getUserEmail()).get();
//        assertNotNull(user);
//        assertThat(Arrays.asList(user1.getBookmark()).equals(Arrays.asList(user.getBookmark()))).isTrue();
//    }
//
//    @Test
//    public void givenBookmarkToSaveReturnBookmarkNotTrue(){
//        bookmarkRepository.save(user1);
//        User user = bookmarkRepository.findById(user1.getUserEmail()).get();
//        assertNotNull(user);
//        assertThat(Arrays.asList("Ram").equals(Arrays.asList(user.getBookmark()))).isFalse();
//    }
//
//
//
//}
