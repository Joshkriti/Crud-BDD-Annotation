package student.bdd.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import student.bdd.constants.Path;
import student.bdd.utils.PropertyReader;

/**
 * Created by bhavesh
 */
public class TestBaseBestBuyApi {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("bestBuy.BaseUrl");
        RestAssured.port = Integer.parseInt(propertyReader.getProperty("bestBuy.Port"));
        RestAssured.basePath = Path.PRODUCTS;
    }

}
