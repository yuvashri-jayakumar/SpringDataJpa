package com.demo.java;

import com.demo.java.config.JpaConfig;
import com.demo.java.model.Customer;
import com.demo.java.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class JavaConfigApplication {
    public static void main(String[] args) {
       runApplicationFromJavaConfig();
    }

    private static void runApplicationFromJavaConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
        CustomerService service = context.getBean(CustomerService.class);

        // Create
        System.out.println("CREATING CUSTOMERS");
        Customer c = new Customer();
        c.setName("Mike John");
        c.setPhone("97859");
        c.setEmail("john@citi.com");
      //  service.create(c);
        Customer c1 = new Customer();
        c1.setName("Narmadha");
        c.setPhone("12345");
        c1.setEmail("narmadha@wipro.com");
      //  service.create(c1);
        Customer c2 = new Customer();
        c2.setName("Prem");
        c.setPhone("85623");
        c2.setEmail("prem@citi.com");
        //service.create(c2);

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
        Customer customer = service.findById(1);
        System.out.println(customer);

        // Delete
        //service.deleteById(customer.getId());

        //Search
        List<Customer> customersList  = service.searchByEmail("citi");
        customersList.forEach(System.out::println);

    }


}