package com.example.customer.controller;

import com.example.customer.entity.Customer;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return service.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
        return "Customer deleted successfully";
    }
}

