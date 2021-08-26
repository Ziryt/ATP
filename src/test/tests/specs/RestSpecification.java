package tests.specs;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class RestSpecification {


    public static RequestSpecification getRequestSpec(String url, String path) {
        return new RequestSpecBuilder()
                .addFilter(new AllureRestAssured())
                .setBaseUri(url)
                .setBasePath(path)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification getResponseSpec(int code) {
        return new ResponseSpecBuilder()
                .expectStatusCode(code)
                .build();
    }

}

