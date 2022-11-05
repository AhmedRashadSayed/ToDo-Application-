package com.Qacat.todo.base;

import com.Qacat.todo.Factory.DriverFactory;
import com.Qacat.todo.Utilites.CookieUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.http.Cookie;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BaseTest {

    // if you need to test methods in parallel testing must be separate instance of BaseTest class for each testcase
    // into the same class
    protected ThreadLocal <WebDriver> driver = new ThreadLocal<>();


    public void setDriver(WebDriver driver)
    {
        this.driver.set(driver);

    }

    public WebDriver getDriver()
    {
        return this.driver.get();

    }


   @BeforeMethod

    public void setup()

   {
       WebDriver driver = new DriverFactory().InitializeDriver();
       setDriver(driver);
   }


    @AfterMethod

    // to return test function name after testing it to makes the screenshot name dynamic and called as test case name
    public void teardown(ITestResult  result)
   {
       String TestCaseName = result.getMethod().getMethodName();
       File DestinationFile = new File("target" + File.separator + "ScreenShots" + File.separator + TestCaseName + ".png");
       TakeScreenShots(DestinationFile);
       getDriver().quit();

   }


    @Step
   public void InjectCookiesToBrowser(List<Cookie> RestAssuredCookies)
   {
       // to get all selenium cookies after conversion
       List<org.openqa.selenium.Cookie> SeleniumCookies = CookieUtils.ConvertRestAssuredToSeleniumCookies(RestAssuredCookies);
       // looping on all selenium cookies to send them to browser
       for (org.openqa.selenium.Cookie cookie:SeleniumCookies)
       {
           // to send each cookie to browser
           getDriver().manage().addCookie(cookie);
       }

   }


   public void TakeScreenShots(File destinationFile)
   {
       // to takes screenshots and save it in file
       File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
       try {
           FileUtils.copyFile(file,destinationFile);

           // to add screenshot into allure report
           // 1- convert file to input stream file to read data     2-add to allure addAttachment
           InputStream inputStream = new FileInputStream(destinationFile);
           Allure.addAttachment("ScreenShots",inputStream);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

   }




}
