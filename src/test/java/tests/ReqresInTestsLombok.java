package tests;

import models.LoginBodyLombokModel;
import models.LoginResponseLombokModel;
import models.MissingPasswordModel;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.LoginSpec.*;

public class ReqresInTestsLombok extends TestBase {

    @Test
    void successGetSingleUserTest() {
        given()
                .header("x-api-key", "reqres_957ed4d983084b55a7f13a8e12a3c6ff")
                .log().uri()
                .when()
                .get("api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.id", is(2))
                .body("data.email", is("janet.weaver@reqres.in"))
                .body("data.first_name", is("Janet"))
                .body("data.last_name", is("Weaver"));
    }

    @Test
    void successCreateUserTest() {
        String updateData = "{\"name\": \"Jenkins\", \"job\": \"CI/CD\"}";
        given()
                .header("x-api-key", "reqres_957ed4d983084b55a7f13a8e12a3c6ff")
                .body(updateData)
                .contentType(JSON)
                .log().uri()
                .when()
                .post("api/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("Jenkins"))
                .body("job", is("CI/CD"));
    }

    @Test
    void successDeleteUserTest() {
        given()
                .header("x-api-key", "reqres_957ed4d983084b55a7f13a8e12a3c6ff")
                .log().uri()
                .when()
                .delete("api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(204);
    }

    @Test
    void unsuccessfulDeleteUserWithWrongApiKeyTest() {
        given()
                .log().uri()
                .header("x-api-key", "34234234")
                .when()
                .delete("api/users/1")
                .then()
                .log().status()
                .log().body()
                .statusCode(403)
                .body("error", is("invalid_api_key"));
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
