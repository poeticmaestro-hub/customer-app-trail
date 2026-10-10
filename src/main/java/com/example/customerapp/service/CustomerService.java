package com.example.customerapp.service;

import com.example.customerapp.exception.DuplicateEmailException;
import com.example.customerapp.exception.ResourceNotFoundException;
import com.example.customerapp.model.Customer;
import com.example.customerapp.repository.CustomerRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<Customer> findAll() { return repository.findAll(); }

    @Transactional(readOnly = true)
    public Customer findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
    }

    public Customer create(Customer customer) {
        if (repository.existsByEmailIgnoreCase(customer.getEmail())) {
            throw new DuplicateEmailException("A customer with this email already exists");
        }
        try { return repository.save(customer); }
        catch (DataIntegrityViolationException ex) { throw new DuplicateEmailException("A customer with this email already exists"); }
    }

    public Customer update(Long id, Customer input) {
        Customer existing = findById(id);
        if (!existing.getEmail().equalsIgnoreCase(input.getEmail()) && repository.existsByEmailIgnoreCase(input.getEmail())) {
            throw new DuplicateEmailException("A customer with this email already exists");
        }
        existing.setFirstName(input.getFirstName());
        existing.setLastName(input.getLastName());
        existing.setEmail(input.getEmail());
        existing.setPhone(input.getPhone());
        try { return repository.save(existing); }
        catch (DataIntegrityViolationException ex) { throw new DuplicateEmailException("A customer with this email already exists"); }
    }

    public void delete(Long id) {
        Customer existing = findById(id);
        repository.delete(existing);
    }
}
