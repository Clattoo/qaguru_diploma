package tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ShopsMarketPage {
    private final SelenideElement classTypeDropdownButton = $(".btn.dropdown-toggle.btn-secondary"),
            classTypeList = $(".dropdown-menu.dropdown-menu-right.show");

    @Step("Открыть страницу Market")
    public ShopsMarketPage openMarketPage() {
        open("/shops/market");

        return this;
    }

    @Step("Нажать на выпадающий список классов")
    public ShopsMarketPage clickClassTypeDropdownButton() {
        classTypeDropdownButton.click();

        return this;
    }

    @Step("Выбрать класс из выпадающего списка")
    public ShopsMarketPage chooseClassFilter(String className) {
        classTypeList.$(byText(className)).click();

        return this;
    }

    @Step("Проверить применение фильтра по выбранному классу")
    public void checkFilterByClassName(String className) {
        classTypeDropdownButton.shouldHave(text(className));
    }

}
