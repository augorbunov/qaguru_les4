package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class JUnitFiveOnPage {

    @BeforeAll
    static void setUp () {
        //Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void softAssertionsShouldContainJUnit5Example() throws InterruptedException {

        // открыть страницу репозитория селенида
        open("https://github.com/selenide/selenide");

        // перейти в раздел Wiki проекта
        $("#wiki-tab").click();

        // убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $(".markdown-body").shouldHave(text("Soft Assertions"));

        // открыть страницу SoftAssertions
        $$(".markdown-body ul li").filterBy(text("Soft Assertions")).first().$("a").click();

        // проверить, что внутри есть пример кода для JUnit5
        $$("div").filterBy(text("Using JUnit5")).shouldHave(sizeGreaterThan(0));

        //sleep(5000);

    }
}
