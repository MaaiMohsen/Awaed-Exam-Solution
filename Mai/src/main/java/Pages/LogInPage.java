package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
    private WebDriver driver;
    private By emailField = By.id("ctl00_CPHContainer_txtUserLogin");
    private By passwordField = By.id("ctl00_CPHContainer_txtPassword");
    private By logInButton = By.id("ctl00_CPHContainer_btnLoginn");
    private By errorMessageField = By.id("ctl00_CPHContainer_lblOutput");

    public LogInPage (WebDriver driver){
        this.driver = driver;
    }

    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLogIn (){
        driver.findElement(logInButton).click();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessageField).getText();
    }

}
