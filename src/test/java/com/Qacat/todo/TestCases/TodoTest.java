package com.Qacat.todo.TestCases;

import com.Qacat.todo.API.AddTask;
import com.Qacat.todo.API.RegisterApi;
import com.Qacat.todo.Factory.DriverFactory;
import com.Qacat.todo.Objects.Task;
import com.Qacat.todo.Utilites.configUtils;
import com.Qacat.todo.base.BaseTest;
import com.Qacat.todo.base.basePage;
import com.Qacat.todo.pages.LoginPage;
import com.Qacat.todo.pages.NewTodoPage;
import com.Qacat.todo.pages.TodoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.security.PublicKey;
import java.time.Duration;


@Feature("Todo Features")
public class TodoTest extends BaseTest  {

    @Story("Add New Todo")
    @Test(description = "Should Be Able To Add NewTodo Correctly")
   public void ShouldBeAbleToAddAnewTodo() throws FileNotFoundException {

        LoginPage login_obj = new LoginPage(getDriver());
        login_obj
                .load()
                    .Login(configUtils.getInstance().GetEmail(),configUtils.getInstance().GetPassword())
                        .clickOnAddButton()
                            .WriteNewTodo("manual testing")
                                .GetTodoText();
    }



    @Story("Delete Todo")
    @Test(description = "Should Be Able To Delete Todo Correctly")
    public void ShouldBeAbleToDeleteTodo() throws FileNotFoundException {

        LoginPage login_obj = new LoginPage(getDriver());
        boolean IsNoAvailableTodos = login_obj
                .load()
                    .Login(configUtils.getInstance().GetEmail(),configUtils.getInstance().GetPassword())
                        .clickOnAddButton()
                            .WriteNewTodo("automation testing learning")
                                .ClickOnDeleteButton()
                                    .NoAvailableTodos();

        Assert.assertTrue(IsNoAvailableTodos);

    }



    // makes a testing FOR A todo page directly through API not login interface

    @Story("Add New Todo Using Api Request")
    @Test(description = "Should Be Able To Add NewTodo Correctly using API request")
    public void ShouldBeAbleToAddAnewTodoUsingApiRequest() throws FileNotFoundException {

        // register through api
        RegisterApi registerApi = new RegisterApi();
        registerApi.Register();

        // going to todo page automatically after login using api
        TodoPage todoPage = new TodoPage(getDriver());
        todoPage.Load();        // using load function of todo page class not login class

        // to send cookies to browser after login
        InjectCookiesToBrowser(registerApi.getCookies());

    String ActualResult = todoPage
                                .Load()
                                .clickOnAddButton()
                                .WriteNewTodo("selenium course")
                                .GetTodoText();

    Assert.assertEquals(ActualResult,"selenium course");



    }


    @Story("Create New Todo Using Api Request")
    @Test(description = "Should Be Able To Create a NewTodo From NewTodo Page Correctly using API request")
    //  makes a testing FOR A new todo page directly through API not login interface or todo page

   public void  ShouldBeAbleToCreateAnewTodoFromNewTodoPageUsingApiRequest()
    {
        RegisterApi registerApi = new RegisterApi();
        registerApi.Register();

        NewTodoPage newTodoPage = new NewTodoPage(getDriver());
        newTodoPage.load();

        InjectCookiesToBrowser(registerApi.getCookies());

    String ActualValue = newTodoPage
                        .load()
                        .WriteNewTodo("Appium")
                        .GetTodoText();

        Assert.assertEquals(ActualValue,"Appium");

    }


    @Story("Delete Todo Using Api Request")
//  makes a testing FOR A new delete function  directly through API without depending on another functions
    @Test(description = "Should Be Able To Delete Todo Correctly using API request")
    public void ShouldBeAbleToDeleteTaskUsingApiRequest()
    {
        RegisterApi registerApi = new RegisterApi();
        registerApi.Register();

        AddTask addTask = new AddTask();
        addTask.TasksApi(registerApi.getAccessToken());

        TodoPage todoPage = new TodoPage(getDriver());
        todoPage.Load();

        InjectCookiesToBrowser(registerApi.getCookies());

        boolean NoAvailableTodos  = todoPage
                                            .Load()
                                            .ClickOnDeleteButton()
                                            .NoAvailableTodos();

        Assert.assertTrue(NoAvailableTodos);
    }

}

