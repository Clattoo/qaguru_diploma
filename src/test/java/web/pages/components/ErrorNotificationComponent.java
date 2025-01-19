package web.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ErrorNotificationComponent {

    private final SelenideElement errorNotification = $(".notification-holder");

    @Step("Проверка появления ошибки регистрации после нажатия кнопки регистрации")
    public void checkErrorNotification(String errorText) {
        errorNotification.shouldBe(visible);
        errorNotification.shouldHave(text(errorText));
    }
}
