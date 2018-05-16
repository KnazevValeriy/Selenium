import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static constants.Constants.*;

public class LogTest {

    private WebDriver driver;
    private GitHubPage gitHub;
    private LogPage logPage;
    private MainPage mainPage;

    @BeforeTest
    public void setProperty() {
        System.setProperty(DRIVER, DRIVER_PATH_WINDOWS);
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public void testGitHubLogin() {
        gitHub = new GitHubPage(driver);
        logPage = gitHub.logIn();
        mainPage = logPage.enterLoginAndPasswordAndSubmit();
        mainPage.search(INPUT);
        mainPage.parseCount();
        mainPage.parseTitles();
        mainPage.TagTest();
        mainPage.changeFilterDown();
        mainPage.parseCount();
        mainPage.parseTitles();
        mainPage.search(SECOND_INPUT);
        mainPage.parseCount();
        mainPage.parseTitles();
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}
