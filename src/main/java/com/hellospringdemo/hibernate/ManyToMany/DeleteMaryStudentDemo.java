package com.hellospringdemo.hibernate.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hellospringdemo.hibernate.entity.Contacts;
import com.hellospringdemo.hibernate.entity.Customers;
import com.hellospringdemo.hibernate.entity.Orders;
import com.hellospringdemo.hibernate.entity.Review;
import com.hellospringdemo.hibernate.entity.Student;

public class DeleteMaryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
							    .configure("/com/hellospringdemo/hibernate/hibernate.cfg.xml")
                                .addAnnotatedClass(Contacts.class)
                                .addAnnotatedClass(Customers.class)
                                .addAnnotatedClass(Orders.class)
                                .addAnnotatedClass(Review.class)
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
				
			// get the student from database
			int studentId = 8;
			Student student = session.get(Student.class, studentId);
			
			System.out.println("\nLoaded student: " + student);
			System.out.println("Courses: " + student.getOrders());		
		
			// delete student
			System.out.println("\nDeleting student: " + student);
			session.delete(student);
			
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

