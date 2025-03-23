package org.example.activitytrackingapp.services;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.activitytrackingapp.entity.Customer;
import org.example.activitytrackingapp.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)
public class CustomerService {


    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer getCustomerById(long id){
        return customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer Not Found!"));
    }

    public Customer getCustomerByEmail(String email){
        return customerRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("Customer Not Found!"));
    }

    public Customer saveCustomer(Customer customer){
        return customerRepo.save(customer);
    }
}
