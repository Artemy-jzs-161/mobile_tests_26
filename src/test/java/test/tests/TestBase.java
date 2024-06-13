package test.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;

import test.drivers.BrowserstackDriver;
import test.drivers.EmulatorDriver;
import test.helpers.Attach;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    public static String deviceHost = System.getProperty("deviceHost", "browserstack");

    @BeforeAll
    static void beforeAll() throws Exception {
        switch (deviceHost) {
            case "browserstack":
                Configuration.browser = BrowserstackDriver.class.getName();
                break;
            case "emulation":
                Configuration.browser = EmulatorDriver.class.getName();
                break;
            default:
                throw new Exception("Unrecognised deviceHost");
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = sessionId().toString();
        Attach.pageSource();

        if (deviceHost.equals("browserstack")) {
            Attach.addVideo(sessionId);
        }

        closeWebDriver();
    }
}
