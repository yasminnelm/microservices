package com.example.customer.service;

import com.example.customer.entity.Customer;
import com.example.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}

