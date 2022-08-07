package com.ibm.gifgenerator;

import at.mukprojects.giphy4j.exception.GiphyException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GifGeneratorApplication {

	public static void main(String[] args) throws GiphyException {
		SpringApplication.run(GifGeneratorApplication.class, args);
	}
}
