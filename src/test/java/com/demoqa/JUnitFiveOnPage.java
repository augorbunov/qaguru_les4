package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class JUnitFiveOnPage {

    @BeforeAll
    static void setUp () {
        //Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void softAssertionsShouldContainJUnit5Example() throws InterruptedException {

        // открыть страницу репозитория селенида
        open("https://github.com/selenide/selenide");

        // перейти в раздел Wiki проекта
        $("#wiki-tab").click();

        // убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        // открыть страницу SoftAssertions
        $(".wiki-more-pages-link").$("button").click();
        $(".wiki-pages-box").$(byTagAndText("a", "SoftAssertions")).click();

        // проверить, что внутри есть пример кода для JUnit5
        String jUnit5Example = "@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}";

        $$("div").filterBy(text("Using JUnit5")).shouldHave(sizeGreaterThan(0));
        $(".markdown-body").shouldHave(text(jUnit5Example)).shouldBe(visible);

        //sleep(5000);

    }
}
