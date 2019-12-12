package com.sundeepk.spring.basic.api.controller;

import com.sundeepk.spring.basic.api.domain.XkcdComic;
import com.sundeepk.spring.basic.api.service.XkcdService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/xkcd")
@RestController
public class XkcdComicsController {

    private XkcdService xkcdService;

    public XkcdComicsController(final XkcdService xkcdService) {
        this.xkcdService = xkcdService;
    }

    @RequestMapping("/latest")
    public XkcdComic getLatestComic(){
        return xkcdService.getLatestComic();
    }
}
