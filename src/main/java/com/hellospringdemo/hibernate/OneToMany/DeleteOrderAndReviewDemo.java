package com.hellospringdemo.hibernate.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hellospringdemo.hibernate.entity.Contacts;
import com.hellospringdemo.hibernate.entity.Customers;
import com.hellospringdemo.hibernate.entity.Orders;
import com.hellospringdemo.hibernate.entity.Review;

public class DeleteOrderAndReviewDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
                                .configure("/com/hellospringdemo/hibernate/hibernate.cfg.xml")
                                .addAnnotatedClass(Contacts.class)
                                .addAnnotatedClass(Customers.class)
                                .addAnnotatedClass(Orders.class)
                                .addAnnotatedClass(Review.class)
                                .buildSessionFactory();      
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();

			// get the order
			int id = 3;
			Orders order = session.get(Orders.class, id);
			
			// print the order
			System.out.println("Deleting the order ... ");
			System.out.println(order);
			
			// print the order reviews
			System.out.println(order.getReviews());
			
			// delete the course
			session.delete(order);
			
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

