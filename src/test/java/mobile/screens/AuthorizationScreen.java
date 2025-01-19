package mobile.screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class AuthorizationScreen {
    private final SelenideElement registerButton = $(id("com.habitrpg.android.habitica:id/new_game_button")),
    loginButton = $(id("com.habitrpg.android.habitica:id/show_login_button"));

    @Step("Проверка открытия экрана с кнопками Login и Register")
    public void checkLoginScreen() {
        registerButton.shouldBe(visible);
        loginButton.shouldBe(visible);
    }

    @Step("Нажать на кнопку Login на странице авторизации пользователя")
    public void clickLoginButton() {
        loginButton.click();
    }
}
