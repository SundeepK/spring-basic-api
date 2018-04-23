package com.sundeepk.spring.basic.api.controller;

import com.sundeepk.spring.basic.api.domain.SimpleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Component
@RestController
@RequestMapping("/test")
public class DefaultController {

    private static final Logger logger = LoggerFactory.getLogger(DefaultController.class);

    @RequestMapping(value = "/{foo}", method = GET)
    @ResponseBody
    public SimpleResponse getSimpleResponse(@PathVariable String foo,
                                            @RequestParam(required = false, defaultValue = "default", value="bar") String bar) {
        return new SimpleResponse(foo +  " " + bar);
    }

}
