package test.tests.appium;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.Allure.step;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.appium.java_client.AppiumBy;

public class WikipediaTests {

    @Tag("emulator")
    @Test
    void successfulSearchTest() {
        back();
        step("Ввести в строку поиска значение {0}", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys();
        });
        step("Проверить, что контент найден", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }
}
