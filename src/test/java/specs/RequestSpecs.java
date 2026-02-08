package specs;

import io.restassured.specification.RequestSpecification;
import helpers.TokenValidator;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class RequestSpecs {

    private static final String xApiKey = "reqres_957ed4d983084b55a7f13a8e12a3c6ff";

    static {
        TokenValidator.validateApiKey(xApiKey);
    }

    public static RequestSpecification reqresRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().body()
            .log().headers()
            .header("x-api-key", xApiKey)
            .contentType(JSON);

    public static RequestSpecification reqresRequestSpecWithWrongApiKey = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().body()
            .log().headers()
            .header("x-api-key", "46346346")
            .contentType(JSON);
}