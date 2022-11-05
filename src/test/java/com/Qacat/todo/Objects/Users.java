package com.Qacat.todo.Objects;

public class Users {


    // POJO class contains only constructor and  setters and getters and variables
    private String email;
    private String FirstName;
    private String LastName;
    private String Password;


    public Users(String firstName,String lastName, String password,String email) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Password = password;
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setPassword(String password) {
        Password = password;
    }


    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPassword() {
        return Password;
    }
}
