package helpers.extensions;

import api.api.AuthorizationApi;
import api.models.LoginRequestModel;
import api.models.LoginResponseModel;
import api.models.HabitMobileSettings;
import com.codeborne.selenide.Selenide;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import data.AuthData;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) throws JsonProcessingException {
        AuthData authData = AuthData.create();
        String userName = authData.userName;
        String userPassword = authData.password;

        LoginRequestModel loginRequestModel = new LoginRequestModel(userName, userPassword);
        AuthorizationApi authorizationApi = new AuthorizationApi();
        LoginResponseModel loginResponse = authorizationApi.login(loginRequestModel);


        HabitMobileSettings habitMobileSettings =
                new HabitMobileSettings(loginResponse.getData().getId(), loginResponse.getData().getApiToken());
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String result = mapper.writeValueAsString(habitMobileSettings);
        step("Authorization by filling in localStorage", () -> {
            open("/static/icons/favicon.ico");
            Selenide.localStorage().setItem("habit-mobile-settings", result);
        });
    }
}
