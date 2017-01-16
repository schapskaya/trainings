package com.task.rest;

import com.task.core.IProductDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * @author Svetlana Chapskaya
 *         Created on 12.01.2017.
 */
@RestController
@RequestMapping("/prices")
public class PricesResource {
    private static final Logger log = LoggerFactory.getLogger(PricesResource.class);

    @Autowired
    private IProductDao productDao;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public @ResponseBody List<Map<String,Object>> getProductById(@RequestParam(value = "name", defaultValue = "") String productName,
                                                   TimeZone timeZone, HttpServletRequest request, HttpSession httpSession){
        log.info("TimeZone: "+timeZone);
        log.info("HttpServletRequest: "+request);
        log.info("HttpSession: "+httpSession);
        return productDao.getPriceHistoryForProduct(productName);
    }
}
