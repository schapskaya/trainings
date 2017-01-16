package com.task.core;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Svetlana Chapskaya
 *         Created on 16.01.2017.
 */
@Repository
public class ProductDaoJpa {

    @PersistenceContext
    private EntityManager entityManager;
}
