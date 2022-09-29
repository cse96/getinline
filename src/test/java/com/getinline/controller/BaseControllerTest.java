package com.getinline.controller;

import com.sun.deploy.uitoolkit.impl.awt.AWTClientPrintHelper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@SpringBootTest
class BaseControllerTest {

//    @BeforeEach 직전
//    void setUp() {    }
//
//    @AfterEach 직후
//    void tearDown() {    }
    @Autowired
    private MockMvc mvc;

    @Test
    void root() throws Exception {
        //Given

        //When
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(content().string(CoreMatchers.containsString("This is default page.")))
                .andExpect(view().name("index"))
                .andDo(print());
        //
    }
}