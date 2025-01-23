package data;

import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;

public class AuthData {

    WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class);

    public final String userName = config.getTestUserName();
    public final String password = config.getTestUserPassword();

}