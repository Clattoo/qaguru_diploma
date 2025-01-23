package tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.web.pages.ProfilePage;
import tests.web.pages.RegistrationPage;
import utils.RandomUtils;

import static io.qameta.allure.SeverityLevel.*;

@Feature("Тестирование страницы регистрации пользователя")
@Tag("web")
public class RegistrationTest extends TestBase {

    final RegistrationPage registrationPage = new RegistrationPage();
    final ProfilePage profilePage = new ProfilePage();
    final RandomUtils randomUtils = new RandomUtils();

    final String userName = randomUtils.getRandomUserName();
    final String userPassword = randomUtils.getRandomPassword();
    final String userEmail = randomUtils.getRandomEmail();

    @Test
    @Severity(BLOCKER)
    @DisplayName("Успешная регистрация нового пользователя на странице регистрации")
    @Story("Проверка ввода данных нового пользователя в доступные поля ввода и подтверждения регистрации")
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
    @Severity(CRITICAL)
    @DisplayName("Ошибка регистрации нового пользователя при отсутствии имени пользователя и пароля")
    @Story("Проверка, что появляется уведомление с информацией о причине ошибки при регистрации, если пользователь не ввел имя и пароль")
    void failRegistrationOfNewUserWithoutUsernameAndPasswordTest() {
        registrationPage.openRegistrationPage()
                .checkLoginForm()
                .setUserEmail(userEmail)
                .clickRegistrationButton()
                .checkErrorNotification("Missing username. Missing password.");
    }

    @Test
    @Severity(NORMAL)
    @DisplayName("Ошибка регистрации нового пользователя при отсутствии пароля")
    @Story("Проверка, что появляется уведомление с информацией о причине ошибки при регистрации, если пользователь не ввел пароль")
    void failRegistrationOfNewUserWithoutPasswordTest() {
        registrationPage.openRegistrationPage()
                .checkLoginForm()
                .setUserName(userName)
                .setUserEmail(userEmail)
                .clickRegistrationButton()
                .checkErrorNotification("Missing password.");
    }
}
