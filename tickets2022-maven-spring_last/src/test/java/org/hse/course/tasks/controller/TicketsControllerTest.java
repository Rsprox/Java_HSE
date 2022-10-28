package org.hse.course.tasks.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.hse.course.tasks.dto.BaseResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class TicketsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @SneakyThrows
    public void testFour() {
        //given
        ObjectMapper mapper = new ObjectMapper();

        //when
        ResultActions result = mvc.perform(get("/tickets/four").contentType(MediaType.APPLICATION_JSON));

        //then
        result.andExpect(status().isOk());
        BaseResponse baseResponse = mapper.readValue(result.andReturn().getResponse().getContentAsString(), BaseResponse.class);
        assertEquals(670, baseResponse.getResult());
    }

}