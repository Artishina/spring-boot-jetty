package com.hellospringdemo.hibernate.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hellospringdemo.hibernate.entity.Contacts;
import com.hellospringdemo.hibernate.entity.Customers;

public class DeleteCustomerDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
                                .configure("/com/hellospringdemo/hibernate/hibernate.cfg.xml")
								.addAnnotatedClass(Contacts.class)
								.addAnnotatedClass(Customers.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();

			// get the customer detail object
			int theId = 3;  
			Customers customer = 
					session.get(Customers.class, theId);
			
			// print the customer detail
			System.out.println("customer: " + customer);
						
			// print  the associated contact
			System.out.println("the associated contact: " + 
								customer.getContact());

            // remove the associated object reference
			// break bi-directional link

            customer.getContact().setCustomersDetail(null);

            // now let's delete the instructor detail
			System.out.println("Deleting customer: " 
            + customer);

            session.delete(customer);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			
			factory.close();
		}
	}

}

