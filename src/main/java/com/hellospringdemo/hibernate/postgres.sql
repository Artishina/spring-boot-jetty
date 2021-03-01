DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS contacts;
DROP TABLE IF EXISTS orders;

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