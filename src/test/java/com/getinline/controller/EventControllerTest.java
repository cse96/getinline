package com.getinline.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

class EventControllerTest {

    private final MockMvc mvc;

    public EventControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] 이벤트 리스트 페이지")
    @Test
    void givenNothing_whenRequestEventPage_thenReturnEventsPage() throws Exception{
        //Given

        //When & Then
        mvc.perform(MockMvcRequestBuilders.get("/events"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.view().name("event/index"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("events"));


    }

    @DisplayName(("[view][GET] 이벤트 세부 정보 페이지"))
    @Test
    void givenNothing_whenRequestingEventDetailPage_thenReturnsEventDetailPage() throws Exception{
        //Given
        long eventId = 1L;

        //When & Then
        mvc.perform(MockMvcRequestBuilders.get("/events/"+ eventId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.view().name("event/detail"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("events"));

    }
}