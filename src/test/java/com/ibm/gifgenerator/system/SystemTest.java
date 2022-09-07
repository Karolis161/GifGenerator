package com.ibm.gifgenerator.system;

import com.ibm.gifgenerator.entities.Gif;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

class SystemTest {

    @Test
    void postGetGif() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/admin/gif";

        Gif gif = new Gif(1, "Spring",
                "https://media4.giphy.com/media/9Og3zy3mkrsPb5DPi0/giphy.gif?cid=6d8d0b919kcfi3ht9o38lazq7dm1cevonmgwwdfou5b6vuic&rid=giphy.gif&ct=g");
        ResponseEntity<Gif> entity = restTemplate.postForEntity(url + "/generate", gif, Gif.class);

        Gif[] employees = restTemplate.getForObject(url + "/data", Gif[].class);
        Assertions.assertThat(employees).extracting(Gif::getText).contains("Spring");
    }
}
