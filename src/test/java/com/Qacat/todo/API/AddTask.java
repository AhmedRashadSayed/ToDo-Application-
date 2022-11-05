package com.Qacat.todo.API;
import com.Qacat.todo.Config.URlEndPoint;
import com.Qacat.todo.Utilites.configUtils;
import io.restassured.response.Response;
import com.Qacat.todo.Objects.Task;

import static io.restassured.RestAssured.given;

public class AddTask {

    public void TasksApi(String AccessToken)
    {
        Task task = new Task("learning selenium",false);

   Response response =
           given()
                .baseUri(configUtils.getInstance().GetBaseUrl())
                .header("Content-Type","application/json")
                .body(task)
                .auth().oauth2(AccessToken)
            .when()
                .post(URlEndPoint.ADD_TASK_ENDPOINT)
            .then()
                .log().all().extract().response();

        if(response.statusCode() != 201)
        {
            throw new RuntimeException("something is error");
        }


    }

}
