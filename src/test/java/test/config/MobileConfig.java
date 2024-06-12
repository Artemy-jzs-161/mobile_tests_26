package test.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
        "classpath:config/${platform}.properties"})

public interface MobileConfig extends Config {

    @Key("device")
    String getDeviceModel();

    @Key("os_version")
    String getDeviceVersion();

    @Key("appURL")
    String getAppUrl();

}