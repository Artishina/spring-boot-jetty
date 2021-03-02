package com.hellospringdemo.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private int contactId;

    @OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
    private Customers customersDetail;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contactsDetail",
                cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                CascadeType.DETACH, CascadeType.REFRESH})
    private List<Orders> orders;

    public Contacts() {

    }

    public Contacts(String contactName, String phone, String email) {
        this.contactName = contactName;
        this.phone = phone;
        this.email = email;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }


    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    

    public Customers getCustomersDetail() {
        return customersDetail;
    }

    public void setCustomersDetail(Customers customersDetail) {
        this.customersDetail = customersDetail;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "contact detail id: " + contactId + " contact_name " + contactName
            + " phone: " + phone + " email: " + email;
    }

    // add convenience methods for bi-directional relationship
	public void add(Orders order) {
		
		if (orders == null) {
			orders = new ArrayList<>();
		}
		
		orders.add(order);
		
		order.setContactsDetail(this);
	}
}
