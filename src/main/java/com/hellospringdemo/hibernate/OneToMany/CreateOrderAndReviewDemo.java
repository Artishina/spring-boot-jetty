package com.hellospringdemo.hibernate.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hellospringdemo.hibernate.entity.Contacts;
import com.hellospringdemo.hibernate.entity.Customers;
import com.hellospringdemo.hibernate.entity.Orders;
import com.hellospringdemo.hibernate.entity.Review;

public class CreateOrderAndReviewDemo {

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
						
			// create an order
			Orders order = new Orders("Pacman - How To Score One Million Points");
			
			// add some reviews
			order.addReview(new Review("Great order ... loved it!"));
			order.addReview(new Review("Cool order, job well done"));
			order.addReview(new Review("What a dumb order, you are an idiot!"));
						
			// save the order ... and leverage the cascade all :-)
			System.out.println("Saving the order");
			System.out.println(order);
			System.out.println(order.getReviews());
			
			session.save(order);
			
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
