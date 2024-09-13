package post_requests;

import base.BaseTests;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class LoginUser extends BaseTests {
    @Test
    public void loginUser(){
        given().
            spec(request).
            header("Content-Type", "application/json").
            body("{\n" +
                    "    \"email\": \"eve.holt@reqres.in\",\n" +
                    "    \"password\": \"cityslicka\"\n" +
                    "}").
        when().
            post("/api/login").
        then().
            assertThat().statusCode(200).
            assertThat().body("token", notNullValue());
    }
    @Test
    public void loginIncompleteUser(){
        given().
                spec(request).
                header("Content-Type", "application/json").
                body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "}").
                when().
                post("/api/login").
                then().
                assertThat().statusCode(400);
    }
}
