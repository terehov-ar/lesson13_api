package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class ResponseSpecs {

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

    public static ResponseSpecification getUserResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(STATUS)
            .log(BODY)
            .build();

    public static ResponseSpecification createUserResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(STATUS)
            .log(BODY)
            .build();

    public static ResponseSpecification deleteUserResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .log(STATUS)
            .log(BODY)
            .build();

    public static ResponseSpecification deleteUserResponseSpecWithoutApiKey = new ResponseSpecBuilder()
            .expectStatusCode(403)
            .log(STATUS)
            .log(BODY)
            .build();
}
