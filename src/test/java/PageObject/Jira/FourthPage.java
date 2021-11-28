package PageObject.Jira;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class FourthPage extends ThirdPage {
    @FindBy(how = How.XPATH, using = "//input[@class = 'search-entry text medium-field ajs-dirty-warning-exempt']")
    private SelenideElement findTask;

    @FindBy(how = How.XPATH, using = "//span[text() = 'В работе']")
    private SelenideElement statusCheck;

    @FindBy(how = How.XPATH, using = "//span[text() = 'Бизнес-процесс']")
    private SelenideElement setReady;

    @FindBy(how = How.XPATH, using = "//span[@class = 'trigger-label' and contains (text(), 'Комментарий')]")
    private SelenideElement commentaryBtn;

    @FindBy(how = How.XPATH, using = "//span[@id = 'status-val']")
    private SelenideElement taskStatusCheck;

    @Step("Нажать поиск задач")
    public FourthPage clickToFindTask() {
        findTask.click();
        findTask.setValue("Мунасипов").pressEnter();
        return page(FourthPage.class);
    }

    @Step("Проверка статуса")
    public FourthPage clickToCheckStatus() {
        statusCheck.click();
        statusCheck.shouldHave(text("В работе"));
        return page(FourthPage.class);
    }

    @Step("Выставить Готово")
    public FourthPage clickToSetReady(){
        setReady.click();
        $x("//span[text() = 'Выполнено']").click();
        return page(FourthPage.class);
    }

    @Step("Проверить статус")
    public FourthPage clickToCheckFinalStatus(){
        taskStatusCheck.shouldHave(text("Готово"));
        return page(FourthPage.class);
    }

    @Step("Нажать комментарии")
    public FourthPage clickCommentaryBtn() {
        commentaryBtn.click();
        Selenide.switchTo().defaultContent();
        SelenideElement iframe = $x("//body['#aui-layout aui-theme-default ka ajax-issue-search-and-view page-type-navigator page-type-split']/ancestor::html[@class = 'webkit chrome']//div[@class = 'jira-wikifield']//iframe");
        Selenide.switchTo().frame(iframe);
        $x("//body[@id = 'tinymce']/p").sendKeys("1231231231");
        Selenide.switchTo().defaultContent();
        $x("//input[@value = 'Добавить']").click();
        $x("//div[@class = 'action-body flooded']").shouldBe(visible);
        return page(FourthPage.class);
    }
}
