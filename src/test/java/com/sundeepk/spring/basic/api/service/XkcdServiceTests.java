package com.sundeepk.spring.basic.api.service;

import com.sundeepk.spring.basic.api.domain.XkcdComic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static com.sundeepk.spring.basic.api.service.XkcdService.LATEST_XKCD_ENDPOINT;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class XkcdServiceTests {

    private XkcdService underTest;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp(){
        underTest = new XkcdService(restTemplate);
    }

    @Test
    void itShouldFetchLatestXkcdComic(){

        // when
        underTest.getLatestComic();

        // then
        verify(restTemplate).getForObject(LATEST_XKCD_ENDPOINT, XkcdComic.class);
    }


}
