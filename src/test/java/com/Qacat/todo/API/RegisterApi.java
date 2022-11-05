package com.Qacat.todo.API;

import com.Qacat.todo.Config.URlEndPoint;
import com.Qacat.todo.Objects.Users;
import com.Qacat.todo.Utilites.RandomUsers;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public  class RegisterApi {

    private List<Cookie> restAssuredCookies;
    private String AccessToken;
    private String FirstName;
    private String userID;

    public List<Cookie> getCookies() {
        return restAssuredCookies;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getUserID() {
        return userID;
    }

    public  void Register()
    {
        Users user =  RandomUsers.GenerateRandomUser();

        Response response =
                given()
                        .baseUri("https://qacart-todo.herokuapp.com")
                        .header("Content-Type","application/json")
                        .body(user)
                        .log().all()
                .when()
                        .post(URlEndPoint.REGISTER_API_ENDPOINT)
                .then()
                        .log().all()
                        .extract().response(); // another way to extract response

        if(response.statusCode() != 201)
        {
            throw new RuntimeException("error when sending request");

        }

        restAssuredCookies = response.detailedCookies().asList();
        AccessToken = response.path("access_token");
        FirstName = response.path("firstName");
        userID = response.path("userID");
    }


}
