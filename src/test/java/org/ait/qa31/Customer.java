package org.ait.qa31;

public class Customer {
    private String email;
    private String password;

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public Customer setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
