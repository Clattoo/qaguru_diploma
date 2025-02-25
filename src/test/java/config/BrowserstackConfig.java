package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${deviceHost}.properties"
})

public interface BrowserstackConfig extends Config {

    @Key("device")
    @DefaultValue("Google Pixel 9")
    String getDevice();

    @Key("versionOs")
    @DefaultValue("15.0")
    String getVersion();

    @Key("browserStackRemoteUrl")
    String getBrowserStackRemoteUrl();

    @Key("browserStackUser")
    String getBrowserStackUser();

    @Key("browserStackKey")
    String getBrowserStackKey();

    @Key("app")
    @DefaultValue("bs://sample.app")
    String getApp();

    @Key("projectName")
    @DefaultValue("First Java Project")
    String getProjectName();

    @Key("buildName")
    @DefaultValue("browserstack-build-1")
    String getBuildName();

    @Key("testName")
    @DefaultValue("My First Test")
    String getTestName();

}
