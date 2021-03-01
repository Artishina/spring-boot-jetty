package com.hellospringdemo.hibernate.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hellospringdemo.hibernate.entity.Contacts;
import com.hellospringdemo.hibernate.entity.Customers;
import com.hellospringdemo.hibernate.entity.Orders;

public class CreateOrdersDemo {

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

            // create some orders
            Orders order1 = new Orders("Guitar");
            Orders order2 = new Orders("Book - Data structures");

            // add orders to contact
            contact.add(order1);
            contact.add(order2);

            // save the orders
            session.save(order1);
            session.save(order2);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {

            // add clean up code
            session.close();

            factory.close();
        }
    }
}
