package data;

import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;

public class AuthData {
    public final String userName;
    public final String password;

    public AuthData(WebDriverConfig config) {
        this.userName = config.getTestUserName();
        this.password = config.getTestUserPassword();
    }

    // Статический метод для создания экземпляра AuthData с использованием конфигурации
    public static AuthData create() {
        WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class);
        return new AuthData(webDriverConfig);
    }
}