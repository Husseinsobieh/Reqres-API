package get_requests.list_users;

import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ListUsers extends BaseTests {
    @Test
    public void testListUsersNumber(){
        given().
            spec(request).
        when().
            get("/api/users?page=1").
        then().
            spec(response).
            assertThat().
            body("total", equalTo(12));
    }
    @Test(dataProviderClass = ListUsersProvider.class, dataProvider = "getUsers")
    public void testListUsers(int ID, String email, String firstName, String lastName, String avatar){
        given().
                spec(request).
                when().
                get("/api/users?page=1").
                then().
                spec(response).
                assertThat().
                body("data[" + (ID-1) + "].id", equalTo(ID)).
                body("data[" + (ID-1) + "].email", equalTo(email)).
                body("data[" + (ID-1) + "].first_name", equalTo(firstName)).
                body("data[" + (ID-1) + "].last_name", equalTo(lastName)).
                body("data[" + (ID-1) + "].avatar", equalTo(avatar));
    }
}
