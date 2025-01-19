package web;

import helpers.extensions.WithLogin;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import web.pages.ShopsMarketPage;


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
    @ParameterizedTest(name = "Проверка фильтрации вещей по классу {0} на странице Market")
    @WithLogin
    public void checkFilterByClassNameTest(String className) {
        shopsMarketPage.openMarketPage()
                .clickClassTypeDropdownButton()
                .chooseClassFilter(className)
                .checkFilterByClassName(className);
    }
}
