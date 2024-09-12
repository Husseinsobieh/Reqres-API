package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTests {
    protected RequestSpecification request;
    protected ResponseSpecification response;

    @BeforeTest
    public void requestSpecification(){
        request = new RequestSpecBuilder().
                setBaseUri("https://reqres.in").
                build();
    }
    @BeforeTest
    public void responseSpecification(){
        response = new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                expectStatusCode(200).
                build();
    }
}
