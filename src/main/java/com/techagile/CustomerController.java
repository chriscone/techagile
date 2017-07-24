package com.techagile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chriscone on 7/20/17.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerRepository customerRepository;
    private ResponseTransformer responseTransformer;

    @Autowired
    public CustomerController(CustomerRepository customerRepository, ResponseTransformer responseTransformer) {
        this.customerRepository = customerRepository;
        this.responseTransformer = responseTransformer;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getCustomer(@PathVariable("id") int id,
                                      @RequestParam(value = "transform", required = false) boolean transform) {
        CustomerEntity customer = customerRepository.findOne(id);
        if (transform) {
            return ResponseEntity.ok(responseTransformer.camelToUnderscore(customer));
        }
        return ResponseEntity.ok(customer);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAllCustomers() {
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createCustomer(@RequestBody CustomerEntity customerEntity) {
        return ResponseEntity.ok(customerRepository.save(customerEntity));
    }
}
