package get_requests.single_user;

import base.BaseTests;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class SingleUser extends BaseTests {
    @Test
    public void getSingleUser(){
        int id = 2;
        given().
            spec(request).
        when().
            get("/api/users/" + id).
        then().
            spec(response).
            assertThat().body("data.first_name", equalTo("Janet"));
    }
    @Test
    public void getSingleUserNotFound(){
        int id = 13;
        given().
            spec(request).
        when().
            get("/api/users/" + id).
        then().
            assertThat().
            statusCode(404);
    }
}
