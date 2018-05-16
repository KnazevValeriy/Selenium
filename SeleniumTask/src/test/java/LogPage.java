import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.Constants.*;

class LogPage {
    private WebDriver driver;

    LogPage(WebDriver driver) {
        this.driver = driver;
    }

    MainPage enterLoginAndPasswordAndSubmit() {
        driver.findElement(By.id(USER_ID)).sendKeys(LOGIN);
        driver.findElement(By.id(PASSWORD_ID)).sendKeys(PASSWORD);
        driver.findElement(By.name(COMMIT)).click();
        return new MainPage(driver);
    }

}
