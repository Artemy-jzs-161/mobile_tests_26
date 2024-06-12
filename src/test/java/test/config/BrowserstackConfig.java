package test.config;


import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})
public interface BrowserstackConfig extends Config {

    @Key("user")
    String getUserName();

    @Key("access")
    String getAccessKey();

    @Key("device")
    String getDeviceModel();

    @Key("os_version")
    String getDeviceVersion();

    @Key("appURL")
    String getAppUrl();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();

    @Key("URL")
    String getURL();

}