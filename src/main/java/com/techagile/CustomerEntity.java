package com.techagile;

import javax.persistence.*;

/**
 * Created by chriscone on 7/20/17.
 */
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int customerId;

    @Column(name = "name")
    private String customerName;

    @Column(name = "email")
    private String customerEmail;

    @Column(name = "phone")
    private String customerPhone;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
