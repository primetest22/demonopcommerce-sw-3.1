package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    /*** this method will find the element in browser     */

    public WebElement findElementsOnBrowser(By by) {
        WebElement element = driver.findElement(by);
        return element;
    }

    /********* clicking methods **********************/
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();

    }
    public void clickAndClearElement(By by){
        WebElement element = driver.findElement(by);
        element.clear();
    }

    public void keyboard(By by){
        Actions actions = new Actions(driver);

        WebElement element =driver.findElement(by);
        element.clear();


    }

    /**********  get text method from element *********/
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();

    }

    /************* send text method **************************/
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);

    }

    /************* mouse actions methods ********************/
    public void mouseHover(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(by);
        Thread.sleep(1500);
        actions.moveToElement(hover).build().perform();

    }

    public void mouseHoverAndClick(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mouseClick = driver.findElement(by);
        Thread.sleep(1500);
        actions.moveToElement(mouseClick).click().build().perform();

    }
    //******************************* Assert verify Methods *************************************************//

    public void verifyElements(String displayMessage, String expectedMessage, By by) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);

    }

    /************** alerts methods *********************/
    //this method will switch to alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {

        driver.switchTo().alert().dismiss();
    }

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    /************* select class *****************/

    public void selectByVisibleTextFromDropDown(By by, String text){

        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }
}
