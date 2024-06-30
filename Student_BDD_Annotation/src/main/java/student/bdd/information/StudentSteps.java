package student.bdd.information;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Step;
import student.bdd.constants.EndPoints;
import student.bdd.model.StudentPojo;

import java.util.List;

import static io.restassured.RestAssured.given;

public class StudentSteps {

    @Step("getting all information :{0}")
    public ValidatableResponse getAllStudentInfo(){
        return given()
                .when()
                .get(EndPoints.GET_ALL_STUDENT)
                .then();
    }
    @Step("creating student with firstName :{0},lastName: {1},email:{2},programme:{3} and courses:{4}")
    public ValidatableResponse createStudent(String firstName, String lastName, String email, String programme, List<String> courseList){

        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setFirstName(firstName);
        studentPojo.setLastName(lastName);
        studentPojo.setEmail(email);
        studentPojo.setProgramme(programme);
        studentPojo.setCourses(courseList);
        return given().log().all()
                .contentType(ContentType.JSON)
                .body(studentPojo)
                .when()
                .post(EndPoints.CREATE_STUDENT)
                .then();
    }


}
