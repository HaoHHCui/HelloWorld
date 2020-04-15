package com.haohhcui.demo.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void getIndex() {
        String response = restTemplate.getForObject("/", String.class);
        System.out.println(response);
        Assert.assertEquals("Hello World!", response);
    }
}
