package com.ibm.gifgenerator;

import com.ibm.gifgenerator.controller.GifGeneratorController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GifGeneratorApplicationTests {

	@Autowired
	private GifGeneratorController controller;

	@Test
	void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}
}
