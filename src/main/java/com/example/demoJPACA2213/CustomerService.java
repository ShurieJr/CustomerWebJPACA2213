package com.example.demoJPACA2213;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }
    //operations
    public List<Customer> getAllCustomer(){
        return repo.findAll();
    }
    public Customer getCustomerById(int id){
        return repo.findById(id).orElse(null);
    }

    public void addCustomer(Customer customer){
        repo.save(customer);
    }

    public void updateCustomer(Customer customer){
        repo.save(customer);
    }
    public void deleteById(int id){
        repo.deleteById(id);
    }

}
