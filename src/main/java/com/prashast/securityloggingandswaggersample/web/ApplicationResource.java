package com.prashast.securityloggingandswaggersample.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationResource {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationResource.class);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        logger.info("inside test resource");
        return "test";
    }

    @RequestMapping(value = "/secured", method = RequestMethod.GET)
    public String secured(){
        logger.info("inside secured resource");
        return "secured";
    }
}
