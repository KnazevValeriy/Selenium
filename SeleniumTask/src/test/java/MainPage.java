import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static constants.Constants.*;


class MainPage {
    private WebDriver driver;

    MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    void TagTest() {
        List<WebElement> list = driver.findElements(By.xpath(TAG));
        for (WebElement e : list) {
            Assert.assertEquals(TAG_VALUE, e.getText());
        }
    }

    void parseTitles() {
        List<WebElement> list = driver.findElements(By.cssSelector(TITLE));
        System.out.println(LINE);
        for (WebElement aList : list) {
            System.out.println(aList.getText());
        }
        System.out.println(LINE);
    }

    void parseCount() {
        System.out.println(LINE);
        System.out.println(driver.findElement(By.cssSelector(COUNT)).getText());
        System.out.println(LINE);
    }

    void changeFilterDown() {
        driver.findElement(By.cssSelector(BUTTON)).click();
        driver.findElement(By.cssSelector(FILTER_VALUE)).click();
    }

    void search(String request) {
        WebElement search = driver.findElement(By.name(SEARCH));
        search.clear();
        search.sendKeys(request);
        search.submit();
    }
}




