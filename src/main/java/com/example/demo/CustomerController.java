package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/customer")
    public
    @ResponseBody Iterable<Customer> getAllCustomers()
    {
        return customerRepository.findAll();
    }
    @PostMapping("/customer")
    public
    @ResponseBody String addCustomer(Customer customer)
    {
        customerRepository.save(customer);
        return "Saved";
    }



}
