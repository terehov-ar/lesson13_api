package tests;

import models.*;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.LoginSpec.*;

public class ReqresInTestsLombok extends TestBase {

    @Test
    void successfulGetSingleUserTest() {

        GetUserResponseModel response = step("Make request", ()->
            given(getUserRequestSpec)

            .when()
                .get()

            .then()
                .spec(getUserResponseSpec)
                .extract()
                .jsonPath()
                .getObject("data", GetUserResponseModel.class));

        step("Check response", ()-> {
                assertEquals(2, response.getId());
                assertEquals("janet.weaver@reqres.in", response.getEmail());
                assertEquals("Janet", response.getFirst_name());
                assertEquals("Weaver", response.getLast_name());
        });
    }

    @Test
    void successfulCreateUserTest() {

        CreateUserModel userData = new CreateUserModel();
        userData.setJob("Developer");
        userData.setName("Docker");

        CreateUserModel response = step("Make request", ()->
            given(createUserRequestSpec)
                .body(userData)

            .when()
                .post()

            .then()
                .spec(createUserResponseSpec)
                .extract().as(CreateUserModel.class));

        step("Check response", () -> {
            assertEquals("Docker", response.getName());
            assertEquals("Developer", response.getJob());
        });
    }

    @Test
    void successfulDeleteUserTest() {

        step("Make request and check statusCode", ()->
        given(deleteUserRequestSpec)

        .when()
            .delete()

        .then()
            .spec(deleteUserResponseSpec));
    }

    @Test
    void unsuccessfulDeleteUserWithWrongApiKeyTest() {

        DeleteUserResponseModel response = step("Make request", ()->
        given(deleteUserRequestSpecWithWrongApiKey)

        .when()
            .delete()

        .then()
            .spec(deleteUserResponseSpecWithoutApiKey)
            .extract().as(DeleteUserResponseModel.class));

        step("Check response", ()->
                assertEquals("invalid_api_key", response.getError()));
    }

    @Test
    void successfulLoginWithSpecsTest() {
        LoginBodyLombokModel authData = new LoginBodyLombokModel();
        authData.setEmail("eve.holt@reqres.in");
        authData.setPassword("cityslicka");

        LoginResponseLombokModel response = step("Make request", ()->
                given(loginRequestSpec)
                    .body(authData)

                .when()
                    .post()

                .then()
                    .spec(loginResponseSpec)
                    .extract().as(LoginResponseLombokModel.class));

        step("Check response", ()->
                assertEquals("QpwL5tke4Pnpja7X4", response.getToken()));
    }

    @Test
    void missingPasswordTest() {
        LoginBodyLombokModel authData = new LoginBodyLombokModel();
        authData.setEmail("eve.holt@reqres.in");

        MissingPasswordModel response = step("Make request", ()->
                given(loginRequestSpec)
                        .body(authData)

                        .when()
                        .post()

                        .then()
                        .spec(missingPasswordResponseSpec)
                        .extract().as(MissingPasswordModel.class));

        step("Check response", ()->
                assertEquals("Missing password", response.getError()));
    }

    @Test
    void unsuccessfulCreateUserTest() {
        LoginBodyLombokModel authData = new LoginBodyLombokModel();
        authData.setEmail("testqa@qatest");
        authData.setPassword("hardestpassworldintheworld");

        MissingPasswordModel response = step("Make request", ()->
                given(createRequestSpec)
                        .body(authData)

                        .when()
                        .post()

                        .then()
                        .spec(missingPasswordResponseSpec)
                        .extract().as(MissingPasswordModel.class));

        step("Check response", ()->
                assertEquals("Note: Only defined users succeed registration", response.getError()));
    }
}
