package tests.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Reporter;
import tests.objects.Minion;

import java.util.List;

import static io.restassured.RestAssured.given;
import static tests.specs.RestSpecification.getRequestSpec;

public class MinionSteps {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String url = "http://localhost:3000";
    private static final String path = "/users";


    public static List<Minion> getListOfMinions() {
        Response response = given()
                .spec(getRequestSpec(url, path))
                .when().get();
        if (response.getStatusCode() == 200)
            return response.then().extract()
                    .jsonPath()
                    .getList("$", Minion.class);
        else {
            Reporter.getCurrentTestResult().setStatus(2);
            System.out.println("Status code : " + response.getStatusCode());
            throw new AssertionError();
        }

    }

    public static void getListOfMinionsStr() {
        Response response = given()
                .spec(getRequestSpec(url, path))
                .when().get();
        if (response.getStatusCode() == 200)
            response.prettyPrint();
        else {
            Reporter.getCurrentTestResult().setStatus(2);
            System.out.println("Status code : " + response.getStatusCode());
        }
    }

    public static Minion getMinionById(int id) {
        Response response = given()
                .spec(getRequestSpec(url, path))
                .when().get("/" + id);
        if (response.getStatusCode() == 200)
            return response.then().extract()
                    .as(Minion.class);
        else {
            Reporter.getCurrentTestResult().setStatus(2);
            System.out.println("Status code : " + response.getStatusCode());
            throw new AssertionError();
        }
    }

    public static void getMinionAsStrById(int id) {
        Response response = given()
                .spec(getRequestSpec(url, path))
                .when().get("/" + id);
        if (response.getStatusCode() == 200)
            response.prettyPrint();
        else {
            Reporter.getCurrentTestResult().setStatus(2);
            System.out.println("Status code : " + response.getStatusCode());
        }
    }

    public static void addMinion(Minion minion) {
        try {
            String json = MAPPER.writeValueAsString(minion);
            Response response = given()
                    .spec(getRequestSpec(url, path))
                    .body(json)
                    .when().post();
            if (response.getStatusCode() == 200)
                response.prettyPrint();
            else {
                Reporter.getCurrentTestResult().setStatus(2);
                System.out.println("Status code : " + response.getStatusCode());
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void updateMinionById(int id, Minion minion) {
        try {
            String json = MAPPER.writeValueAsString(minion);
            Response response = given()
                    .spec(getRequestSpec(url, path))
                    .body(json)
                    .when().put("/" + id);
            if (response.getStatusCode() == 201)
                response.prettyPrint();
            else {
                Reporter.getCurrentTestResult().setStatus(2);
                System.out.println("Status code : " + response.getStatusCode());
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMinionById(int id) {
        Response response = given()
                .spec(getRequestSpec(url, path))
                .when().delete("/" + id);
        if (response.getStatusCode() == 200)
            System.out.println("Minion with id " + id + "successfully deleted");
        else {
            Reporter.getCurrentTestResult().setStatus(2);
            System.out.println("Status code : " + response.getStatusCode());
        }
    }
}
