package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    public void signUpText(){
        WebElement signUpText = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
        signUpText.isDisplayed();

    }

    public void signUpBasicInfo(String name, String email){
        WebElement name_locator = driver.findElement(By.name("name"));
        WebElement email_locator = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        name_locator.sendKeys(name);
        email_locator.sendKeys(email);
    }

    public void verifySignUpPageIsPresent(){
        WebElement signMessage = driver.findElement(By.cssSelector("h2.title.text-center"));
        signMessage.isDisplayed();

    }

    public void selectGender(int gender){
        WebElement male = driver.findElement(By.id("id_gender1"));
        WebElement female = driver.findElement(By.id("id_gender2"));
        //0 - for male, 1 - for female
        if (gender ==0){
            male.click();
        }
        else if (gender ==1) {
            female.click();
        }
    }

    public void completeInfoSignUp(int gender, String name, String password, int day_of_birth, int month_of_birth, String year_of_birth){
        selectGender(gender);
        WebElement name_locator = driver.findElement(By.id("name"));
        name_locator.sendKeys(name);
        WebElement password_locator = driver.findElement(By.id("password"));
        password_locator.sendKeys(password);
        WebElement day = driver.findElement(By.id("days"));
        WebElement month = driver.findElement(By.id("months"));
        WebElement year = driver.findElement(By.id("years"));
        Select days = new Select(day);
        Select months = new Select(month);
        Select years = new Select(year);
        days.selectByIndex(day_of_birth);
        months.selectByIndex(month_of_birth);
        years.selectByVisibleText(year_of_birth);

        }

    public void selectCheckBoxes(){
        WebElement c1 = driver.findElement(By.id("newsletter"));
        WebElement c2 = driver.findElement(By.id("optin"));
        c1.click();
        c2.click();
    }

    public void completeFirstName(String firstname){
        WebElement firstName_locator = driver.findElement(By.id("first_name"));
        firstName_locator.sendKeys(firstname);
    }

    public void completeLastName(String lastname){
        WebElement lastName_locator  =driver.findElement(By.id("last_name"));
        lastName_locator.sendKeys(lastname);
    }

    public void completeCompany(String company){
        WebElement company_locator =  driver.findElement(By.id("company"));
        company_locator.sendKeys(company);
    }

    public void completeZipCode(String zipcode){
        WebElement zipcode_locator= driver.findElement(By.id("zipcode"));
        zipcode_locator.sendKeys(zipcode);
    }

    public void phoneNumber(String phoneNumber){
        WebElement phoneNumber_locator = driver.findElement(By.id("mobile_number"));
        phoneNumber_locator.sendKeys(phoneNumber);
    }

    public void completeCityandState(String city, String state){
        WebElement city_locator = driver.findElement(By.id("city")) ;
        WebElement state_locator=  driver.findElement(By.id("state"));
        city_locator.sendKeys(city);
        state_locator.sendKeys(state);
    }

    public void completeAdress(String adress){
        WebElement adress_locator = driver.findElement(By.id("address1"));
        adress_locator.sendKeys(adress);
    }

    public void selectCountry(String countryName){
        WebElement country_locator = driver.findElement(By.id("country"));
        Select country_selector = new Select(country_locator);
        country_selector.selectByVisibleText(countryName);

    }

    public void clickCreateAccount(){
        WebElement createAccoount = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button"));
        createAccoount.click();
    }

    public void verifyAccountCreated(){
        WebElement label = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2"));
        label.isDisplayed();
    }

    public void clickContinuebutton(){
        WebElement contiue = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        contiue.click();
    }

    public void verifyLoggedUser (){
        WebElement loggedUser = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        String mesaj = loggedUser.getText();
        System.out.println(mesaj);
        loggedUser.isDisplayed();
    }

    public void deleteAccount(){
        WebElement deleteAcc = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
        deleteAcc.click();
    }

    public void deleteConfirmation(){
        WebElement deleteMessage = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        System.out.println(deleteMessage.getText());
        deleteMessage.isDisplayed();
        WebElement continueDelete = driver.findElement(By.cssSelector("a.btn.btn-primary"));
        continueDelete.click();

    }


}
