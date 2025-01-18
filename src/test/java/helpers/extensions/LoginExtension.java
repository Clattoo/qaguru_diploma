package helpers.extensions;

import api.api.AuthorizationApi;
import api.models.LoginResponseModel;
import data.AuthData;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;

public class LoginExtension implements BeforeEachCallback {
    public static LoginResponseModel cookies;

    @Override
    public void beforeEach(ExtensionContext context) {

        cookies = AuthorizationApi.getAuthorizationCookie();

        step("Добавить cookie (в ответе) из браузера", () -> {
            open("/static/icons/favicon.ico");
            getWebDriver().manage().addCookie(new Cookie("username", cookies.getData().getUsername()));
            getWebDriver().manage().addCookie(new Cookie("apiToken", cookies.getData().getApiToken()));
            getWebDriver().manage().addCookie(new Cookie("id", cookies.getData().getId()));
        });

        step("Проверить успешный вход в учетную запись", () -> {
                    open("/");
                    $(".character-name").shouldBe(visible);
                    $(".character-name").shouldHave(text(AuthData.USER_NAME));
                }
        );
    }
}
