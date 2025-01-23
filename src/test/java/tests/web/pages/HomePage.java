package tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.web.pages.components.ErrorNotificationComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class HomePage {

    final ErrorNotificationComponent errorNotificationComponent = new ErrorNotificationComponent();

    private final String textMobileAppsButton = "Mobile Apps";

    private final SelenideElement beginButton = $("a[href*='/register']"),
            userNameInput = $("#usernameInput"),
            registrationButton = $(".sign-up"),
            mobileAppsButton = $(byText(textMobileAppsButton)),
            mobileAppsInfoArea = $("#level-up-anywhere");

    @Step("Открыть домашнюю страницу habitica.com")
    public HomePage openHomePage() {
        open("/");

        return this;
    }

    @Step("Ввод имени пользователя {userName} в поле ввода имени на главной странице сайта")
    public HomePage setUserName(String userName) {
        userNameInput.setValue(userName);

        return this;
    }

    @Step("Нажать кнопку 'Get Started' на домашней странице")
    public void clickBeginButton() {
        beginButton.click();
    }

    @Step("Нажать кнопку 'Sign Up' на домашней странице")
    public HomePage clickRegistrationButton() {
        registrationButton.click();

        return this;
    }

    @Step("Нажать кнопку 'Mobile Apps' на домашней странице")
    public void clickMobileAppsButton() {
        mobileAppsButton.click();
        mobileAppsInfoArea.shouldBe(visible);
    }

    @Step("Проверка появления ошибки регистрации после нажатия кнопки 'Sign Up'")
    public final void checkErrorNotification(String errorText) {
        errorNotificationComponent.checkErrorNotification(errorText);
    }
}
