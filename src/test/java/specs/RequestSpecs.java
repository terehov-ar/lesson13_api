package specs;

import io.restassured.specification.RequestSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class RequestSpecs {

    private static final String xApiKey = "reqres_957ed4d983084b55a7f13a8e12a3c6ff";

    public static RequestSpecification loginRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().body()
            .log().headers()
            .header("x-api-key", xApiKey)
            .contentType(JSON)
            .basePath("/api/login");

    public static RequestSpecification createRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().body()
            .log().headers()
            .header("x-api-key", xApiKey)
            .contentType(JSON)
            .basePath("/api/register");

    public static RequestSpecification getUserRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().headers()
            .header("x-api-key", xApiKey)
            .basePath("/api/users/2");

    public static RequestSpecification createUserRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().body()
            .log().headers()
            .header("x-api-key", xApiKey)
            .contentType(JSON)
            .basePath("/api/users");

    public static RequestSpecification deleteUserRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().headers()
            .header("x-api-key", xApiKey)
            .contentType(JSON)
            .basePath("/api/users/2");

    public static RequestSpecification deleteUserRequestSpecWithWrongApiKey = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().headers()
            .header("x-api-key", "46346346")
            .contentType(JSON)
            .basePath("/api/users/2");
}