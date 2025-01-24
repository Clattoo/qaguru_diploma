package data;

import config.TestDataConfig;
import org.aeonbits.owner.ConfigFactory;

public class AuthData {

    TestDataConfig config = ConfigFactory.create(TestDataConfig.class);

    public String userName = config.getUserName();
    public String userPassword = config.getUserPassword();

}