package post_requests;

import base.BaseTests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import utils.User;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateUser extends BaseTests {
    private static final Logger log = LoggerFactory.getLogger(CreateUser.class);

    @Test
    public void createUser(){
        User user = new User("Hussein", "Dentist", 23);

        given().
                spec(request).
                header("Content-Type", "application/json").
                body(user).
        when().
            post("/api/users").
        then().
            assertThat().statusCode(201).
            assertThat().body("name", equalTo("Hussein"),
                        "job", equalTo("Dentist"),
                        "age", equalTo(23)).
            log().all();
    }
}
