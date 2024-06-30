package student.bdd.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import student.bdd.utils.PropertyReader;

public class TestBase {

    public static PropertyReader propertyReader;

    @BeforeClass

    public static void inIt(){
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("local.URL");
        RestAssured.port = Integer.parseInt(propertyReader.getProperty("student.Port"));


    }
}
