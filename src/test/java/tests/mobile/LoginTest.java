package tests.mobile;

import data.AuthData;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import tests.mobile.components.OnboardingComponent;
import tests.mobile.screens.AuthorizationScreen;
import tests.mobile.screens.LoginScreen;
import tests.mobile.screens.ProfileScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Feature("Android. Тестирование логина пользователя.")
@Tag("android")
public class LoginTest extends MobileTestBase {

    final AuthData authData = new AuthData();

    final OnboardingComponent onboardingComponent = new OnboardingComponent();
    final AuthorizationScreen authorizationScreen = new AuthorizationScreen();
    final LoginScreen loginScreen = new LoginScreen();
    final ProfileScreen profileScreen = new ProfileScreen();

    @Test
    @Severity(CRITICAL)
    @DisplayName("Появление ошибки авторизации на экране логина при отсутствующих логине и пароле")
    public void loginWithoutUserNameAndPasswordTest() {
        onboardingComponent.clickSkipButton();
        authorizationScreen.clickLoginButton();
        loginScreen.clickLoginButton()
                .checkErrorTitleNotification("Validation Error");
    }

    @Test
    @Severity(CRITICAL)
    @DisplayName("Появление ошибки авторизации на экране логина при отсутствии имени пользователя")
    public void loginWithoutUserNameTest() {
        onboardingComponent.clickSkipButton();
        authorizationScreen.clickLoginButton();
        loginScreen.setPassword(authData.password)
                .clickLoginButton()
                .checkErrorTitleNotification("Validation Error");
    }

    @Test
    @Severity(BLOCKER)
    @DisplayName("Успешный логин пользователя при вводе существующего имени пользователя и пароля")
    public void loginWithUserNameAndPasswordTest() {
        onboardingComponent.clickSkipButton();
        authorizationScreen.clickLoginButton();
        loginScreen.setUserName(authData.userName)
                .setPassword(authData.password)
                .clickLoginButton();
        profileScreen.checkProfileName(authData.userName);
    }
}
