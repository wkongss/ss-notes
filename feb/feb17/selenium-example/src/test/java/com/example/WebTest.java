package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTest {
    WebDriver testDriver;

    @BeforeEach
    public void setup() {
        testDriver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
        testDriver.quit();
    }

    @Test
    public void submit() {
        testDriver.get("https://www.selenium.dev/selenium/web/web-form.html");

        testDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement submitButton = testDriver.findElement(By.cssSelector("button"));

        submitButton.click();

        testDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement message = testDriver.findElement(By.id("message"));

        assertEquals(message.getText(), "Received!");
    }
}
