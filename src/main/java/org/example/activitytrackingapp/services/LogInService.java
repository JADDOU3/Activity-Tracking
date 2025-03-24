package org.example.activitytrackingapp.services;


import org.example.activitytrackingapp.component.SessionManager;
import org.example.activitytrackingapp.entity.Customer;
import org.example.activitytrackingapp.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogInService {
    private SessionManager sessionManager;
    private CustomerRepo customerRepo;

    @Autowired
    public LogInService(SessionManager sessionManager, CustomerRepo customerRepo) {
        this.sessionManager = sessionManager;
        this.customerRepo = customerRepo;
    }

    public boolean logIn(String email, String password) {
        Customer customer = customerRepo.findByEmail(email).orElse(null);
        if (customer.getPassword().equals(password)) {
            sessionManager.logIn(customer);
            return true;
        }
        return false;
    }

    public void logout() {
        sessionManager.logout();
    }
}
