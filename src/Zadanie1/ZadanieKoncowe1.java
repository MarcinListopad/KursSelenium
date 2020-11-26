
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ZadanieKoncowe1 {

    private WebDriver driver;

    @Given("an open browser with google.com")
    public void openGoogleSearch() {
        // Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
        // Sprawdz czy pojawil sie modal cookies
        try {
            // iframe - komunikat znajduje sie w obrebie innej podstrony
            // https://www.guru99.com/handling-iframes-selenium.html
            // niezbyt ten iframe wygony - musimy przelaczyc webdrivera na inny dokument html
            String iframeXpath = "//*[@id=\"cnsw\"]/iframe";
            driver.switchTo().frame(driver.findElement(By.xpath(iframeXpath)));
            boolean isModalDisplayed = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div[2]/div/div/div/div/div[2]/form/div/span/span")).isEnabled();
            if (isModalDisplayed)
                driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div[2]/div/div/div/div/div[2]/form/div/span/span")).click();
        } catch (NoSuchElementException e)
        {
            System.out.println("Brak modalu - przechodze dalej");
        } finally {
            // wracamy do oryginalnej strony
            driver.switchTo().defaultContent();
        }
    }

    @When("a keyword (.*) is entered in input field")
    public void enterKeyword(String keyword) {
        // Znajdź element na podstawie jego nazwy
        WebElement element = driver.findElement(By.name("q"));
        // Wyczyść tekst
        element.clear();
        // Wpisz informacje - wyszukaj
        element.sendKeys(keyword);
        // Wyślij formularz
        element.submit();
    }

    @Then("the first one should contain (.*)")
    public void theFirstOneShouldContainSelenium(String expectedText) {
        System.out.println(expectedText);
    }

    @And("close browser")
   public void closeBrowser() {
        driver.quit();
    }
}

