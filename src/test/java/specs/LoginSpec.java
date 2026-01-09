package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class LoginSpec {
    public static RequestSpecification loginRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().body()
            .log().headers()
            .header("x-api-key", "reqres_957ed4d983084b55a7f13a8e12a3c6ff")
            .contentType(JSON)
            .basePath("/api/login");

    public static RequestSpecification createRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().body()
            .log().headers()
            .header("x-api-key", "reqres_957ed4d983084b55a7f13a8e12a3c6ff")
            .contentType(JSON)
            .basePath("/api/register");

    public static ResponseSpecification loginResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(STATUS)
            .log(BODY)
            .build();

    public static ResponseSpecification missingPasswordResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .log(STATUS)
            .log(BODY)
            .build();

    public static RequestSpecification getUserRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().headers()
            .header("x-api-key", "reqres_957ed4d983084b55a7f13a8e12a3c6ff")
            .basePath("/api/users/2");

    public static ResponseSpecification getUserResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(STATUS)
            .log(BODY)
            .build();

    public static RequestSpecification createUserRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().body()
            .log().headers()
            .header("x-api-key", "reqres_957ed4d983084b55a7f13a8e12a3c6ff")
            .contentType(JSON)
            .basePath("/api/users");

    public static ResponseSpecification createUserResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(STATUS)
            .log(BODY)
            .build();

    public static RequestSpecification deleteUserRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().headers()
            .header("x-api-key", "reqres_957ed4d983084b55a7f13a8e12a3c6ff")
            .contentType(JSON)
            .basePath("/api/users/2");

    public static ResponseSpecification deleteUserResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .log(STATUS)
            .log(BODY)
            .build();

    public static RequestSpecification deleteUserRequestSpecWithWrongApiKey = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().headers()
            .header("x-api-key", "46346346")
            .contentType(JSON)
            .basePath("/api/users/2");

    public static ResponseSpecification deleteUserResponseSpecWithoutApiKey = new ResponseSpecBuilder()
            .expectStatusCode(403)
            .log(STATUS)
            .log(BODY)
            .build();
}