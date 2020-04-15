package com.haohhcui.demo.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RestfulController.class)
class RestfulControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getDemo()throws Exception {
    	
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/demo");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{\"id\":2,\"content\":\"Hello, World!\"}";
        System.out.println(result.getResponse().getContentAsString());
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
                

    }
    
    @Test
    public void getDemoTest()throws Exception {
    	
    	RequestBuilder requestBuilder = get("/demo/test");
        mockMvc.perform(requestBuilder)
        		              .andExpect(status().isOk())
                              .andDo(print())
                              .andExpect(jsonPath("$.content").value("Hello, World!"));
     
    }
}
