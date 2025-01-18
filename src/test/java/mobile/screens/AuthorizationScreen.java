package mobile.screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class AuthorizationScreen {
    private final SelenideElement habiticaLogo = $(id("com.habitrpg.android.habitica:id/logo_view")),
    registerButton = $(id("com.habitrpg.android.habitica:id/new_game_button")),
    loginButton = $(id("com.habitrpg.android.habitica:id/new_game_button"));

    @Step("Проверка открытия экрана с кнопками Login и Register")
    public AuthorizationScreen checkLoginScreen() {
        habiticaLogo.shouldBe(visible);
        registerButton.shouldBe(exist);
        loginButton.shouldBe(exist);

        return this;
    }

    @Step("Нажать на кнопку Login на странице авторизации пользователя")
    public AuthorizationScreen clickLoginButton() {
        loginButton.click();

        return this;
    }

    @Step("Нажать на кнопку Login на странице авторизации пользователя")
    public AuthorizationScreen clickRegisterButton() {
        registerButton.click();

        return this;
    }

}
