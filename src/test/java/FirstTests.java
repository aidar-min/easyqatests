import com.codeborne.selenide.Configuration;
import com.easyqa.qa.page.*;
import com.easyqa.qa.page.util.CardData;
import com.easyqa.qa.page.util.UserData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;


public class FirstTests {

    private static final Object URL = open("https://app.geteasyqa.com/users/sign_in",LoginPage.class);

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        Configuration.browser="chrome";
        Configuration.browserSize="1024x768";
    }


    /*
        @Test
        public void loginAsRegisteredUser()  {

            LoginPage LoginPage = open("https://app.geteasyqa.com/users/sign_in",LoginPage.class);
            LoginPage.enterLogin("aidarmindikaev@gmail.com");
            LoginPage.enterPassword("1410aidar");
            DashboardPage dashboardPage = LoginPage.clickLoginBtn();
            dashboardPage.checkUserAuthorized();
        }

        @Test
        public void openPojects(){
            LoginPage LoginPage = open("https://app.geteasyqa.com/users/sign_in",LoginPage.class);
            LoginPage.enterLogin("aidarmindikaev@gmail.com");
            LoginPage.enterPassword("1410aidar");
            DashboardPage dashboardPage = LoginPage.clickLoginBtn();
            dashboardPage.checkUserAuthorized();
            ProjectsPage projectsPage = dashboardPage.openMyProjects();
            projectsPage.checkProjectsPage();

        }
    */
    @Test
    public void createCard() {
        CardData issue = new CardData("test2", "test description");
        UserData userData = new UserData("aidarmindikaev@gmail.com","1410aidar");
        LoginPage LoginPage = open("https://app.geteasyqa.com/users/sign_in", LoginPage.class);
        LoginPage.enterUser(userData.getUserEmail(), userData.getUserPassword());
        /*LoginPage.enterLogin("aidarmindikaev@gmail.com");
        LoginPage.enterPassword("1410aidar");*/
        DashboardPage dashboardPage = LoginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
        ProjectsPage projectsPage = dashboardPage.openMyProjects();
        projectsPage.checkProjectsPage();
        ProjectDashboardPage projectDashboardPage = projectsPage.openProject();
        projectDashboardPage.checkProjectDashboardPage();
        IssuesPage issuesPage = projectDashboardPage.openIssues();
        issuesPage.checkIssuesPage();
        issuesPage.clickAddNewIssue();
        issuesPage.addNewIssue(issue.getCardName(), issue.getCardDescription());
        issuesPage.checkIssueAdded(issue.getCardName());

    }


    @AfterMethod
    public void tearDown() throws Exception {
        close();
    }
}