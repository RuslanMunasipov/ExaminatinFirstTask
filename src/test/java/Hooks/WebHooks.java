package Hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class WebHooks {
    @BeforeAll
    public static void setDriverProps() {
//        String webDriverLocation = Utils.Configuration.getConfigurationValue("webdriverLocalPath");
//        if (webDriverLocation != null) {
//            System.setProperty("webdriver.chrome.driver", webDriverLocation);
//            System.setProperty("selenide.browser", "Chrome");
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
    }

    @AfterEach
    public void driverClose() {
        WebDriverRunner.closeWebDriver();
    }
}

