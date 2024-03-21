/*
 * REST controller
 */

package com.demo.azure.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping(value = "/hello/{name}")
    public String sayHello(@PathVariable String name) {
        logger.debug("Request from: {}", name);
        var hello = "Hello %s";
        return String.format(hello, name);
    }
}
