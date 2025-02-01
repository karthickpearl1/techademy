package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Problem3 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://makemytrip.com");

        if(!driver.findElements(new By.ByCssSelector("img[alt='Make My Trip']")).isEmpty()){
            System.out.println("Verified Logo availability: Available");
        }else{
            System.out.println("Verified Logo availability: Not Available");
        }

        driver.quit();
    }
}