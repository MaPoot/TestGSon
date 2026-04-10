package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestFactory {
    @FindBy(id = "username")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    public TestFactory(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillUserName(String userName) {
        userNameField.sendKeys(userName);
    }

    public void fillPassword(String password) {
        passwordField.sendKeys(password);
    }
}
