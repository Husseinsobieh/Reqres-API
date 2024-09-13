package put_requests;

import base.BaseTests;
import org.testng.annotations.Test;
import utils.User;
import utils.UserUpdater;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdatePut extends BaseTests {
    @Test
    public void putUser(){
        UserUpdater user = new UserUpdater();
        user.setEmail("angry.birds@reqres.in");
        user.setFirst_name("Angry");
        user.setLast_name("Birds");
        user.setAvatar("https://reqres.in/img/faces/7-image.jpg");

        given().
            spec(request).
            header("Content-Type", "application/json").
            body(user).
        when().
            put("/api/users/7").
        then().
            spec(response).
            assertThat().body("email", equalTo("angry.birds@reqres.in"),
                        "'first name'", equalTo("Angry"),
                        "'last name'", equalTo("Birds"),
                        "avatar", equalTo("https://reqres.in/img/faces/7-image.jpg")).
            log().all();
    }
}
