package test.tests.appium;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import io.appium.java_client.AppiumBy;
import test.tests.TestBase;

public class WikipediaTests extends TestBase {
    @ValueSource(strings = {
            "Java", "Appium"
    })
    @ParameterizedTest(name = "Проверка наличия элементов в результатах поиска {0}")
    @Tag("emulator")
    void successfulSearchTest(String searchQuery) {
        back();
        step("Ввести в строку поиска значение {0}", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchQuery);
        });
        step("Проверить, что контент найден", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/TODO"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Проверка экрана адаптации")
    @Tag("emulator")
    void OnboardingScreenTest() {
        step("Проверка первой страницы", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });
        step("Нажать на кнопку Continue", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Проверка второй страницы", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
        });
        step("Нажать на кнопку Continue", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Проверка третьей страницы", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
        });
        step("Нажать на кнопку Continue", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("Проверка четвётой страницы", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Data & Privacy"));
        });
        step("Нажать на кнопку Get started", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
        });
    }
}