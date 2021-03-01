package com.hellospringdemo.hibernate.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hellospringdemo.hibernate.entity.Contacts;
import com.hellospringdemo.hibernate.entity.Customers;
import com.hellospringdemo.hibernate.entity.Orders;

public class CreateContactDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
                                .configure("/com/hellospringdemo/hibernate/hibernate.cfg.xml")
								.addAnnotatedClass(Contacts.class)
								.addAnnotatedClass(Customers.class)
                                .addAnnotatedClass(Orders.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// create the objects	
            Contacts contact = new Contacts("Susan", "Public", "susan.public@luv2code.com");
            
            Customers customer = new Customers("http://www.youtube.com");		
			
			// associate the objects
			contact.setCustomersDetail(customer);
			
			// start a transaction
			session.beginTransaction();
			
			// save the contact
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving contact: " + contact);
			session.save(contact);					
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}

