package tests;

import models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.*;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("api-tests")
public class ReqresInTestsLombok extends TestBase {

    @Test
    void successfulGetSingleUserTest() {
        GetUserResponseModel response = given(RequestSpecs.reqresRequestSpec)
                .when()
                .get("/users/2")
                .then()
                .spec(ResponseSpecs.getResponseSpec(200))
                .extract()
                .jsonPath()
                .getObject("data", GetUserResponseModel.class);

        assertEquals(2, response.getId());
        assertEquals("janet.weaver@reqres.in", response.getEmail());
        assertEquals("Janet", response.getFirst_name());
        assertEquals("Weaver", response.getLast_name());
    }

    @Test
    void successfulCreateUserTest() {
        CreateUserRequestModel userData = new CreateUserRequestModel();
        userData.setJob("Developer");
        userData.setName("Docker");

        CreateUserResponseModel response = given(RequestSpecs.reqresRequestSpec)
                .body(userData)
                .when()
                .post("/users")
                .then()
                .spec(ResponseSpecs.getResponseSpec(201))
                .extract().as(CreateUserResponseModel.class);

        assertEquals("Docker", response.getName());
        assertEquals("Developer", response.getJob());
    }

    @Test
    void successfulDeleteUserTest() {
        given(RequestSpecs.reqresRequestSpec)
                .when()
                .delete("/users/2")
                .then()
                .spec(ResponseSpecs.getResponseSpec(204));
    }

    @Test
    void unsuccessfulDeleteUserWithWrongApiKeyTest() {
        DeleteUserResponseModel response = given(RequestSpecs.reqresRequestSpecWithWrongApiKey)
                .when()
                .delete("/users/2")
                .then()
                .spec(ResponseSpecs.getResponseSpec(403))
                .extract().as(DeleteUserResponseModel.class);

        assertEquals("invalid_api_key", response.getError());
    }

    @Test
    void successfulLoginWithSpecsTest() {
        LoginBodyLombokModel authData = new LoginBodyLombokModel();
        authData.setEmail("eve.holt@reqres.in");
        authData.setPassword("cityslicka");

        LoginResponseLombokModel response = given(RequestSpecs.reqresRequestSpec)
                .body(authData)
                .when()
                .post("/login")
                .then()
                .spec(ResponseSpecs.getResponseSpec(200))
                .extract().as(LoginResponseLombokModel.class);

        Assertions.assertNotNull(response.getToken(), "API Key cannot be null");
        Assertions.assertFalse(response.getToken().isEmpty(), "API Key cannot be empty");
        Assertions.assertFalse(response.getToken().trim().isEmpty(), "API Key cannot contain only whitespace");
        Assertions.assertTrue(response.getToken().length() >= 8,
                "API Key must be at least 8 characters long (actual: " + response.getToken().length() + ")");
        Assertions.assertTrue(response.getToken().matches("^[a-zA-Z0-9_-]+$"),
                "API Key must contain only alphanumeric characters, underscore, or hyphen");
    }

    @Test
    void missingPasswordTest() {
        LoginBodyLombokModel authData = new LoginBodyLombokModel();
        authData.setEmail("eve.holt@reqres.in");

        MissingPasswordModel response = given(RequestSpecs.reqresRequestSpec)
                .body(authData)
                .when()
                .post("/login")
                .then()
                .spec(ResponseSpecs.getResponseSpec(400))
                .extract().as(MissingPasswordModel.class);

        assertEquals("Missing password", response.getError());
    }

    @Test
    void unsuccessfulCreateUserTest() {
        LoginBodyLombokModel authData = new LoginBodyLombokModel();
        authData.setEmail("testqa@qatest");
        authData.setPassword("hardestpassworldintheworld");

        MissingPasswordModel response = given(RequestSpecs.reqresRequestSpec)
                .body(authData)
                .when()
                .post("/register")
                .then()
                .spec(ResponseSpecs.getResponseSpec(400))
                .extract().as(MissingPasswordModel.class);

        assertEquals("Note: Only defined users succeed registration", response.getError());
    }
}
