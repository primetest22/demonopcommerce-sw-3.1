package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ComputerTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsArrangedDescendingOrder() throws InterruptedException {
        //mouse hover and click on element
        mouseHover(By.partialLinkText("Compute"));
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//ul/li/a[contains(text(),'Desktop')]"));
        //click on sort by dropdown menu
        clickOnElement(By.id("products-orderby"));
        //click on Name: Z to A option
        clickOnElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        //validate message
        verifyElements("Products not sorted by Z to A order",
                "Name: Z to A", By.xpath("//option[contains(text(),'Name: Z to A')]"));

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //mouse hover and click on element
        mouseHover(By.partialLinkText("Compute"));
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//ul/li/a[contains(text(),'Desktop')]"));
        //click on sort by dropdown menu
        clickOnElement(By.id("products-orderby"));
        //click on Name: Z to A option
        clickOnElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));
        Thread.sleep(1500);
        clickOnElement(By.xpath("//div[@data-productid='1']/div[2]/div[3]/div[2]"));
        //validate test build your own computer
        verifyElements("Text not matching",
                "Build your own computer", By.xpath("//h1[contains(text(),'Build your own computer')]"));
        //use select class
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
        selectByVisibleTextFromDropDown(By.cssSelector("#product_attribute_2"), "8GB [+$60.00]");
        //click on HDD radio button
        clickOnElement(By.cssSelector("#product_attribute_3_7"));

        clickOnElement(By.cssSelector("#product_attribute_4_9"));
        Thread.sleep(2000);
        clickOnElement(By.cssSelector("#product_attribute_5_12"));
        Thread.sleep(3000);
        verifyElements("Verify Total", "$1,475.00", By.cssSelector("#price-value-1"));

        clickOnElement(By.cssSelector("#add-to-cart-button-1"));
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
        //update shopping cart
        clickOnElement(By.xpath("//table//tbody//td[5]/input"));
        Thread.sleep(3000);
        keyboard(By.xpath("//table//tbody//td[5]/input"));

        sendTextToElement(By.xpath("//table//tbody//td[5]/input"), "2");

        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //validate updated total is $2,950
        verifyElements("Total not matching", "Total: $2,950.00", By.xpath("//tr[@class='order-total']"));
        Thread.sleep(3000);

        mouseHoverAndClick(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@id='checkout']"));

        verifyElements("Text not matching", "Welcome, Please Sign In!",
                By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //fill all mandatory fields
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "prime");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "testing");
        sendTextToElement(By.id("BillingNewAddress_Email"), "primetesting@yahoo.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "India");
        sendTextToElement(By.id("BillingNewAddress_City"), "Amdavad");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "prime testing");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "000000");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "00000000000");

        //click on continue button
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']//button[contains(text(),'Continue')]"));

        clickOnElement(By.cssSelector("#shippingoption_1"));
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']//button"));
        clickOnElement(By.cssSelector("#paymentmethod_1"));
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']//button"));
        
        //credit card details
        clickOnElement(By.id("CreditCardType"));
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Master card");
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
        verifyElements("Shipping method not matching", "Shipping Method: Next Day Air",
                By.xpath("//li[@class='shipping-method']"));
        //validate total
        verifyElements("Total not matching", "Total: $2,950.00",
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

    }
    @After
    public void tearUp() {
         closeBrowser();
    }

}
