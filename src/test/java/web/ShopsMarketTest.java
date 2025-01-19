package web;

import helpers.extensions.WithLogin;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import web.pages.ShopsMarketPage;

@Feature("Тестирование страницы магазина пользователя")
@Tag("web")
public class ShopsMarketTest extends TestBase {

    ShopsMarketPage shopsMarketPage = new ShopsMarketPage();

    @ValueSource(strings = {
            "Healer",
            "Mage",
            "Rogue",
            "Warrior",
            "None"
    })
    @ParameterizedTest
    @WithLogin
    @Severity("MINOR")
    @DisplayName("Включение фильтра по выбранному классу {0}")
    @Story("Тестирование возможности использования фильтров по классам для выбора нужных предметов")
    public void checkFilterByClassNameTest(String className) {
        shopsMarketPage.openMarketPage()
                .clickClassTypeDropdownButton()
                .chooseClassFilter(className)
                .checkFilterByClassName(className);
    }
}
