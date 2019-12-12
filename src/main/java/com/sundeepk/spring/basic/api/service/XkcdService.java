package com.sundeepk.spring.basic.api.service;

import com.sundeepk.spring.basic.api.domain.XkcdComic;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class XkcdService {

    public static final String LATEST_XKCD_ENDPOINT = "https://xkcd.com/info.0.json";
    private RestTemplate restTemplate;

    public XkcdService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public XkcdComic getLatestComic(){
        return restTemplate.getForObject(LATEST_XKCD_ENDPOINT, XkcdComic.class);
    }
}
