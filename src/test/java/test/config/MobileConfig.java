package test.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:android.properties",
        "classpath:ios.properties"})

public interface MobileConfig extends Config {

    @Key("device")
    String getDeviceModel();

    @Key("os_version")
    String getDeviceVersion();

    @Key("appURL")
    String getAppUrl();

}