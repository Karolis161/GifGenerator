package com.ibm.gifgenerator.controller;

import com.ibm.gifgenerator.entities.Gif;
import com.ibm.gifgenerator.service.GifGeneratorService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GifGeneratorController.class)
class GetGifsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GifGeneratorService gifService;

    @Test
    void getGifs() throws Exception {

        Gif gif = new Gif();
        gif.setText("rock man");

        List<Gif> allGifs = List.of(gif);

        given(gifService.getGifs()).willReturn(allGifs);

        mvc.perform(get("/api/admin/gif/data")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].text", is(gif.getText())));
    }
}
