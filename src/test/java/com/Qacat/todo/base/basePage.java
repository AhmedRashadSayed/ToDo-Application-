package com.Qacat.todo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

public class basePage {

    protected WebDriver driver;

    public basePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }



}
