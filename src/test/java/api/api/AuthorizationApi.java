package api.api;


import io.qameta.allure.Step;
import api.models.LoginRequestModel;
import api.models.LoginResponseModel;

import static api.specs.ReqResSpec.requestSpec;
import static api.specs.ReqResSpec.responseSpec;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class AuthorizationApi {

    @Step("Make login request and write down response using API")
    public LoginResponseModel login(LoginRequestModel loginRequestModel) {
        return given(requestSpec)
                .body(loginRequestModel)
                .contentType(JSON)
                .when()
                .post("v4/user/auth/local/login")
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .extract().as(LoginResponseModel.class);
    }
}