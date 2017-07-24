package com.techagile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Component;

/**
 * Created by chriscone on 7/20/17.
 */
@Component
public class ResponseTransformer {

    public ObjectNode camelToUnderscore(CustomerEntity customerEntity) {
        ObjectNode customer = new ObjectMapper().createObjectNode();
        customer.put("customer_id", customerEntity.getCustomerId());
        customer.put("customer_name", customerEntity.getCustomerName());
        customer.put("customer_email", customerEntity.getCustomerEmail());
        customer.put("customer_phone", customerEntity.getCustomerPhone());

        return customer;
    }
}
