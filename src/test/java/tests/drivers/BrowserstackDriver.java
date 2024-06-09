package tests.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import tests.config.BrowserstackConfig;
import tests.config.MobileConfig;
import tests.config.UserConfig;
import tests.helpers.Browserstack;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    MobileConfig mobileConfig = ConfigFactory.create(MobileConfig.class, System.getProperties());
    UserConfig userConfig = ConfigFactory.create(UserConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", userConfig.getUserName());
        caps.setCapability("browserstack.key", userConfig.getAccessKey());

        // Set URL of the application under test
        caps.setCapability("app", mobileConfig.getAppUrl());

        // Specify device and os_version for testing
        caps.setCapability("device", mobileConfig.getDeviceModel());
        caps.setCapability("os_version", mobileConfig.getDeviceVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", browserstackConfig.getProject());
        caps.setCapability("build", browserstackConfig.getBuild());
        caps.setCapability("name", browserstackConfig.getName());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(browserstackConfig.getURL()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
