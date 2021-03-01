package com.hellospringdemo.hibernate.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hellospringdemo.hibernate.entity.Contacts;
import com.hellospringdemo.hibernate.entity.Customers;
import com.hellospringdemo.hibernate.entity.Orders;

public class GetContactOrdersDemo {

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
			
			// start a transaction
			session.beginTransaction();
			
			// get the contact from db
			int id = 4;
            Contacts contact = session.get(Contacts.class, id);		
			
			System.out.println("Contact: " + contact);
			
			// get orders for the contact

            for (Orders order : contact.getOrders()) {
                System.out.println("Orders: " + order.toString());			
            }
		
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

