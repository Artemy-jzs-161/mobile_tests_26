package test.config;


import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:user.properties",
        "system:properties"
})

public interface UserConfig extends Config {

    @Key("user")
    String getUserName();

    @Key("access")
    String getAccessKey();

}