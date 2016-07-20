package hello.rest;

import hello.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Svetlana Chapskaya
 *         Created on 20.07.2016.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Customer> getCustomerById(@PathVariable("id") String id){
        //Query customer by id
        return jdbcTemplate.query("SELECT id, first_name, last_name FROM customers WHERE id=?", new Object[]{id},
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")));
    }
}
