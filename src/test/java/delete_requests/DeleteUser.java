package delete_requests;

import base.BaseTests;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteUser extends BaseTests {
    @Test
    public void deleteUser(){
        given().
            spec(request).
        when().
            delete("/api/users/2").
        then().
            assertThat().statusCode(204);
    }
}
