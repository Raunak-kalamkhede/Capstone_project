package utils;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiManager 
{
    public static void validateBackendStatus() 
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Response response = RestAssured.given()
                .when().get("/users/1")
                .then().extract().response();

        System.out.println("API Status Code: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200, "Backend API is down!");
    }
}