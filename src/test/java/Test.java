import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;
import pages.Products;
import pages.SignUpLogin;

public class Test extends BaseTest {

    @org.testng.annotations.Test
    public void checkTitlePage() {
        HomePage homePage = new HomePage(driver);
        System.out.println(homePage.verifyHomePage());
        Assert.assertEquals(homePage.verifyHomePage(), "Automation Exercise");
    }
        @org.testng.annotations.Test
    public void goToProducts() throws InterruptedException {
            Products products = new Products(driver);
            products.clickProductButton();
            Thread.sleep(2000);
            System.out.println(products.getProductPageTitle());
            Assert.assertEquals(products.getProductPageTitle(),"Automation Exercise - All Products");
            products.clickProduct(0);
            Thread.sleep(2000);
            products.clickProductByIndex(1);
            Thread.sleep(3000);
            products.clickContinueShoppingButton();
            products.clickProduct(1);
            Thread.sleep(1000);
            products.clickProductByIndex(3);
            Thread.sleep(3000);
            products.clickViewAll();
            Thread.sleep(5000);
            System.out.println("numarul de produse in cos");
            System.out.println(products.numberOfProductinCart());
            Assert.assertEquals(products.numberOfProductinCart(),2);
            Thread.sleep(2000);
            System.out.println(products.getprice());
            System.out.println(products.formatPrices());
            products.pretTotalInCos();

    }

    @org.testng.annotations.Test
    public void verifyScrollUpusingArrowbuttonandScrollDownfunctionality() throws InterruptedException {
        HomePage homePage  = new HomePage(driver);
        System.out.println(homePage.verifyHomePage());
        Assert.assertEquals(homePage.verifyHomePage(), "Automation Exercise");
        homePage.scrollDownToTheBottom();
        homePage.goUp();
        homePage.verifyTextUpperPage();
        Thread.sleep(2000);}

    @org.testng.annotations.Test
    public void verifyScrollUpusingArrowbuttonandScrollDownfunctionality1() throws InterruptedException {
        HomePage homePage  = new HomePage(driver);
        System.out.println(homePage.verifyHomePage());
        Assert.assertEquals(homePage.verifyHomePage(), "Automation Exercise");
        homePage.scrollDownToTheBottom();
        homePage.goUpWithoutClickArrowButton();
        homePage.verifyTextUpperPage();
        Thread.sleep(2000);}

    @org.testng.annotations.Test
    public void verifySignupErrorWithAnExistingEmail() throws InterruptedException {
        HomePage homePage  = new HomePage(driver);
        System.out.println(homePage.verifyHomePage());
        SignUpLogin signUpLogin = new SignUpLogin(driver);
        signUpLogin.clickSignUpSignIn();
        signUpLogin.verifySignUpFormIsVisible();
        signUpLogin.registerWithEmailAlreadyExistsInDB("Claudiu", "ann0x98@gmail.com");
        signUpLogin.clickSignUp();
        signUpLogin.verifyErrorMessageWithEmailAlreadyRegistered();
        Thread.sleep(3000);
    }
    @org.testng.annotations.Test
    public void verifySearchProduct() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        System.out.println(homePage.verifyHomePage());
        Products products = new Products(driver);
        products.clickProductButton();
        Thread.sleep(2000);
        products.verifyPageProducts();
        products.searchProduct("shirt");
        products.getAttributesProduct();
        products.verifyManyProductsAreDisplayed();
        Thread.sleep(3000);
    }

    @org.testng.annotations.Test
    public void verifyReviewIsSent() throws InterruptedException {
        Products products = new Products(driver);
        products.clickProductButton();
        products.verifyPageProducts();
        products.clickViewProduct();
        Thread.sleep(2000);
        products.verifyYourReviewIsVisible();
        products.reviewContent("Ioan Arcalean","xxx@yahoo.com","Cool stuff");
        Thread.sleep(2000);
        products.clickSubmit();
        Thread.sleep(2000);
        products.alert_succes_is_displayed();
        Thread.sleep(3000);

    }

}


