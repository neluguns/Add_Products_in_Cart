package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpLogin {
    private WebDriver driver;

    public SignUpLogin(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignUpSignIn(){
        WebElement buttonSignInLogin = driver.findElement(By.cssSelector("i.fa.fa-lock"));
        buttonSignInLogin.click();
    }
    public void verifySignUpFormIsVisible(){
        WebElement signExists = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
        signExists.isDisplayed();
    }

    public void registerWithEmailAlreadyExistsInDB(String name,String email){
        WebElement name_locator = driver.findElement(By.name("name"));
        WebElement email_locator = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        name_locator.sendKeys(name);
        email_locator.sendKeys(email);
    }

    public void clickSignUp(){
        WebElement signUpButton = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        signUpButton.click();
    }
    public void verifyErrorMessageWithEmailAlreadyRegistered(){
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p"));
        String errorText = errorMessage.getText();
        assert errorText.equals("Email Address already exist!");
    }

}
