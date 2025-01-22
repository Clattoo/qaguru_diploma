package api;

import api.api.AuthorizationApi;
import api.models.*;
import data.AuthData;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;


import static api.specs.ReqResSpec.requestSpec;
import static api.specs.ReqResSpec.responseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Тестирование тегов через API")
@Tag("api")
public class TagTest extends ApiTestBase {

    AuthData authData = new AuthData();
    RandomUtils randomUtils = new RandomUtils();
    LoginRequestModel loginRequestModel = new LoginRequestModel(authData.userName, authData.password);
    AuthorizationApi authorizationApi = new AuthorizationApi();
    LoginResponseModel loginResponse = authorizationApi.login(loginRequestModel);

    @Test
    @DisplayName("Запрос текущего списка тегов")
    @Story("Проверка успешного выполнения запроса на получение списка тегов")
    void checkCurrentTagsListTest() {
        GetTagsResponseModel response = step("Запрос список тегов и запись ответа", () ->
                given(requestSpec)
                        .when()
                        .header("X-Api-User", loginResponse.getData().getId())
                        .header("X-Api-Key", loginResponse.getData().getApiToken())
                        .get("/v3/tags")
                        .then()
                        .spec(responseSpec)
                        .statusCode(200)
                        .extract().as(GetTagsResponseModel.class));
        step("Проверка успешности выполнения запроса", () -> {
            assertTrue(response.getSuccess());
            assertEquals("Claire", response.getData().get(0).getName());
        });
    }

    @Test
    @DisplayName("Удаление тега с помощью API")
    @Story("Проверка успешного выполнения запроса на удаление тега")
    void deleteExistingTag() {

        AddTagRequestModel addTag = new AddTagRequestModel(randomUtils.getProgrammingLanguage());

        TagResponseModel postResponse = step("Добавить новый тег через POST", () ->
                given(requestSpec)
                        .contentType("application/json")
                        .body(addTag)
                        .header("X-Api-User", loginResponse.getData().getId())
                        .header("X-Api-Key", loginResponse.getData().getApiToken())
                        .when()
                        .post("/v4/tags")
                        .then()
                        .spec(responseSpec)
                        .statusCode(201)
                        .extract().as(TagResponseModel.class));
        step("Проверить результат добавления тега", () -> {
            assertTrue(postResponse.getSuccess());
        });

        TagResponseModel deleteResponse = step("Удаление ранее добавленного тега с помощью DELETE-запроса", () ->
                given(requestSpec)
                        .contentType("application/json")
                        .header("X-Api-Key", "f50fff1e-223a-4f65-8094-e1755ace001b")
                        .header("X-Api-User", "61d1c3a2-bed0-4c3d-a0de-cf1422a8b444")
                        .when()
                        .delete("/v3/tags/" + postResponse.getData().getId())
                        .then()
                        .spec(responseSpec)
                        .statusCode(200)
                        .extract().as(TagResponseModel.class));
        step("Проверить успешность выполнения запроса", () -> {
            assertTrue(deleteResponse.getSuccess());
        });
    }
}
