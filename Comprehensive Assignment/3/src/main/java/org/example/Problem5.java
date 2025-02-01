package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Problem5 {
    WebDriver driver;

    @BeforeTest
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://makemytrip.com");
    }

    @AfterTest
    public void destory() {
        driver.quit();
    }

    @Test
    public void verifyLogo() {
        if (!driver.findElements(new By.ByCssSelector("img[alt='Make My Trip']")).isEmpty()) {
            System.out.println("Verified Logo availability: Available");
        } else {
            System.out.println("Verified Logo availability: Not Available");
        }
    }

    @Test
    public void verifyElements() {
        WebElement acceptCookieButton = driver.findElement(By.xpath("//button[contains(@class,'cookiesModal__acceptCookiesBtn')]"));

        WebElement flightMenuLink = driver.findElement(By.xpath("//*[@data-cy='menu_Flights']"));
        WebElement flightTravelTypeOneWay = driver.findElement(By.xpath("//*[@data-cy='oneWayTrip']"));
        WebElement flightFrom = driver.findElement(By.xpath("//*[@data-cy='fromCity']"));
        WebElement flightTo = driver.findElement(By.xpath("//*[@data-cy='toCity']"));


        click(acceptCookieButton);
        click(flightMenuLink);

        try {
            WebElement loginModalCloseButton = driver.findElement(By.xpath("//*[@data-cy='closeModal']"));
            click(loginModalCloseButton);
        } catch (NoSuchElementException e) {
            System.out.println("Login Modal not shown");
        }


    }

    public void click(WebElement element) {
        (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();

    }

    public void enterText(WebElement element, String text) {
        (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions.elementToBeClickable(element))
                .sendKeys(text);
    }
}