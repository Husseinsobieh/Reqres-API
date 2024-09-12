package post_requests;

import base.BaseTests;
import jdk.jfr.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateUser extends BaseTests {
    private static final Logger log = LoggerFactory.getLogger(CreateUser.class);

    @Test
    public void createUser(){
        User user = new User("Hussein", "Dentist", 23);
        given().
            header("Content-Type", "application/json").
            body(user).
            spec(request).
        when().
            post("/api/users").
        then().
            log().all();
    }
}
