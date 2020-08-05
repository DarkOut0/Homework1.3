package com.google;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pageObjects.GoogleSearchResult;
import java.util.function.BooleanSupplier;

public class Steps {
    @Step
    public static void checkSize(GoogleSearchResult resultSearch){
        //Assertions.assertTrue((BooleanSupplier) resultSearch.results().shouldHave(CollectionCondition.sizeGreaterThan(3)));
        Assertions.assertTrue(resultSearch.results().size() > 3);
    }

    @Step
    public static void checkHeader(GoogleSearchResult resultSearch, String text){
        Assertions.assertTrue((BooleanSupplier) resultSearch.results().shouldHave(CollectionCondition.texts(text)));
    }
}
