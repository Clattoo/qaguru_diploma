package web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.pages.ProfilePage;
import web.pages.RegistrationPage;
import utils.RandomUtils;

@Tag("web")
public class RegistrationTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ProfilePage profilePage = new ProfilePage();
    RandomUtils randomUtils = new RandomUtils();

    String userName = randomUtils.getRandomUserName();
    String userPassword = randomUtils.getRandomPassword();
    String userEmail = randomUtils.getRandomEmail();

    @Test
    @DisplayName("Успешная регистрация нового пользователя на странице регистрации")
    void successfulRegistrationOfNewUserTest() {
        registrationPage.openRegistrationPage()
                .checkLoginForm()
                .setUserName(userName)
                .setUserEmail(userEmail)
                .setUserPassword(userPassword)
                .setUserConfirmationPassword(userPassword)
                .clickRegistrationButton();
        profilePage.checkRegistrationOfNewUser(userName);
    }

    @Test
    @DisplayName("Ошибка регистрации нового пользователя при отсутствии имени пользователя и пароля")
    void failRegistrationOfNewUserWithoutUsernameAndPasswordTest() {
        registrationPage.openRegistrationPage()
                .checkLoginForm()
                .setUserEmail(userEmail)
                .clickRegistrationButton()
                .checkErrorNotification("Missing username. Missing password.");
    }

    @Test
    @DisplayName("Ошибка регистрации нового пользователя при отсутствии имени пользователя и пароля")
    void failRegistrationOfNewUserWithoutPasswordTest() {
        registrationPage.openRegistrationPage()
                .checkLoginForm()
                .setUserName(userName)
                .setUserEmail(userEmail)
                .clickRegistrationButton()
                .checkErrorNotification("Missing password.");
    }
}
