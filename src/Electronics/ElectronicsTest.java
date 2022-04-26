package Electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void textVerified() throws InterruptedException {
        //mouse hover and click on element
        mouseHover(By.partialLinkText("Electroni"));
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//ul/li/a[contains(text(),'Cell phones')]"));
        //validate text Cell phones
        verifyElements("Text not matching", "Cell phones", By.xpath("//h1[contains(text(),'Cell phones')]"));

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //mouse hover and click on element
        mouseHover(By.partialLinkText("Electroni"));
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//ul/li/a[contains(text(),'Cell phones')]"));
        //validate text Cell phones
        verifyElements("Text not matching", "Cell phones", By.xpath("//h1[contains(text(),'Cell phones')]"));
        //click on list icon
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(1500);
        //click on nokia lumia link
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));
        clickOnElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        clickOnElement(By.cssSelector("#price-value-20"));
        //update shopping cart
        clickOnElement(By.cssSelector("#product_enteredQuantity_20"));
        Thread.sleep(3000);
        keyboard(By.cssSelector("#product_enteredQuantity_20"));

        sendTextToElement(By.cssSelector("#product_enteredQuantity_20"), "2");

        clickOnElement(By.cssSelector("#add-to-cart-button-20"));
        //validate top bar notification text
        verifyElements("Top bar text not matching",
                "The product has been added to your shopping cart",
                By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        //close top bar notification
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        Thread.sleep(3000);
        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"));

        mouseHoverAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));
        //validate shopping cart text
        verifyElements("Text not matching", "Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Thread.sleep(3000);
        //verify quantity is 2
        verifyElements("Quantity not matching", "(2)", By.xpath("//li[@id='topcartlink']//span[2]"));
        //verify subtotal matching
        verifyElements("SubTotal not matching", "$698.00", By.xpath("//span[@class='product-subtotal']"));
        //click on terms of service check box
        mouseHoverAndClick(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@id='checkout']"));

        verifyElements("Text not matching", "Welcome, Please Sign In!",
                By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //fill mandatory fields for registration
        sendTextToElement(By.id("FirstName"), "prime");
        sendTextToElement(By.id("LastName"), "testing");
        sendTextToElement(By.id("Email"), "primetesting0123456@yahoo.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "password");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "password");
        clickOnElement(By.id("register-button"));
        //validate registration
        verifyElements("not matching", "Your registration completed", By.xpath("//div[contains(text(),'Your registration completed')]"));
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //validate shopping cart text
        verifyElements("Text not matching", "Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Thread.sleep(3000);

        mouseHoverAndClick(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@id='checkout']"));

        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "India");
        sendTextToElement(By.id("BillingNewAddress_City"), "Amdavad");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "prime testing");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "000000");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "00000000000");
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[4]"));
        clickOnElement(By.cssSelector("#shippingoption_2"));
        Thread.sleep(1500);
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[4]"));
        //select credit card option
        clickOnElement(By.cssSelector("#paymentmethod_1"));
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']//button"));

        //credit card details
        clickOnElement(By.id("CreditCardType"));
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Visa");
        sendTextToElement(By.id("CardholderName"), "primetesting");
        sendTextToElement(By.id("CardNumber"), "0000000000000000");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "12");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2022");
        sendTextToElement(By.id("CardCode"), "000");
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']//button"));
        //verify payment method
        verifyElements("Payment method not matching", "Payment Method: Credit Card",
                By.xpath("//li[@class='payment-method']"));
        //verify shipping method
        verifyElements("Shipping method not matching", "Shipping Method: 2nd Day Air",
                By.xpath("//li[@class='shipping-method']"));
        //validate total
        verifyElements("Total not matching", "Total: $698.00",
                By.xpath("//tr[@class='order-total']"));
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //validate thank you text
        verifyElements("Text not matching", "Thank you", By.xpath("//h1[contains(text(),'Thank you')]"));
        //validate order successfully processed text
        verifyElements("Text not matching", "Your order has been successfully processed!",
                By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //validate welcome to our store text
        verifyElements("Text not matching", "Welcome to our store",
                By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        //click on logout
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        String currentUrl = driver.getCurrentUrl();
        //validate current url
        Assert.assertEquals(currentUrl, "https://demo.nopcommerce.com/");

    }

    @After
    public void tearUp() {
        closeBrowser();
    }


}
