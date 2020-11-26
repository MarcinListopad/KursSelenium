import io.cucumber.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class Zadanie2Kroki {
    WebDriver driver;

    @Given("^open website https://prod-kurs\\.coderslab\\.pl/index\\.php\\?controller=authentication&back=addresses$")
    public void openWebsiteHttpsProdKursCoderslabPlIndexPhpControllerAuthenticationBackAddresses() {
        System.setProperty("webdriver.chromedriver.driver",
                "src/main/resources/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
    }

    @When("^log in to user account (.*) i (.*)$")
    public void logInToUserAccountEmailIPassword(String Email, String Password) {
        Zadanie2.Zadanie2Strona page = new Zadanie2.Zadanie2Strona(driver);
        page.loginAs(Email, Password);
    }

    @Then("^in search box put Hummingbird Printed Sweater and click search$")
    public void inSearchBoxPutHummingbirdPrintedSweaterAndClickSearch() {

        Zadanie2.Zadanie2Strona page = new Zadanie2.Zadanie2Strona(driver);
        page.searchProduct();
    }

    @And("^click on Hummingbird Printed Sweater picture$")
    public void clickOnHummingbirdPrintedSweaterPicture() {
        Zadanie2.Zadanie2Strona page = new Zadanie2.Zadanie2Strona(driver);
        page.chooseProduct();
    }

    @And("^chose (.*)$")
    public void choseSize(String size) {
        Zadanie2.Zadanie2Strona page = new Zadanie2.Zadanie2Strona(driver);
        page.chooseProductSize(size);
    }

    @And("^write (.*)$")
    public void writeQuantity(char quantity) {
        Zadanie2.Zadanie2Strona page = new Zadanie2.Zadanie2Strona(driver);
        page.chooseProductQuantity(quantity);
    }

    @And("^add to cart$")
    public void addToCart() {
        Zadanie2.Zadanie2Strona page = new Zadanie2.Zadanie2Strona(driver);
        page.addToCart();
    }

    @And("^proceed to checkout$")
    public void proceedToCheckout() throws InterruptedException {
        Zadanie2.Zadanie2Strona page = new Zadanie2.Zadanie2Strona(driver);
        page.proceedToCheckout();
    }

    @And("^confirm proceed to checkout$")
    public void confirmProceedToCheckout() {
        Zadanie2.Zadanie2Strona page = new Zadanie2.Zadanie2Strona(driver);
        page.confirmProceedToCheckout();
    }

    @And("^confirm address$")
    public void confirmAddress() {
        Zadanie2.Zadanie2Strona page = new Zadanie2.Zadanie2Strona(driver);
        page.confirmDeliverAddress();
    }

    @And("^choose shipping method PrestaShop pick up in store,$")
    public void chooseShippingMethodPrestaShopPickUpInStore() {
        Zadanie2.Zadanie2Strona page = new Zadanie2.Zadanie2Strona(driver);
        page.chooseDelivery();
    }

    @And("^pay by check$")
    public void payByCheck() {
        Zadanie2.Zadanie2Strona page = new Zadanie2.Zadanie2Strona(driver);
        page.choosePayOption();
    }

    @And("^order with an obligation to pay$")
    public void orderWithAnObligationToPay() {
        Zadanie2.Zadanie2Strona page = new Zadanie2.Zadanie2Strona(driver);
        page.agreeOfTermsAndOrder();
    }

    @And("^close browser$")
    public void closeBrowser() {
        driver.quit();
    }

}