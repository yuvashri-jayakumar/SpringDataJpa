package com.demo.xml;


import com.demo.xml.model.Customer;
import com.demo.xml.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class XMLConfigApplication {
    public static void main(String[] args) {
       runApplicationFromXMLConfig();
    }

    private static void runApplicationFromXMLConfig() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-config.xml");
        CustomerService service = context.getBean(CustomerService.class);

        // Create
        System.out.println("CREATING CUSTOMERS");
        Customer c = new Customer();
        c.setName("Mike John");
        c.setPhone("97859");
        c.setEmail("john@citi.com");
        service.create(c);
        Customer c1 = new Customer();
        c1.setName("Narmadha");
        c1.setPhone("12345");
        c1.setEmail("narmadha@wipro.com");
        service.create(c1);
        Customer c2 = new Customer();
        c2.setName("Prem");
        c2.setPhone("85623");
        c2.setEmail("prem@citi.com");
        service.create(c2);

        // Read
        System.out.println("READING ALL THE CUSTOMERS");
        List<Customer> customers = service.findAll();
        customers.forEach(System.out::println);

        // Update
        System.out.println("Update the Customer");
        c.setEmail("john.doe@example.com");
        service.update(c);

        //FindById
        System.out.println("Find the Customer");
        service.findById(1);


    }
}