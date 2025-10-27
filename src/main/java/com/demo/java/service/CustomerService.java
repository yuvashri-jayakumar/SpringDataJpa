package com.demo.java.service;

import com.demo.java.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {


    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void create(Customer customer){
        entityManager.persist(customer);
        System.out.println("Customer created successfully with id ... " + customer.getId());
    }

    @Transactional
    public void update(Customer customer){
        entityManager.merge(customer);
        System.out.println("Customer updated successfully with id ...  " + customer.getId());
    }

    public Customer findById(int id){
       return entityManager.find(Customer.class,id);
    }

    public List<Customer> findAll() {
        List<Customer> customers = entityManager.createQuery("from Customer", Customer.class).getResultList();
        return customers;
    }

    @Transactional
    public void deleteById(int id){
       Customer customer =  entityManager.find(Customer.class,id);
        if(customer != null) {
            entityManager.remove(customer);
        }

    }

    public List<Customer> searchByEmail(String email){
        Query query = entityManager.createQuery("from Customer where email like :email", Customer.class);
        query.setParameter("email","%"+email+"%");
        System.out.println(query);
        List resultList = query.getResultList();
        return resultList;
    }

}
