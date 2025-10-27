package com.demo.xml.service;

import com.demo.xml.model.Customer;
import com.demo.xml.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public void create(Customer customer){
        Customer customer1 = customerRepository.save(customer);
        System.out.println("Customer created successfully" + customer1.getId());
    }

    @Transactional
    public void update(Customer customer){
        customerRepository.save(customer);
    }

    public Customer findById(int id){
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }
}
