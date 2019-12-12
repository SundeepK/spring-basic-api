package com.sundeepk.spring.basic.api.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class DefaultControllerTest {

    private static final String DEFAULT_PATH = "/test";

    private DefaultController underTest;


    @BeforeEach
    public void setUp() {
        underTest = new DefaultController();
    }

    @Test
    public void testItGetSimpleResponse() throws Exception {
        MockMvc mockMvc = standaloneSetup(underTest).build();

        MockHttpServletRequestBuilder param = MockMvcRequestBuilders.get(DEFAULT_PATH + "/foo?bar=someBar");

        mockMvc.perform(param)
                .andExpect((MockMvcResultMatchers.jsonPath("$.message", Matchers.containsString("foo"))))
                .andExpect((MockMvcResultMatchers.jsonPath("$.message", Matchers.containsString(""))))
                .andReturn();
    }

}
