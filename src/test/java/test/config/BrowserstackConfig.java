package test.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${envMobile}.properties"})
public interface BrowserstackConfig extends Config {
    @Key("user")
    String userName();

    @Key("access")
    String accessKey();

    @Key("device")
    String deviceModel();

    @Key("os_version")
    String deviceVersion();

    @Key("appURL")
    String appUrl();

    @Key("project")
    String project();

    @Key("build")
    String build();

    @Key("name")
    String name();

    @Key("URL")
    String URL();
}