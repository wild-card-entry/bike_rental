package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Email {
    @Id
    private String emailId;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
