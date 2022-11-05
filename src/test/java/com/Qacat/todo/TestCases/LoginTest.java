package com.Qacat.todo.TestCases;

import com.Qacat.todo.Factory.DriverFactory;
import com.Qacat.todo.Utilites.configUtils;
import com.Qacat.todo.base.BaseTest;
import com.Qacat.todo.pages.LoginPage;
import com.Qacat.todo.pages.TodoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.time.Duration;


// to makes a classification for your test cases
@Feature("Auth Features")
public class LoginTest extends BaseTest {

    @Story("Login Using Email And password")
    @Description("will fill username and password fields with data and will be navigate to todo page ")
    @Test(description = "Test Login Functionality Using UserName and Password")

    public void ShouldBeAbleToLoginWithEmailAndPassword() {
        LoginPage login_obj = new LoginPage(getDriver());

        // makes load function and makes a LogIn
        boolean IsDisplayed = login_obj
                                    .load()
                                         .Login(configUtils.getInstance().GetEmail(),configUtils.getInstance().GetPassword())
                                            .welcomingMassageIsDisplayed();
        Assert.assertTrue(IsDisplayed);

    }


}
