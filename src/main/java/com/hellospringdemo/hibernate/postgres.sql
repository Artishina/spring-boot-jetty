DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS contacts;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS order_student;

CREATE TABLE customers(
   customer_id INT GENERATED ALWAYS AS IDENTITY,
   customer_name VARCHAR(255) NOT NULL,
   PRIMARY KEY(customer_id)
);

CREATE TABLE contacts(
   contact_id INT GENERATED ALWAYS AS IDENTITY,
   customer_id INT,
   contact_name VARCHAR(255) NOT NULL,
   phone VARCHAR(15),
   email VARCHAR(100),
   PRIMARY KEY(contact_id),
   CONSTRAINT fk_customer
      FOREIGN KEY(customer_id) 
	  REFERENCES customers(customer_id)
);

CREATE TABLE orders(
   id INT GENERATED ALWAYS AS IDENTITY,
   title VARCHAR(128) DEFAULT NULL,
   contact_id INT DEFAULT NULL,
   PRIMARY KEY(id),
	CONSTRAINT fk_contact
      FOREIGN KEY(contact_id) 
	  REFERENCES contacts(contact_id)
);

CREATE TABLE review(
   id INT GENERATED ALWAYS AS IDENTITY,
   com VARCHAR(256) DEFAULT NULL,
   order_id INT DEFAULT NULL,
   PRIMARY KEY(id),
	CONSTRAINT fk_order
      FOREIGN KEY(order_id) 
	  REFERENCES orders(id)
);

CREATE TABLE order_student( 
	order_id INT DEFAULT NULL,
	student_id INT DEFAULT NULL,
	
	CONSTRAINT fk_order
      FOREIGN KEY(order_id) 
	  REFERENCES orders(id),

	CONSTRAINT fk_student
      FOREIGN KEY(student_id) 
	  REFERENCES student(id)
);