package com.techagile;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by chriscone on 7/20/17.
 */
public class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    private MockMvc mockMvc;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private ResponseTransformer responseTransformer;

    private CustomerEntity stubCustomer;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        customerController = new CustomerController(customerRepository, responseTransformer);
        stubCustomer = new CustomerEntity();
        stubCustomer.setCustomerEmail("daffyd@gmail.com");
        stubCustomer.setCustomerId(11);
        stubCustomer.setCustomerName("Daffy Duck");
        stubCustomer.setCustomerPhone("3233984561");
        mockMvc = MockMvcBuilders.standaloneSetup(new Object[]{this.customerController}).build();
    }

    @Test
    public void shouldReturnTheCustomer() throws Exception {
        Mockito.when(customerRepository.findOne(11)).thenReturn(stubCustomer);
        Mockito.when(responseTransformer.camelToUnderscore(stubCustomer)).thenReturn(Mockito.any(ObjectNode.class));

        mockMvc.perform(MockMvcRequestBuilders.get("/customer/11")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
