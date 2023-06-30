package qa.guru.allure;

import org.junit.jupiter.api.Test;

public class WebStepsTest extends TestBase {

    @Test
    public void webSteps() {

        AnnotationStep step = new AnnotationStep();

        step.openMainPage();
        step.searchForRepository(repositoryName);
        step.clickOnRepositoryName(repositoryName);
        step.clickOnIssueTab();
        step.issueExist(issue);
    }
}
