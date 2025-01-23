package tests.mobile.screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class ProfileScreen {

    private final SelenideElement profileName = $(id("com.habitrpg.android.habitica:id/toolbar_title"));

    @Step("Проверка открытия профиля пользователя с именем {username}")
    public void checkProfileName(String value) {
        profileName.shouldHave(text(value));

    }
}
