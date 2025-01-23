package tests.mobile.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class OnboardingComponent {

    private final SelenideElement skipButton = $(id("com.habitrpg.android.habitica:id/skipButton")),
            descriptionTextField = $(id("com.habitrpg.android.habitica:id/descriptionTextView"));


    @Step("Нажать на кнопку 'Skip' во время онбординга")
    public void clickSkipButton() {
        skipButton.click();

    }


    @Step("Проверить описание шага онбординга в поле Description")
    public OnboardingComponent checkDescriptionText(String descriptionText) {
        descriptionTextField.shouldHave(text(descriptionText));
        return this;
    }
}
