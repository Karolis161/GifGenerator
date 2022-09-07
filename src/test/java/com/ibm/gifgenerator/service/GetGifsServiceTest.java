package com.ibm.gifgenerator.service;

import com.ibm.gifgenerator.entities.Gif;
import com.ibm.gifgenerator.repository.GifGeneratorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetGifsServiceTest {

    @InjectMocks
    GifGeneratorService gifService;

    @Mock
    GifGeneratorRepository gifRepository;

    @Test
    void getGifs() {
        List<Gif> gifList = new ArrayList<Gif>();
        Gif gifOne = new Gif(1, "Spring", "https://media4.giphy.com/media/9Og3zy3mkrsPb5DPi0/giphy.gif?cid=6d8d0b919kcfi3ht9o38lazq7dm1cevonmgwwdfou5b6vuic&rid=giphy.gif&ct=g");
        Gif gifTwo = new Gif(2, "single button", "https://media2.giphy.com/media/lHopDSa890Mc6MG1yd/giphy.gif?cid=6d8d0b912iakdihd70v2unjkmxeeuakap8fvqi78pvzaxvvy&rid=giphy.gif&ct=g");
        Gif gifThree = new Gif(3, "International Business Machines Corporation", "https://media0.giphy.com/media/b5AQ4SXB83yEWTfh47/giphy.gif?cid=6d8d0b910kx3sgqef1ub0flsunumik0jx4uf6qzxm3bley6g&rid=giphy.gif&ct=g");

        gifList.add(gifOne);
        gifList.add(gifTwo);
        gifList.add(gifThree);

        when(gifRepository.findAll()).thenReturn(gifList);
        List<Gif> empList = gifService.getGifs();

        assertEquals(3, empList.size());
        verify(gifRepository, times(1)).findAll();
    }
}
