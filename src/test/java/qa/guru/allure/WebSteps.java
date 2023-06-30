package qa.guru.allure;

import org.junit.jupiter.api.Test;

public class WebSteps extends TestBase {

    @Test
    public void webSteps() {

        AnnotationStep step = new AnnotationStep();

        step.openMainPage();
        step.searchForRepository(repositoryName);
        step.ClickOnRepositoryName(repositoryName);
        step.ClickOnIssueTab();
        step.IssueExist(issue);
    }
}
