package com.google;

import com.codeborne.selenide.Configuration;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObjects.GoogleMainPage;
import pageObjects.GoogleSearchResult;

import static com.codeborne.selenide.Selenide.open;

public class Tests {
    @BeforeEach
    public void option(){
        Configuration.timeout = 6000;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }

    @Test
    @Description(value = "Тест количества заголовков")
    public void selenidTest(){
        GoogleMainPage google = open("https://www.google.ru/", GoogleMainPage.class);
        GoogleSearchResult resultSearch = google.search("Гладиолус");
        Steps.checkSize(resultSearch);
    }

    @Test
    @Description(value = "Присутствие текста 'Гладиолус - Википедия'")
    public void selenidTestHeader(){
        GoogleMainPage google = open("https://www.google.ru/", GoogleMainPage.class);
        GoogleSearchResult resultSearch = google.search("Гладиолус");
        Steps.checkHeader(resultSearch, "Гладиолус - Википедия");
    }
}
