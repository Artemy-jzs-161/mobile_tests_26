package tests;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class SearchTest extends TestBase {

    @Test
    void successfulSearchTest() {

        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        step("Verify content found", () ->
            $$(className("android.widget.TextView"))
                    .shouldHave(CollectionCondition.sizeGreaterThan(0)));
            }
}
