package com.Qacat.todo.pages;

import com.Qacat.todo.Utilites.configUtils;
import com.Qacat.todo.Utilites.propertiesUtils;
import com.Qacat.todo.base.basePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import java.io.FileNotFoundException;
import java.util.Properties;

public class LoginPage extends basePage {

    public LoginPage(WebDriver driver) {
    super(driver);

    }

    @FindBy(css = "[data-testid=\"email\"]")
    private WebElement emailInput;

    @FindBy(css = "[data-testid=\"password\"]")
    private WebElement passwordInput;

    @FindBy(css = "[data-testid=\"submit\"]")
    private WebElement submit;


    @Step   // to add steps in your report will take the name of function
    public LoginPage load()  {
        //driver.get("https://todo.qacart.com/login");
        //driver.get("https://qacart-todo.herokuapp.com/");

        driver.get(configUtils.getInstance().GetBaseUrl());

        return this;
    }


    // after logIn we will go to  todo page
    @Step
    public TodoPage Login(String email,String password)
    {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submit.click();
        return new TodoPage(driver);

    }

}
