package com.haohhcui.demo.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haohhcui.demo.model.Demo;;

@RestController
public class RestfulController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/demo")
    public Demo dealTest(@RequestParam(value="name", defaultValue="World") String name) {
        return new Demo(counter.incrementAndGet(),
                            String.format(template, name));
    }
    @RequestMapping("/demo/test")
    public Demo dealTest1(@RequestParam(value="name", defaultValue="World") String name) {
        return new Demo(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
