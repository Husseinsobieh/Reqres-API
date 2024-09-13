package post_requests;

import base.BaseTests;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class RegisterUser extends BaseTests {
    @Test
    public void registerUser(){
        given().
            spec(request).
            header("Content-Type", "application/json").
            body("{\n" +
                    "    \"email\": \"eve.holt@reqres.in\",\n" +
                    "    \"password\": \"pistol\"\n" +
                    "}").
        when().
            post("/api/register").
        then().
            assertThat().statusCode(200).
            assertThat().body("token", notNullValue(), "id", notNullValue());
    }
    @Test
    public void registerIncompleteUser(){
        given().
                spec(request).
                header("Content-Type", "application/json").
                body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "}").
                when().
                post("/api/register").
                then().
                assertThat().statusCode(400);
    }
}
