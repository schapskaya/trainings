package com.task.core;

import com.task.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

/**
 * @author Svetlana Chapskaya
 *         Created on 16.01.2017.
 */
@Repository
public class ProductDaoImplJpa implements ProductDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getAllProducts() {
        return entityManager.;
    }

    @Override
    public List<Map<String, Object>> getPriceHistoryForProduct(String productName) {
        return null;
    }
}
