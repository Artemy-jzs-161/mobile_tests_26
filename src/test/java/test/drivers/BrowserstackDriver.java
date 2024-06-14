package test.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import test.config.BrowserstackConfig;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
    BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", browserstackConfig.userName());
        caps.setCapability("browserstack.key", browserstackConfig.accessKey());
        caps.setCapability("app", browserstackConfig.appUrl());
        caps.setCapability("device", browserstackConfig.deviceModel());
        caps.setCapability("os_version", browserstackConfig.deviceVersion());
        caps.setCapability("project", browserstackConfig.project());
        caps.setCapability("build", browserstackConfig.build());
        caps.setCapability("name", browserstackConfig.name());

        try {
            return new RemoteWebDriver(
                    new URL(browserstackConfig.URL()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
