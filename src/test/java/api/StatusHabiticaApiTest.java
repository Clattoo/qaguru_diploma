package api;

import api.models.StatusResponseModel;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.specs.ReqResSpec.responseSpec;
import static io.restassured.RestAssured.given;
import static api.specs.ReqResSpec.requestSpec;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Тестирование статуса серверов Habitica через API")
@Tag("api")
public class StatusHabiticaApiTest extends ApiTestBase {

    @Test
    @DisplayName("Проверка статуса серверов Habitica")
    @Story("Проверка работоспособности серверов Habitica через GET-запрос")
    void checkStatusOfHabiticaApiTest() {
        StatusResponseModel response = step("Запрос статуса серверов и запись ответа", () ->
                given(requestSpec)
                        .when()
                        .get("/v3/status")
                        .then()
                        .spec(responseSpec)
                        .statusCode(200)
                        .extract().as(StatusResponseModel.class));
        step("Проверка успешности выполнения запроса", () -> {
            assertTrue(response.getSuccess());
        });
    }
}
