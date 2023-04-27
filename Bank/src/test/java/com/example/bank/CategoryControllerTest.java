package com.example.bank;

import com.example.bank.models.Category;
import com.example.bank.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
//@AutoConfigureMockMvc
//public class CategoryControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private CategoryRepository mockRepository;
//
//    @BeforeEach
//    public void init() {
//        Category cat1 = new Category(1L, "Gigachad medlem");
//        Category cat2 = new Category(2L, "Power ranger medlem");
//        Category cat3 = new Category(3L, "Magikarp medlem");
//
//        when(mockRepository.findById(1L)).thenReturn(Optional.of(cat1));
//        when(mockRepository.findById(2L)).thenReturn(Optional.of(cat2));
//        when(mockRepository.findById(3L)).thenReturn(Optional.of(cat3));
//        when(mockRepository.findAll()).thenReturn(Arrays.asList(cat1, cat2, cat3));
//    }
//
//    @Test
//    void getCategoryByTest() throws Exception {
//        this.mvc.perform(get("/category/get/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().json("{\"id\":1, \"category\":\"Gigachad medlem\"}"));
//    }
//
//    @Test
//    void addCategoryByTest() throws Exception {
//        this.mvc.perform(get("/category/add/gigachick"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("Category gigachick created")));
//    }
//
//    @Test
//    void deleteCategoryByTest() throws Exception {
//        this.mvc.perform(get("/category/delete/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("deleted")));
//    }
//
//    @Test
//    void addByPostTest() throws Exception {
//        this.mvc.perform(post("/category/add")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"id\": null, \"category\": \"gigabiga\"}"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("Category gigabiga created")));
//    }
// }
