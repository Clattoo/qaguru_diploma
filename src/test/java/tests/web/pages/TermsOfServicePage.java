package tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class TermsOfServicePage {

    private final SelenideElement TermsOfServiceDocument = $(".static-wrapper");

    @Step("Проверка открытия страницы 'Terms of Service'")
    public void checkDocumentTitle(String documentHeader) {
        TermsOfServiceDocument.shouldHave(Condition.text(documentHeader));
    }
}
