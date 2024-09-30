package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CermatiSignUpSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("I launch google chrome browser")
    public void i_launch_google_chrome_browser() {
        System.setProperty("webdriver.chrome.driver","/opt/homebrew/bin/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @When("I open cermati sign up page")
    public void i_open_cermati_sign_up_page() {
        driver.get("https://www.cermati.com/app/gabung");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Daftar']")));
    }

    @When("I fill the phone number")
    public void i_fill_the_phone_number() {
        WebElement textbox = driver.findElement(By.xpath("//input[@id='mobilePhone']"));
        textbox.clear();
        textbox.sendKeys("081288047816");
    }

    @And("I fill the email")
    public void i_fill_the_email() {
        WebElement textbox = driver.findElement(By.xpath("//input[@id='email']"));
        textbox.clear();
        textbox.sendKeys("testing123@gmail.com");
    }

    @And("I fill first name")
    public void i_fill_first_name() {
        WebElement textbox = driver.findElement(By.xpath("//input[@id='firstName']"));
        textbox.clear();
        textbox.sendKeys("cobafirst");
    }

    @And("I fill last name")
    public void i_fill_last_name() {
        WebElement textbox = driver.findElement(By.xpath("//input[@id='lastName']"));
        textbox.clear();
        textbox.sendKeys("cobalast");
    }

    @And("I click sign up button")
    public void i_click_sign_up_button() {
        WebElement btnSignUp = driver.findElement(By.xpath("//button[@data-button-name='register-new']"));
        btnSignUp.click();
    }

    @Then("I should get redirected to phone number verification")
    public void i_should_get_redirected_to_phone_number_verification() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Verifikasi No. Handphone']")));
        boolean status = driver.findElement(By.xpath("//h1[normalize-space()='Verifikasi No. Handphone']")).isDisplayed();
        Assert.assertTrue(status);
        driver.quit();
    }
}