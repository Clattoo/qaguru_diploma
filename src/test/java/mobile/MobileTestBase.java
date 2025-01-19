package mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.EmulatorAndRealDeviceDriver;
import helpers.MobileAttach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class MobileTestBase {
    @BeforeAll
    public static void setUp() {
        String deviceHost = System.getProperty("deviceHost");
        if (deviceHost.equals("real") || deviceHost.equals("emulator")) {
            Configuration.browser = EmulatorAndRealDeviceDriver.class.getName();
        } else if (deviceHost.equals("browserstack")) {
            Configuration.browser = BrowserstackDriver.class.getName();
        }
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        if (System.getProperty("deviceHost").equals("browserstack")) {
            String sessionId = Selenide.sessionId().toString();
            MobileAttach.addVideo(sessionId);
        }
        if (System.getProperty("deviceHost").equals("emulation")) {
            MobileAttach.screenshotAs("Last screenshot");
        }
        MobileAttach.pageSource();
        closeWebDriver();
    }
}
