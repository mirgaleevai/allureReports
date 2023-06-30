package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AllureReportTest extends TestBase {

    private static final String repositoryName = "eroshenkoam/allure-example";
    private static final int issue = 80;

    SelenideElement
            searchField = $("[name =q]"),
            issueTab = $("#issues-tab");

    @DisplayName("Test with annotation steps")
    @Test
    public void webSteps() {

        AnnotationStep step = new AnnotationStep();

        step.openMainPage();
        step.searchForRepository(repositoryName);
        step.clickOnRepositoryName(repositoryName);
        step.clickOnIssueTab();
        step.issueExist(issue);
    }

    @Test
    @DisplayName("Test with lambda steps")
    public void issueSearchLambdaSteps() {

        step("Open main page", () -> open(""));
        step("Search repository", () ->
        {
            $(searchField).click();
            $(searchField).sendKeys(repositoryName);
            $(searchField).submit();
        });
        step("Click on repository name", () -> $(linkText(repositoryName)).click());
        step("Click on issue tab", () -> $(issueTab).click());
        step("Issue with number " + issue + " exist", () ->
                $(withText("#" + issue)).should(Condition.exist));


    }
    @Test
    @DisplayName("Test with clean listener")
    public void issueSearchListener() {
        open("");
        $(searchField).click();
        $(searchField).sendKeys(repositoryName);
        $(searchField).submit();

        $(linkText(repositoryName)).click();
        $(issueTab).click();
        $(withText(String.valueOf(issue))).should(Condition.exist);

    }
}
