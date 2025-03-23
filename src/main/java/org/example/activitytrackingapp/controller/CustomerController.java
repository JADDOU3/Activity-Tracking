package org.example.activitytrackingapp.controller;


import org.example.activitytrackingapp.entity.Customer;
import org.example.activitytrackingapp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return ResponseEntity.created(URI.create("/saveCustomer/customerId")).body(customerService.saveCustomer(customer));
    }

    @GetMapping("/getCustomerById/{id}")
    public ResponseEntity<Customer> getCustomerId(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getCustomerByEmail/{email}")
    public ResponseEntity<Customer> getCustomerEmail(@PathVariable String email) {
        Customer customer = customerService.getCustomerByEmail(email);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
