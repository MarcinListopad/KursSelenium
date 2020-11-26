package Zadanie2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Zadanie2Strona {
    private static WebDriver driver;

    @FindBy(name = "email")
    WebElement Email;

    @FindBy(name = "password")
    WebElement Password;

    @FindBy(id = "submit-login")
    WebElement signInButton;

    @FindBy(id = "search_widget")
    WebElement search;

    @FindBy(css = "article.product-miniature:nth-child(1) > div:nth-child(1) > a:nth-child(1) > img:nth-child(1)")
    WebElement product;

    @FindBy(id = "group_1")
    WebElement productSize;

    @FindBy(id = "quantity_wanted")
    WebElement quantity;

    @FindBy(xpath = "/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button")
    WebElement addToCartButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/a")
    WebElement proceedToCheckoutButton;

    @FindBy(xpath = "/html/body/main/section/div/div/section/div/div[2]/div[1]/div[2]/div/a")
    WebElement confirmProceedToCheckoutButton;

    @FindBy(name = "confirm-addresses")
    WebElement AddressButton;

    @FindBy(name = "confirmDeliveryOption")
    WebElement deliveryConfirm;

    @FindBy(xpath = "//*[@id=\"payment-option-1\"]")
    WebElement payBy;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement agreeTerms;

    @FindBy(xpath = "/html/body/section/div/section/div/div[1]/section[4]/div/div[3]/div[1]/button")
    WebElement orderButton;

    public Zadanie2Strona(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginAs(String email, String password) {
        Email.click();
        Email.clear();
        Email.sendKeys(email);

        Password.click();
        Password.clear();
        Password.sendKeys(password);

        signInButton.click();
    }

    public void searchProduct() {
        if (search.isSelected())
            search.sendKeys("Hummingbird Printed Sweater picture");
        search.click();
    }

    public void chooseProduct() {
        product.click();
    }

    public void chooseProductSize(String size) {
        Select sizeSelect = new Select(productSize);
        sizeSelect.selectByVisibleText(size);
    }

    public void chooseProductQuantity(char quantity) {
        this.quantity.click();
        this.quantity.clear();
        this.quantity.sendKeys("5");
    }
    public void addToCart() {
        addToCartButton.click();
    }

    public void proceedToCheckout() throws InterruptedException {
        Thread.sleep(1000);
        proceedToCheckoutButton.click();
    }
    public void confirmProceedToCheckout() {
        confirmProceedToCheckoutButton.click();
    }

    public void confirmDeliverAddress() {
        AddressButton.click();
    }

    public void chooseDelivery() {
        deliveryConfirm.click();
    }

    public void choosePayOption() {
        payBy.click();
    }

    public void agreeOfTermsAndOrder() {
        if (!agreeTerms.isSelected())
            agreeTerms.click();
        orderButton.click();
    }
}