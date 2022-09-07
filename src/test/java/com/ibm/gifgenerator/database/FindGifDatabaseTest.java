package com.ibm.gifgenerator.database;

import com.ibm.gifgenerator.entities.Gif;
import com.ibm.gifgenerator.repository.GifGeneratorRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FindGifDatabaseTest {

    @Autowired
    GifGeneratorRepository gifRepository;

    @Test
    void findGif() {
        Gif gif = new Gif(1, "Spring", "https://media4.giphy.com/media/9Og3zy3mkrsPb5DPi0/giphy.gif?cid=6d8d0b919kcfi3ht9o38lazq7dm1cevonmgwwdfou5b6vuic&rid=giphy.gif&ct=g");
        gifRepository.save(gif);

        Iterable<Gif> employees = gifRepository.findAll();
        Assertions.assertThat(employees).extracting(Gif::getText).contains("Spring");

        gifRepository.deleteAll();
        Assertions.assertThat(gifRepository.findAll()).isEmpty();
    }
}
