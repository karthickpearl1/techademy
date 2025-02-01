package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Problem4 {
    static WebDriver driver;
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://makemytrip.com");

        WebElement acceptCookieButton = driver.findElement(By.xpath("//button[contains(@class,'cookiesModal__acceptCookiesBtn')]"));

        WebElement flightMenuLink = driver.findElement(By.xpath("//*[@data-cy='menu_Flights']"));
        WebElement flightTravelTypeOneWay = driver.findElement(By.xpath("//*[@data-cy='oneWayTrip']"));
        WebElement flightFrom = driver.findElement(By.xpath("//*[@data-cy='fromCity']"));
        WebElement flightTo = driver.findElement(By.xpath("//*[@data-cy='toCity']"));


        click(acceptCookieButton);
        click(flightMenuLink);

        try{
            WebElement loginModalCloseButton = driver.findElement(By.xpath("//*[@data-cy='closeModal']"));
            click(loginModalCloseButton);
        }catch(NoSuchElementException e){
            System.out.println("Login Modal not shown");
        }

        driver.quit();
    }

    public static void click(WebElement element){
        (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();

    }

    public static void enterText(WebElement element,String text){
        (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions.elementToBeClickable(element))
                .sendKeys(text);
    }
}