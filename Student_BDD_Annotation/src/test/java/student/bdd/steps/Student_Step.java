package student.bdd.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;
import student.bdd.utils.TestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RunWith(SerenityRunner.class)
public class Student_Step {

    static ValidatableResponse response;
    static String email = null;
    static int studentId;
    @Steps
    student.bdd.information.StudentSteps studentSteps;
    @When("^User sends a GET HTTP request to list endpoint$")
    public void userSendsAGETHTTPRequestToListEndpoint() {
        response = studentSteps.getAllStudentInfo();
    }

    @Then("^User must get back a valid status code (\\d+)$")
    public void userMustGetBackAValidStatusCode(int arg0) {
        response.statusCode(200);
    }

    @When("^I create a new student by providing the information firstName \"([^\"]*)\" lastName \"([^\"]*)\" email \"([^\"]*)\" programme \"([^\"]*)\" courses \"([^\"]*)\"$")
    public void iCreateANewStudentByProvidingTheInformationFirstNameLastNameEmailProgrammeCourses(String firstName, String lastName, String _email, String programme, String courses) throws Throwable {

        List<String> courseList = new ArrayList<>();
        courseList.add(courses);
        email = TestUtils.getRandomValue()+ _email;
        response = studentSteps.createStudent(firstName , lastName , email, programme , courseList);
        response.statusCode(201);
        System.out.println(email);
    }

    @Then("^I verify that the student with \"([^\"]*)\" is created$")
    public void iVerifyThatTheStudentWithIsCreated(String arg0) throws Throwable {

        HashMap<String, Objects> studentMap = studentSteps.get

    }
}
