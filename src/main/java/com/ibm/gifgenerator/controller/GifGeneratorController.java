package com.ibm.gifgenerator.controller;

import com.ibm.gifgenerator.service.GifGeneratorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin")
public class GifGeneratorController {

    private final GifGeneratorService gifGeneratorService;

    public GifGeneratorController(GifGeneratorService gifGeneratorService) {
        this.gifGeneratorService = gifGeneratorService;
    }

    @GetMapping("getGif")
    public String getGif() {
        return "Gif";
    }

    @GetMapping("getUrl")
    public byte[] getUrl() throws Exception {
        return gifGeneratorService.getCurrentGif();
    }
}
