package com.hellospringdemo.hibernate.OneToMany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hellospringdemo.hibernate.entity.Contacts;
import com.hellospringdemo.hibernate.entity.Customers;
import com.hellospringdemo.hibernate.entity.Orders;

public class GetOrdersLater {

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
            
            // commit transaction
            session.getTransaction().commit();
            
            // close the session
            session.close();

            System.out.println("\n: The session is now closed!\n");

            //
            // THIS HAPPENS SOMEWHERE ELSE / LATER IN THE PROGRAM

            // YOU NEED TO GET A NEW SESSION
            //
            
            System.out.println("\n\n: Opening a NEW session \n");

            session = factory.getCurrentSession();
            
            session.beginTransaction();
            
            // get courses for a given instructor
            Query<Orders> query = session.createQuery("select o from Orders o "
                                                    + "where o.contactsDetail.contactId=:ContactId",    
                                                    Orders.class);
            
            query.setParameter("ContactId", id);
            
            List<Orders> order = query.getResultList();
            
            System.out.println("orders: " + order);
            
            // now assign to instructor object in memory
            contact.setOrders(order);
            
            System.out.println("Courses: " + contact.getOrders());
            
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
