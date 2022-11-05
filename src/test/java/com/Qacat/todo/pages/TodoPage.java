package com.Qacat.todo.pages;

import com.Qacat.todo.Config.URlEndPoint;
import com.Qacat.todo.Utilites.configUtils;
import com.Qacat.todo.base.basePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends basePage {

    public TodoPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welcomeMassage;

    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement AddButton;

    @FindBy(css = "[data-testid=\"todo-text\"]")
    private WebElement TodoText;

    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement DeleteTodo;


    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement NoTodos;

    @Step
    public boolean welcomingMassageIsDisplayed()
    {
        return welcomeMassage.isDisplayed();


    }
    @Step
    public NewTodoPage clickOnAddButton()
    {
        AddButton.click();
        return new NewTodoPage(driver);
    }
    @Step
    public String GetTodoText()
    {
        return TodoText.getText();
    }

    @Step
    public TodoPage ClickOnDeleteButton()
    {
        DeleteTodo.click();
        return this;
    }
    @Step
    public boolean NoAvailableTodos()
    {
        return NoTodos.isDisplayed();

    }


    // use this function when making api request and sending cookies to website
    @Step
    public TodoPage Load()
    {
        driver.get(configUtils.getInstance().GetBaseUrl() + URlEndPoint.TODO_PAGE_ENDPOINT);
        return this;

    }




}
