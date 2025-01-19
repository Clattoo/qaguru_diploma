package web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    private final SelenideElement welcomeSection = $(".welcome-section"),
            displayName = $("#displayName");

    @Step("Проверка соответствия имени для нового созданного пользователя")
    public void checkRegistrationOfNewUser(String userName) {
        welcomeSection.shouldBe(visible);
        displayName.shouldHave(value(userName));
    }
}
