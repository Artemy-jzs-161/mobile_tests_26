package test.tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Tag("ios")
public class IOSTests extends TestBase {
    @Test
    @DisplayName("Проверка элементов на странице")
    @Tag("ios")
    void verifyMainPageElementsExistingTest() {
        step("Проверка отображения элементов на главной странице", () -> {
            $(AppiumBy.className("XCUIElementTypeStaticText")).$(AppiumBy.name("UI Elements")).should(exist);
            $(AppiumBy.name("Text Button")).shouldBe(Condition.visible);
            $(AppiumBy.name("Text")).shouldBe(Condition.visible);
            $(AppiumBy.name("Tab Bar")).should(exist);
        });
    }
}
