package student.bdd.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import student.bdd.utils.TestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentStep {

    static ValidatableResponse response;
    static String email = null;
    static int studentId;

    @Steps
    student.bdd.studentinfo.StudentSteps studentSteps;

    @When("^User sends a GET HTTP request to list endpoint$")
    public void userSendsAGETHTTPRequestToListEndpoint() {
        response = studentSteps.getAllStudentInfo();
    }

    @Then("^User must get back a valid status code$")
    public void userMustGetBackAValidStatusCode() {
        response.statusCode(200);
    }

    @When("^I create a new student by providing the information firstName \"([^\"]*)\" lastName \"([^\"]*)\" email \"([^\"]*)\" programme \"([^\"]*)\" courses \"([^\"]*)\"$")
    public void iCreateANewStudentByProvidingTheInformationFirstNameLastNameEmailProgrammeCourses(String firstName, String lastName, String _email, String programme, String courses) {
        List<String> courseList = new ArrayList<>();
        courseList.add(courses);
        email = TestUtils.getRandomValue() + _email;
        response=studentSteps.createStudent(firstName, lastName, email, programme, courseList);
        response.statusCode(201);
        System.out.println(email);
    }

    @Then("^I verify that the student with \"([^\"]*)\" is created$")
    public void iVerifyThatTheStudentWithIsCreated(String arg0) throws Throwable {
        HashMap<String, Object> studentMap = studentSteps.getStudentInfoByEmail(email);
        studentId = (int) studentMap.get("id");
        System.out.println(studentId);
    }

    @Then("^I delete student data so it is not visible to anyone$")
    public void iDeleteStudentDataSoItIsNotVisibleToAnyone() {
        response = studentSteps.deleteStudentInfoByID(studentId);
    }
}
