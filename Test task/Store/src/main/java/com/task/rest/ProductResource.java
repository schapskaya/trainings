package com.task.rest;

import com.task.core.IProductDao;
import com.task.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Svetlana Chapskaya
 * Date: 15.01.2017
 * Time: 16:54
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/product")
public class ProductResource {
    @Autowired
    private IProductDao productDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Product> getProductsList() {
        return productDao.getAllProducts();
    }
}
