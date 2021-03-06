package com.hellospringdemo.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "customer_name")
    private String customerName;

    //@OneToOne(mappedBy = "customersDetail", cascade = CascadeType.ALL)
    @OneToOne(mappedBy = "customersDetail", 
                cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
                CascadeType.REFRESH})
    private Contacts contact;

    public Customers() {

    }

    public Customers(String name) {
        customerName = name;
    }

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
    
    public Contacts getContact() {
        return contact;
    }

    public void setContact(Contacts contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "customer detail id: " + customerId + " name: " +customerName;
    }
}
