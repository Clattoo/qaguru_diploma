package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "system:properties",
        "classpath:properties/testdata.properties"
})

public interface TestDataConfig extends Config {

    @Key("userName")
    String getUserName();

    @Key("userPassword")
    String getUserPassword();
}
