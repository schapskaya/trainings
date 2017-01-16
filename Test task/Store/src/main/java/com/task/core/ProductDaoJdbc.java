package com.task.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Svetlana Chapskaya
 *         Created on 13.01.2017.
 */
@Component
public class ProductDaoJdbc implements IProductDao {
    private static final Logger log = LoggerFactory.getLogger(ProductDaoJdbc.class);
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getAllProducts() {
        mapper.setDateFormat(DateFormat.getDateInstance(DateFormat.LONG));
        //Query customer by id
        return jdbcTemplate.query("SELECT name, price, date FROM products", new Object[]{},
                (rs, rowNum) -> {
                    Product p = new Product(rs.getString("name"), rs.getDouble("price"), rs.getDate("date"));
                    try {
                        log.info("Product info: "+mapper.writeValueAsString(p));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return  p;
                });
    }

    @Override
    public List<Map<String, Object>> getPriceHistoryForProduct(String productName) {
        return jdbcTemplate.query("SELECT price, date FROM products where name=?", new Object[]{productName},
                (rs, rowNum) -> new HashMap<String, Object>(){{
                    put("price", rs.getDouble("price"));
                    put("date", rs.getDate("date"));
                }});
    }
}
