package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class GoogleSearchResult {
    public ElementsCollection results(){
        ElementsCollection results = $$(By.xpath("//div[@class='g']"));
        return results;
    }
}
