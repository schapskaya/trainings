package com.task.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Svetlana Chapskaya
 *         Created on 12.01.2017.
 */
@RestController
@RequestMapping("/product")
public class PricesResource {
    private static final Logger log = LoggerFactory.getLogger(PricesResource.class);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getProductById(@PathVariable("id") String id){
        //Query customer by id
        return "Product "+id;
    }
}
