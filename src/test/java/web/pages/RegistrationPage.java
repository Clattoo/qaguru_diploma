package web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import web.pages.components.ErrorNotificationComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationPage {

    ErrorNotificationComponent errorNotificationComponent = new ErrorNotificationComponent();

    private final SelenideElement userNameInput = $("#usernameInput"),
            userEmailInput = $("#emailInput"),
            userPasswordInput = $("#passwordInput"),
            userConfirmationPasswordInput = $("#confirmPasswordInput"),
            submitRegistrationButton = $(".btn.btn-info"),
            loginForm = $("#login-form");


    @Step("Открытие страницы регистрации нового пользователя")
    public RegistrationPage openRegistrationPage() {
        open("/register");

        return this;
    }

    @Step("Проверка перехода пользователя на страницу регистрации")
    public RegistrationPage checkLoginForm() {
        loginForm.shouldBe(visible);

        return this;
    }

    @Step("Ввод имени пользователя в поле ввода на странице регистрации")
    public RegistrationPage setUserName(String userName) {
        userNameInput.setValue(userName);

        return this;
    }

    @Step("Ввод почты пользователя в поле ввода на странице регистрации")
    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);

        return this;
    }

    @Step("Ввод пароля пользователя в поле ввода на странице регистрации")
    public RegistrationPage setUserPassword(String userPassword) {
        userPasswordInput.setValue(userPassword);

        return this;
    }

    @Step("Повторный ввод пароля пользователя в поле ввода на странице регистрации")
    public RegistrationPage setUserConfirmationPassword(String confirmationPassword) {
        userConfirmationPasswordInput.setValue(confirmationPassword);

        return this;
    }

    @Step("Нажать кнопку регистрации на странице регистрации нового пользователя")
    public RegistrationPage clickRegistrationButton() {
        submitRegistrationButton.click();

        return this;
    }

    @Step("Проверка появления ошибки регистрации после нажатия кнопки 'Регистрация'")
    public void checkErrorNotification(String errorText) {
        errorNotificationComponent.checkErrorNotification(errorText);
    }
}
