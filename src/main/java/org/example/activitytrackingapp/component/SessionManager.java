package org.example.activitytrackingapp.component;

import org.example.activitytrackingapp.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class SessionManager {
    private static Customer customer ;

    public void logIn(Customer customer) {
        this.customer = customer;
    }

    public void logout() {
        this.customer = null;
    }

    public static Customer getCurrentCustomer() {
        return customer;
    }

    public boolean isLoggedIn() {
        return customer != null;
    }
}
