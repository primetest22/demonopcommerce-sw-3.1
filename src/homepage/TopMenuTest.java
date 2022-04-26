package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.Scanner;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";
    String Computers,Electronics,Apparel,Digitaldownloads,Books,Jewelry,GiftCards;
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    public void  selectMenu(String menu) throws InterruptedException {
        Thread.sleep(1500);
        switch (menu) {
            case "Computers" :
                clickOnElement(By.partialLinkText("Compute"));
                verifyElements("Not Matching","Computers",By.partialLinkText("Compute"));
                break;
            case "Electronics":
                clickOnElement(By.partialLinkText("Electroni"));
                verifyElements("Not Matching","Electronics",By.partialLinkText("Electroni"));
                break;
            case "Apparel":
                clickOnElement(By.partialLinkText("Appar"));
                verifyElements("Not Matching","Apparel",By.partialLinkText("Appar"));
                break;
            case "Digitaldownloads":
                clickOnElement(By.partialLinkText("Digital downloa"));
                verifyElements("Not Matching","Digital downloads",By.partialLinkText("Digital downloa"));
                break;
            case "Books":
                clickOnElement(By.partialLinkText("Books"));
                verifyElements("Not Matching","Books",By.partialLinkText("Books"));
                break;
            case "Jewelry":
                clickOnElement(By.partialLinkText("Jewel"));
                verifyElements("Not Matching","Jewelry",By.partialLinkText("Jewel"));
                break;
            case "GiftCards":
                clickOnElement(By.partialLinkText("Gift Car"));
                verifyElements("Not Matching","Gift Cards",By.partialLinkText("Gift Car"));
                break;
        }
    }
    @Test
    public void verifyPageNavigation() throws InterruptedException {

        selectMenu("GiftCards");

    }

    @After
    public void tearUp(){
        closeBrowser();
    }









}
