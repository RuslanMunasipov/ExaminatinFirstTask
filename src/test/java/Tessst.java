import Hooks.WebHooks;
import PageObject.Jira.FourthPage;
import PageObject.Jira.LoginForm;
import PageObject.Jira.SecondPage;
import PageObject.Jira.ThirdPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.page;

public class Tessst extends WebHooks {
    @DisplayName("Авторизация")
    @Test
    public void loginJira() {
        Selenide.open(Utils.Configuration.getConfigurationValue("url"), LoginForm.class)
                .loginVal()
                .passwordVal()
                .clickButtonLogIn();
    }

    @DisplayName("Заполнение второй страницы")
    @Test
    public void secondPageBrowse() {
        Selenide.open(Utils.Configuration.getConfigurationValue("url"), LoginForm.class)
                .loginVal()
                .passwordVal()
                .clickButtonLogIn();
        page(SecondPage.class).clickToBrowse();
        page(SecondPage.class).clickToMainProj();
        page(SecondPage.class).clickToAllTasks();
        page(SecondPage.class).findText();
        page(SecondPage.class).enterText();
        page(SecondPage.class).checkingStatus();
        page(SecondPage.class).checkingVersion();
    }

    @DisplayName("Заполнение третьей страницы")
    @Test
    public void thirdPageBrowse() {
        Selenide.open(Utils.Configuration.getConfigurationValue("url"), LoginForm.class)
                .loginVal()
                .passwordVal()
                .clickButtonLogIn();
        page(SecondPage.class).clickToBrowse();
        page(SecondPage.class).clickToMainProj();
        page(SecondPage.class).clickToAllTasks();
        page(SecondPage.class).findText();
        page(SecondPage.class).enterText();
        page(SecondPage.class).checkingStatus();
        page(SecondPage.class).checkingVersion();
        page(ThirdPage.class).clickToCreateNewTask();
        page(ThirdPage.class).setIssueType();
        page(ThirdPage.class).setErrorTheme();
        page(ThirdPage.class).setErrInfo();
        page(ThirdPage.class).setOption();
        page(ThirdPage.class).setPriority();
        page(ThirdPage.class).setHashTag();
        page(ThirdPage.class).setMoreInfo();
        page(ThirdPage.class).clickToAssignMe();
        page(ThirdPage.class).clickSubmit();
    }

    @DisplayName("Заполнение четвертой страницы")
    @Test
    public void fourthPageBrowse() {
        Selenide.open(Utils.Configuration.getConfigurationValue("url"), LoginForm.class)
                .loginVal()
                .passwordVal()
                .clickButtonLogIn();
        page(SecondPage.class).clickToBrowse();
        page(SecondPage.class).clickToMainProj();
        page(SecondPage.class).clickToAllTasks();
        page(SecondPage.class).findText();
        page(SecondPage.class).enterText();
        page(SecondPage.class).checkingStatus();
        page(SecondPage.class).checkingVersion();
        page(ThirdPage.class).clickToCreateNewTask();
        page(ThirdPage.class).setIssueType();
        page(ThirdPage.class).setErrorTheme();
        page(ThirdPage.class).setErrInfo();
        page(ThirdPage.class).setOption();
        page(ThirdPage.class).setPriority();
        page(ThirdPage.class).setHashTag();
        page(ThirdPage.class).setMoreInfo();
        page(ThirdPage.class).clickToAssignMe();
        page(ThirdPage.class).clickSubmit();
        page(FourthPage.class).clickToFindTask();
        page(FourthPage.class).clickToCheckStatus();
        page(FourthPage.class).clickToSetReady();
        page(FourthPage.class).clickToCheckFinalStatus();
        page(FourthPage.class).clickCommentaryBtn();
    }
}
