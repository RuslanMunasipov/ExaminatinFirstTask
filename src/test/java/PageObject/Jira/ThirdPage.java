package PageObject.Jira;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;

public class ThirdPage extends SecondPage {

    @FindBy (how = How.XPATH, using = "//a[@id = 'create_link']")
    private SelenideElement createNewTask;

    @FindBy (how = How.XPATH, using = "//input[@id = 'issuetype-field']")
    private SelenideElement issueType;

    @FindBy (how = How.XPATH, using = "//input[@id = 'summary']")
    private SelenideElement errorTheme;


    @FindBy (how = How.XPATH, using = "//body['#aui-layout aui-theme-default ka ajax-issue-search-and-view page-type-navigator page-type-split']/ancestor::html[@class = 'webkit chrome']//div[@class = 'jira-wikifield']//div[@id = 'description-wiki-edit']//iframe")
    private SelenideElement errInfo;


    @FindBy (how = How.XPATH, using = "//input[@id = 'priority-field']")
    private SelenideElement prior;

    @FindBy (how = How.XPATH, using = "//textarea[@id = 'labels-textarea']")
    private SelenideElement hashTag;

    @FindBy (how = How.XPATH, using = "//iframe[@id = 'mce_8_ifr']")
    private SelenideElement moreInfo;

    @FindBy (how = How.XPATH, using = "//option[@value = '10001']")
    private SelenideElement option;

    @FindBy (how = How.XPATH, using = "//a[@id = 'assign-to-me-trigger']")
    private SelenideElement assignMe;

    @FindBy (how = How.XPATH, using = "//input[@id = 'create-issue-submit']")
    private SelenideElement submit;


    @Step("Создать новый таск")
    public ThirdPage clickToCreateNewTask() {
        createNewTask.click();
        return page(FourthPage.class);
    }

    @Step("Выбрать тип ошибки")
    public ThirdPage setIssueType(){
        issueType.sendKeys("Ошибка");
        issueType.pressEnter();
        return page(FourthPage.class);
    }

    @Step("Выставить инфо")
    public ThirdPage setErrorTheme(){
        errorTheme.click();
        errorTheme.setValue("Ошибка АТ \"Мунасипов\" ");
        return page(FourthPage.class);
    }

    @Step("Занести информацию об ошибке")
    public ThirdPage setErrInfo(){
        Selenide.switchTo().defaultContent();
        SelenideElement iframe = $x("//body['#aui-layout aui-theme-default ka ajax-issue-search-and-view page-type-navigator page-type-split']/ancestor::html[@class = 'webkit chrome']//div[@class = 'jira-wikifield']//div[@id = 'description-wiki-edit']//iframe");
        Selenide.switchTo().frame(iframe);
        $x("//body[@id = 'tinymce']/p").sendKeys("1231231231");
        Selenide.switchTo().defaultContent();
        return page(FourthPage.class);
    }

    @Step("Выбрать опцию ошибки")
    public ThirdPage setOption(){
        option.doubleClick();
        return page(FourthPage.class);
    }

    @Step("Выбрать приоритет ошибки")
    public ThirdPage setPriority(){
        prior.sendKeys("Low");
        prior.pressEnter();
        return page(FourthPage.class);
    }

    @Step("Выставить тэг ошибки")
    public ThirdPage setHashTag(){
        hashTag.sendKeys("blitz_test");
        hashTag.pressEnter();
        return page(FourthPage.class);
    }

    @Step("Ввести дополнительную информацию об ошибке")
    public ThirdPage setMoreInfo(){
        Selenide.switchTo().defaultContent();
        SelenideElement iframe = $x("//body['#aui-layout aui-theme-default ka ajax-issue-search-and-view page-type-navigator page-type-split']/ancestor::html[@class = 'webkit chrome']//div[@class = 'jira-wikifield']//div[@id = 'environment-wiki-edit']//iframe");
        Selenide.switchTo().frame(iframe);
        $x("//body[@id = 'tinymce']/p").sendKeys("1231231231");
        Selenide.switchTo().defaultContent();
        return page(FourthPage.class);
    }

    @Step("Выбрать исполнителя")
    public ThirdPage clickToAssignMe(){
        assignMe.click();
        return page(FourthPage.class);
    }

    @Step("Засабмитить таск")
    public ThirdPage clickSubmit(){
        submit.click();
        return page(FourthPage.class);
    }
}
