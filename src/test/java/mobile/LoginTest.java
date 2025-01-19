package mobile;

import data.AuthData;
import io.qameta.allure.Feature;
import mobile.components.OnboardingComponent;
import mobile.screens.AuthorizationScreen;
import mobile.screens.LoginScreen;
import mobile.screens.ProfileScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature("Android. Тестирование логина пользователя.")
@Tag("android")
public class LoginTest extends MobileTestBase {

    OnboardingComponent onboardingComponent = new OnboardingComponent();
    AuthorizationScreen authorizationScreen = new AuthorizationScreen();
    LoginScreen loginScreen = new LoginScreen();
    ProfileScreen profileScreen = new ProfileScreen();

    @Test
    @DisplayName("Появление ошибки авторизации на экране логина при отсутствующих логине и пароле")
    public void loginWithoutUserNameAndPasswordTest() {
        onboardingComponent.clickSkipButton();
        authorizationScreen.clickLoginButton();
        loginScreen.clickLoginButton()
                .checkErrorTitleNotification("Validation Error");
    }

    @Test
    @DisplayName("Появление ошибки авторизации на экране логина при отсутствии имени пользователя")
    public void loginWithoutUserNameTest() {
        onboardingComponent.clickSkipButton();
        authorizationScreen.clickLoginButton();
        loginScreen.setPassword(AuthData.PASSWORD)
                .clickLoginButton()
                .checkErrorTitleNotification("Validation Error");
    }

    @Test
    @DisplayName("Успешный логин пользователя при вводе существующего имени пользователя и пароля")
    public void loginWithUserNameAndPasswordTest() {
        onboardingComponent.clickSkipButton();
        authorizationScreen.clickLoginButton();
        loginScreen.setUserName(AuthData.USER_NAME)
                .setPassword(AuthData.PASSWORD)
                .clickLoginButton();
        profileScreen.checkProfileName(AuthData.USER_NAME);
    }
}
