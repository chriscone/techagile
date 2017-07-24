package com.techagile;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by chriscone on 7/20/17.
 */
@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer>{

}
