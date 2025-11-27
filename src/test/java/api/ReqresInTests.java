package api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class ReqresInTests extends TestBase{

    @Test
    void successGetSingleUserTest() {
        given()
            .log().uri()
        .when()
            .get("/users/2")
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
    void successUpdateUserTest() {
        String updateData = "{\"name\": \"testName\", \"job\": \"lion\"}";
        given()
            .header("x-api-key", "reqres-free-v1")
            .body(updateData)
            .contentType(JSON)
            .log().uri()
        .when()
            .patch("/users/2")
        .then()
            .log().status()
            .log().body()
            .statusCode(200)
            .body("name", is("testName"))
            .body("job", is("lion"));
    }

    @Test
    void successCreateUserTest() {
        String updateData = "{\"name\": \"Jenkins\", \"job\": \"CI/CD\"}";
        given()
            .header("x-api-key", "reqres-free-v1")
            .body(updateData)
            .contentType(JSON)
            .log().uri()
        .when()
            .post("/users")
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
            .header("x-api-key", "reqres-free-v1")
            .log().uri()
        .when()
            .delete("/users/2352362367")
        .then()
            .log().status()
            .log().body()
            .statusCode(204);
    }

    @Test
    void unSuccessDeleteUserWithoutApiKeyTest() {
        given()
            .log().uri()
        .when()
            .delete("/users/1")
        .then()
            .log().status()
            .log().body()
            .statusCode(401)
            .body("error", is("Missing API key"));
    }
}
