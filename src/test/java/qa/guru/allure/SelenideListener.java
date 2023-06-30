package qa.guru.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideListener extends TestBase {

    @Test
    public void issueSearchListener() {
        open(baseUrl);
        $(searchField).click();
        $(searchField).sendKeys(repositoryName);
        $(searchField).submit();

        $(linkText(repositoryName)).click();
        $(issueTab).click();
        $(withText("#80")).should(Condition.exist);

    }
}
