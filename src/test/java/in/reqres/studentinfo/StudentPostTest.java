package in.reqres.studentinfo;

import in.reqres.model.LoginPojo;
import in.reqres.model.StudentPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StudentPostTest extends TestBase {

    @Test
    public void createStudent() {

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setName("Lalit");
        studentPojo.setJob("QA");


        Response response = given()
                .header("Content-Type", "application/json")
                //  .contentType(ContentType.JSON)

                .body(studentPojo)
                .when()
                .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();

    }

    @Test
    public void loginSuccessfully() {


        LoginPojo loginPojo = new LoginPojo();
        loginPojo.setEmail("eve.holt@reqres.in");
        loginPojo.setPassword("cityslicka");


        Response response = given()
                .header("Content-Type", "application/json")


                .body(loginPojo)
                .when()
                .post("/login");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
