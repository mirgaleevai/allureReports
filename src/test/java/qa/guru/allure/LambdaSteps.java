package qa.guru.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaSteps extends TestBase {

    @Test
    public void issueSearchLambdaSteps() {

        step("Open main page", () -> {
            open(baseUrl);
        });
        step("Search repository", () ->
        {
            $(searchField).click();
            $(searchField).sendKeys(repositoryName);
            $(searchField).submit();
        });

        step("Click on repository name", () -> {
            $(linkText(repositoryName)).click();
        });
        step("Click on issue tab", () -> {
            $(issueTab).click();
        });
        step("Issue with number " + issue + " exist", () -> {
            $(withText("#" + issue)).should(Condition.exist);
        });


    }
}

