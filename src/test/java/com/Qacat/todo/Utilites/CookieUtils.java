package com.Qacat.todo.Utilites;

import io.restassured.http.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {


    public static List<org.openqa.selenium.Cookie> ConvertRestAssuredToSeleniumCookies(List<Cookie> RestAssuredCookie) {
        List <org.openqa.selenium.Cookie> SeleniumCooksList = new ArrayList<>();
        for (io.restassured.http.Cookie cookie : RestAssuredCookie)
        {
            org.openqa.selenium.Cookie SeleniumCookie = new org.openqa.selenium.Cookie(cookie.getName(), cookie.getValue());
            SeleniumCooksList.add(SeleniumCookie);

        }
        return SeleniumCooksList;

    }

    }


