package com.techagile;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

/**
 * Created by chriscone on 7/20/17.
 */
public class ResponseTransformerTest {

    private ResponseTransformer responseTransformer;
    private CustomerEntity stubCustomer;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        responseTransformer = new ResponseTransformer();

        stubCustomer = new CustomerEntity();
        stubCustomer.setCustomerEmail("daffyd@gmail.com");
        stubCustomer.setCustomerId(11);
        stubCustomer.setCustomerName("Daffy Duck");
        stubCustomer.setCustomerPhone("3233984561");
    }

    @Test
    public void testThatValidObjectTransforms() throws Exception{

        ObjectNode customer = responseTransformer.camelToUnderscore(stubCustomer);
        assertNotNull(customer);

    }
}
