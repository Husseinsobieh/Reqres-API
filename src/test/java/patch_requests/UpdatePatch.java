package patch_requests;

import base.BaseTests;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdatePatch extends BaseTests {
    @Test
    public void patchUser(){
        given().
            spec(request).
            header("Content-Type", "application/json").
            body("{\n" +
                    "    \"name\": \"morpheus\",\n" +
                    "    \"job\": \"zion resident\"\n" +
                    "}").
        when().
            patch("/api/users/7").
        then().
            spec(response).
            assertThat().body("name", equalTo("morpheus"),
                    "job", equalTo("zion resident")).
            log().all();
    }
}
