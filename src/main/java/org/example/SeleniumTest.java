package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.TestFactory;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        TestFactory testFactory = new TestFactory(driver);

        driver.get("https://practicetestautomation.com/practice-test-login/");
        testFactory.fillUserName("mapa@test.mail.com");
        testFactory.fillPassword("123TestMiau");

        Thread.sleep(5000);
        driver.quit();
    }
}
