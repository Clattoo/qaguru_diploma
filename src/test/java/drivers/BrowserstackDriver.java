package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    public static BrowserstackConfig browserStackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", browserStackConfig.getUser());
        caps.setCapability("browserstack.key", browserStackConfig.getKey());

        caps.setCapability("device", browserStackConfig.getDevice());
        caps.setCapability("os_version", browserStackConfig.getVersion());

        caps.setCapability("app", browserStackConfig.getApp());

        caps.setCapability("project", browserStackConfig.getProjectName());
        caps.setCapability("build", browserStackConfig.getBuildName());
        caps.setCapability("name", browserStackConfig.getTestName());

        try {
            return new RemoteWebDriver(
                    new URL(browserStackConfig.getRemoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}