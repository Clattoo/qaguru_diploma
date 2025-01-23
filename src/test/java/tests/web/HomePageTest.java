package tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.web.pages.HomePage;
import tests.web.pages.RegistrationPage;
import tests.web.pages.TermsOfServicePage;
import utils.RandomUtils;

import static io.qameta.allure.SeverityLevel.*;

@Feature("Тестирование домашней страницы Habitica без активного аккаунта")
@Tag("web")
public class HomePageTest extends TestBase {

    final HomePage homePage = new HomePage();
    final TermsOfServicePage termsOfServicePage = new TermsOfServicePage();
    final RegistrationPage registrationPage = new RegistrationPage();
    final RandomUtils randomUtils = new RandomUtils();

    final String userName = randomUtils.getRandomUserName();

    final String agreementDocumentHeader = "Terms of Service";

    @Test
    @Severity(BLOCKER)
    @DisplayName("Пользователь может открыть документ 'Terms of Service' при переходе с домашней страницы на страницу регистрации")
    void openRegistrationPageFromHomePageTest() {
        homePage.openHomePage()
                .clickBeginButton();
        registrationPage.checkLoginForm()
                .clickTermsOfServiceButton();
        termsOfServicePage.checkDocumentTitle(agreementDocumentHeader);
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
