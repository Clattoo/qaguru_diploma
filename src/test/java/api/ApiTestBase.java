package api;

import com.codeborne.selenide.Configuration;
import config.WebDriverConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class ApiTestBase {
    @BeforeAll
    static void beforeAll() {
        WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

        RestAssured.baseURI = "https://habitica.com/";
        RestAssured.basePath = "/api";
        Configuration.baseUrl = "https://habitica.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = webDriverConfig.getRemoteUrl();
    }
}
