package api.api;

import api.models.LoginRequestModel;
import api.models.LoginResponseModel;
import data.AuthData;
import io.qameta.allure.Step;

import static api.specs.ReqResSpec.requestSpec;
import static api.specs.ReqResSpec.responseSpec;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class AuthorizationApi {

    @Step("Make login request and write down response using API")
    public static LoginResponseModel getAuthorizationCookie(){
        LoginResponseModel response;
        LoginRequestModel request = new LoginRequestModel(System.getProperty("loginUser", AuthData.USER_NAME),
                System.getProperty("passwordUser", AuthData.PASSWORD));

        response = given(requestSpec)
                .body(request)
                .contentType(JSON)
                .when()
                .post("v4/user/auth/local/login")
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .extract().as(LoginResponseModel.class);

        return response;
    }
}