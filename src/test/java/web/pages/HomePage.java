package web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import web.pages.components.ErrorNotificationComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class HomePage {

    ErrorNotificationComponent errorNotificationComponent = new ErrorNotificationComponent();

    private final String textMobileAppsButton = "Мобильные приложения";

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

    @Step("Нажать кнопку 'Начать' на домашней странице")
    public HomePage clickBeginButton() {
        beginButton.click();

        return this;
    }

    @Step("Нажать кнопку 'Регистрация' на домашней странице")
    public HomePage clickRegistrationButton() {
        registrationButton.click();

        return this;
    }

    @Step("Нажать кнопку 'Мобильные приложения' на домашней странице")
    public HomePage clickMobileAppsButton() {
        mobileAppsButton.click();
        mobileAppsInfoArea.shouldBe(visible);

        return this;
    }

    @Step("Проверка появления ошибки регистрации после нажатия кнопки 'Регистрация'")
    public HomePage checkErrorNotification(String errorText) {
        errorNotificationComponent.checkErrorNotification(errorText);

        return this;
    }
}
