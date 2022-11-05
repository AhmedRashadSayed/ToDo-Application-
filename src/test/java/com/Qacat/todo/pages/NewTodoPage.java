package com.Qacat.todo.pages;

import com.Qacat.todo.Config.URlEndPoint;
import com.Qacat.todo.Utilites.configUtils;
import com.Qacat.todo.base.basePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.URI;

public class NewTodoPage extends basePage {

    public NewTodoPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "[data-testid=\"new-todo\"]")
    private WebElement AddNewTodo;

    @FindBy(css = "[data-testid=\"submit-newTask\"]")
    private WebElement SubmitTodo;

    @Step
    public TodoPage WriteNewTodo(String TodoContent)
    {
        AddNewTodo.sendKeys(TodoContent);
        SubmitTodo.click();
        return new TodoPage(driver);

    }


    // to test new todo page through api directly  without testing any pages before
    @Step
    public NewTodoPage load()
    {
        driver.get(configUtils.getInstance().GetBaseUrl() + URlEndPoint.NEW_TODO_PAGE_ENDPOINT);
        return this;
    }



}
