package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.domain.Customer;
import com.example.accessingdatajpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public List<Customer> findAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Transactional
    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Transactional
    public List<Customer> findCustomersByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    @Transactional
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    public void deleteCustomerById(long id) {
        customerRepository.deleteById(id);
    }

}
