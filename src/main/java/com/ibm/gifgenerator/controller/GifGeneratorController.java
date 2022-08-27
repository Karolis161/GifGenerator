package com.ibm.gifgenerator.controller;

import com.ibm.gifgenerator.entities.Gif;
import com.ibm.gifgenerator.service.GifGeneratorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/gif")
public class GifGeneratorController {

    private final GifGeneratorService gifGeneratorService;

    public GifGeneratorController(GifGeneratorService gifGeneratorService) {
        this.gifGeneratorService = gifGeneratorService;
    }

    @GetMapping("data")
    public List<Gif> getGif() {
        return gifGeneratorService.getGifs();
    }

    @PostMapping("generate")
    public void generateGif(@RequestBody String inputText, Gif gif) throws Exception {
        gifGeneratorService.generateGif(inputText, gif);
    }
}
