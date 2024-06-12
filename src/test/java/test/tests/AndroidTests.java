package test.tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("android_tests")
public class AndroidTests extends TestBase {

    @Test
    @DisplayName("Проверка наличия элементов в результатах поиска")
    void successfulSearchAppiumTest() {
        step("Ввести в строку поиска значение Appium", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        step("Проверить, что контент найден", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Проверка наличия элементов в результатах поиска")
    void successfulSearchJavaTest() {
        step("Ввести в строку поиска значение Java", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Java");
        });

        step("Проверить, что контент найден", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }


}
