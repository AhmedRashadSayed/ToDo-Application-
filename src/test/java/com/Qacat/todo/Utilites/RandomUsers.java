package com.Qacat.todo.Utilites;

import com.Qacat.todo.Objects.Users;
import com.github.javafaker.Faker;

public  class RandomUsers {

    public static Users GenerateRandomUser()
    {
        String FirstName = new Faker().name().firstName();
        String LastName  = new Faker().name().lastName();
        String Password  = new Faker().internet().password();
        String Email     = new Faker().internet().emailAddress();
        Users user       = new Users(FirstName,LastName,Password,Email);
        return user;

    }



}
