package com.devbugger.jdt.web;

import com.devbugger.jdt.Calc;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    public static final String HELLO = "Hello from Docker!";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return HELLO;
    }

    @RequestMapping(value = "/calc", method = RequestMethod.GET)
    public Integer calc(@RequestParam("low") Integer low, @RequestParam("high")Integer high) {
        return new Calc().calc(high, low);
    }
}
