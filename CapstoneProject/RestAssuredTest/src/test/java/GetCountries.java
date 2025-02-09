import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Config;
import utils.Excel;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetCountries {

    @DataProvider(name = "getCountryList")
    public String[][] getCountryList() throws IOException {

        return Excel.loadExcelTestData();
    }

    @BeforeClass
    public void setUp(){
        Config.load();
    }

    @Test(dataProvider = "getCountryList")
    public void getTranslation(String _countryName){
        RestAssured.baseURI = Config.getProperty("BASE_URI");

        given().pathParam("countryName",_countryName).
                when().get("{countryName}").
                then().assertThat().statusCode(200);

    }
}


