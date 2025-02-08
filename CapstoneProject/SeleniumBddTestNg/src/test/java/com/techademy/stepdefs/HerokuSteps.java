package com.techademy.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class HerokuSteps {
    private static WebDriver driver;
    @Before
    @BeforeClass
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    @After
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    @Given("User has landed on the screen")
    public void userHasLandedOnTheScreen() {
        driver.get("http://the-internet.herokuapp.com");
    }

    @When("Clicked on AB Testing Link")
    public void clickedOnABTestingLink() {
driver.findElement(By.xpath("//*[contains(text(),'A/B Testing')]")).click();

    }

    @Then("text is verified ok")
    public void textIsVerifiedOk() {
        var headerText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(headerText,"A/B Test Control");
    }

    @When("Back to Home page")
    public void backToHomePage() {
        driver.navigate().back();
    }

    @And("Clicked on Frames")
    public void clickedOnFrames() {
        driver.findElement(By.xpath("//a[contains(@href,\"frames\")]")).click();
    }

    @Then("Verify hyperlinks are present")
    public void verifyHyperlinksArePresent() {
        WebElement link1= driver.findElement(By.linkText("Nested Frames"));
        WebElement link2= driver.findElement(By.linkText("iFrame"));

        if(!link1.isDisplayed() || !link2.isDisplayed())
        {
            Assert.fail();
        }
    }

    @And("Clicked on Dropdown Link")
    public void clickedOnDropdownLink() {
        driver.findElement(By.xpath("//a[contains(@href,\"dropdown\")]")).click();
    }

    @And("Select Option{int}")
    public void selectOption(int arg0) {
        Select dropdownElement = new Select(driver.findElement(By.id("dropdown")));
        dropdownElement.selectByValue(String.valueOf(arg0));
        var selectedText = dropdownElement.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedText,"Option 1");
    }

}
