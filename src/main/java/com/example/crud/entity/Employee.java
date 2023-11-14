package com.example.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import java.util.Calendar;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String middleName;

    @Temporal(TemporalType.DATE)
    private java.util.Calendar birthDate;

    private String gender;

    private String maritalStatus;

    private String position;

    @Temporal(TemporalType.DATE)
    private java.util.Calendar dateHired;

    @Transient
    private String yearsInCompany;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        String fullName;

        if (middleName != null) {
            fullName = firstName + " " + middleName + " " + lastName;
        } else {
            fullName = firstName + " " + lastName;
        }

        return fullName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Calendar getDateHired() {
        return dateHired;
    }

    public void setDateHired(Calendar dateHired) {
        this.dateHired = dateHired;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }
}
