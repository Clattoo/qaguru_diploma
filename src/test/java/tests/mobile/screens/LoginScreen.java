package tests.mobile.screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class LoginScreen {
    private final SelenideElement userNameField = $(id("com.habitrpg.android.habitica:id/username")),
            passwordField = $(id("com.habitrpg.android.habitica:id/password")),
            loginButton = $(id("com.habitrpg.android.habitica:id/login_btn")),
            errorTitleNotification = $(id("com.habitrpg.android.habitica:id/titleTextView"));

    @Step("Ввод имени пользователя {username} в поле ввода")
    public LoginScreen setUserName(String username) {
        userNameField.click();
        userNameField.setValue(username);

        return this;
    }

    @Step("Ввод пароля пользователя {password} в поле ввода")
    public LoginScreen setPassword(String password) {
        passwordField.click();
        passwordField.setValue(password);

        return this;
    }

    @Step("Нажать на кнопку Login и войти в аккаунт")
    public LoginScreen clickLoginButton() {
        loginButton.click();

        return this;
    }

    @Step("Проверка появления нотификации с ошибкой при нажатии на кнопку Login, когда не заполнены обязательные поля")
    public void checkErrorTitleNotification(String text) {
        errorTitleNotification.shouldHave(text(text));
    }
}
