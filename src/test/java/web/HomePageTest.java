package web;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.pages.HomePage;
import web.pages.RegistrationPage;
import utils.RandomUtils;

import static io.qameta.allure.SeverityLevel.*;

@Feature("Тестирование домашней страницы Habitica без активного аккаунта")
@Tag("web")
public class HomePageTest extends TestBase {

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();

    String userName = randomUtils.getRandomUserName();

    @Test
    @Severity(BLOCKER)
    @DisplayName("При нажатии на кнопку 'Get Started' пользователь попадает на страницу регистрации пользователя")
    void openRegistrationPageFromHomePageTest() {
        homePage.openHomePage()
                .clickBeginButton();
        registrationPage.checkLoginForm();
    }

    @Test
    @Severity(NORMAL)
    @DisplayName("При нажатии на кнопку 'Sign Up' без ввода имени, почты и пароля пользователя появляется уведомление с полным текстом ошибки")
    void clickRegistrationButtonWithoutUserNameEmailPasswordTest() {
        homePage.openHomePage()
                .clickRegistrationButton()
                .checkErrorNotification("Missing username. Missing email. Missing password.");
    }

    @Test
    @Severity(NORMAL)
    @DisplayName("При нажатии на кнопку 'Sign Up' без ввода почты и пароля пользователя появляется уведомление с текстом об отсутствии почты и пароля")
    void clickRegistrationButtonWithoutEmailPasswordTest() {
        homePage.openHomePage()
                .setUserName(userName)
                .clickRegistrationButton()
                .checkErrorNotification("Missing email. Missing password.");
    }

    @Test
    @Severity(MINOR)
    @DisplayName("При нажатии на кнопку 'Mobile Apps' пользователь переходит к разделу о мобильных приложениях внутри домашней страницы")
    void clickMobileAppsTest() {
        homePage.openHomePage()
                .clickMobileAppsButton();
    }

}
