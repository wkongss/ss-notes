package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) {
        WebDriver myDriver = new ChromeDriver();

        myDriver.get("https://www.selenium.dev/selenium/web/web-form.html");

        myDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        
        String title = myDriver.getTitle();

        WebElement textBox = myDriver.findElement(By.name("my-text"));
        WebElement submitButton = myDriver.findElement(By.cssSelector("button"));

        textBox.sendKeys("I'm writing via Selenium!");
        submitButton.click();

        myDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement message = myDriver.findElement(By.id("message"));
        System.out.println(message.getText());

        myDriver.quit();
    }
}
