package tests.api;

import api.models.BadRequestLoginResponseModel;
import api.models.LoginRequestModel;
import api.models.LoginResponseModel;
import data.AuthData;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.specs.ReqResSpec.requestSpec;
import static api.specs.ReqResSpec.responseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Feature("Тестирование авторизации с помощью API")
@Tag("api")
public class LoginTest extends ApiTestBase {

    AuthData authData = new AuthData();

    @Test
    @DisplayName("Выполнение успешного запроса на логин")
    @Story("Успешная авторизация с помощью POST-метода")
    void successfulLoginTest() {

        LoginRequestModel loginData = new LoginRequestModel(authData.userName, authData.userPassword);

        LoginResponseModel response =
                step("Выполнить запрос на логин и записать ответ с помощью API", () ->
                        given(requestSpec)
                                .contentType("application/json")
                                .body(loginData)
                                .when()
                                .post("/v4/user/auth/local/login")
                                .then()
                                .spec(responseSpec)
                                .statusCode(200)
                                .extract().as(LoginResponseModel.class));
        step("Проверить результат запроса", () -> {
            assertTrue(response.getSuccess());
            assertEquals(authData.userName, response.getData().getUsername());
            assertNotNull(response.getData().getId());
            assertNotNull(response.getData().getApiToken());
            assertFalse(response.getData().getNewUser());
            assertNotNull(response.getAppVersion());
        });

    }

    @Test
    @DisplayName("Ошибка логина пользователя при отсутствии пароля")
    @Story("Проверка ошибки логина при отправке запроса без пароля")
    void loginWithEmptyPasswordTest() {

        LoginRequestModel loginData = new LoginRequestModel(authData.userName, "");

        BadRequestLoginResponseModel response =
                step("Выполнить запрос на логин и записать ответ с помощью API", () ->
                        given(requestSpec)
                                .contentType("application/json")
                                .body(loginData)
                                .when()
                                .post("/v4/user/auth/local/login")
                                .then()
                                .spec(responseSpec)
                                .statusCode(400)
                                .extract().as(BadRequestLoginResponseModel.class));
        step("Проверить сообщение об отсутствующем пароле в ответе запроса", () -> {
            assertFalse(response.getSuccess());
            assertEquals("BadRequest", response.getError());
            assertEquals("Invalid request parameters.", response.getMessage());
            assertEquals("Missing password.", response.getErrors().get(0).getMessage());
            assertEquals("password", response.getErrors().get(0).getParam());
        });
    }

    @Test
    @DisplayName("Отправка запроса на логин с пустым телом")
    void loginWithEmptyBody() {
        BadRequestLoginResponseModel response =
                step("Выполнить запрос на логин и записать ответ с помощью API", () ->
                        given(requestSpec)
                                .contentType("application/json")
                                .body("")
                                .when()
                                .post("/v4/user/auth/local/login")
                                .then()
                                .spec(responseSpec)
                                .statusCode(400)
                                .extract().as(BadRequestLoginResponseModel.class));
        step("Проверить информацию из тела ответа", () -> {
            assertFalse(response.getSuccess());
            assertEquals("BadRequest", response.getError());
            assertEquals("Invalid request parameters.", response.getMessage());
            assertEquals("Missing username or email.", response.getErrors().get(0).getMessage());
            assertEquals("username", response.getErrors().get(0).getParam());
            assertEquals("Missing password.", response.getErrors().get(1).getMessage());
            assertEquals("password", response.getErrors().get(1).getParam());
        });
    }
}
