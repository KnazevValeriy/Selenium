import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.Constants.LOGIN_XPATH;

class GitHubPage {
    private WebDriver driver;

    GitHubPage(WebDriver driver) {
        this.driver = driver;
    }

    LogPage logIn() {
        driver.findElement(By.xpath(LOGIN_XPATH)).click();
        return new LogPage(driver);
    }
}
