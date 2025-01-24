package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${testdata}.properties",
        "classpath:properties/testdata.properties"
})

public interface TestDataConfig extends Config {

    @Key("userName")
    @DefaultValue("${sys:userName}")
    String getUserName();

    @Key("userPassword")
    @DefaultValue("${sys:userPassword}")
    String getUserPassword();
}
