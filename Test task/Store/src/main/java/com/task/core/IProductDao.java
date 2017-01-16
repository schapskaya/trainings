package com.task.core;

import com.task.model.Product;

import java.util.List;
import java.util.Map;

/**
 * @author Svetlana Chapskaya
 *         Created on 16.01.2017.
 */
public interface IProductDao {
    List<Product> getAllProducts();
    List<Map<String, Object>> getPriceHistoryForProduct(String productName);
}
