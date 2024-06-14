package test.tests.browserstack;

import io.appium.java_client.AppiumBy;
import test.tests.TestBase;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AndroidTests extends TestBase {
    @ValueSource(strings = {
            "Java", "Appium"
    })
    @ParameterizedTest(name = "Проверка наличия элементов в результатах поиска {0}")
    @Tag("android")
    void successfulSearchTest(String searchQuery) {
        step("Ввести в строку поиска значение {0}", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchQuery);
        });
        step("Проверить, что контент найден", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }
}

