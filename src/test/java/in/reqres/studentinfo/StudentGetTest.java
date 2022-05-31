package in.reqres.studentinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentsInfo() {
        Response response = given()
                .when()
                .get("users?page=2");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void getSingleStudentInfo() {
        Response response = given()
                .pathParam("user", 2)
                .when()
                .get("users/{user}");
        response.then().statusCode(200);
        response.prettyPrint();


    }


}
