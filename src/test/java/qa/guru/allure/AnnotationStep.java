package qa.guru.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class AnnotationStep extends TestBase {

    @Step("Открыть главную страницу")
    public void openMainPage() {
        open(baseUrl);
    }

    @Step("Перейти по ссылке в репозиторий {repositoryName}")
    public void searchForRepository(String repositoryName) {
        $(searchField).click();
        $(searchField).sendKeys(repositoryName);
        $(searchField).submit();
    }

    @Step("Нажать на наименование репозитория {repositoryName}")
    public void ClickOnRepositoryName(String repositoryName) {
        $(linkText(repositoryName)).click();
    }

    @Step("Нажать на таб Issues")
    public void ClickOnIssueTab() {
        $(issueTab).click();
    }

    @Step("Issue c номером {issue} существует")
    public void IssueExist(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }

}

