package com.ibm.gifgenerator.controller;

import com.google.gson.Gson;
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

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GifGeneratorController.class)
class CreateGifsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GifGeneratorService gifService;

    @Test
    void createGifs() throws Exception {

        String inputText = "International Business Machines Corporation is an American multinational technology corporation headquartered in Armonk, New York";
        Gson gson = new Gson();
        String json = gson.toJson(inputText);

        Gif gif = new Gif();
        gif.setText("International Business Machines Corporation");

        given(gifService.generateGif(inputText, gif)).willReturn(gif);

        mvc.perform(post("/api/admin/gif/generate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
    }
}
