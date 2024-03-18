package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Products {
    private WebDriver driver;
    public Products(WebDriver driver){
        this.driver = driver;
    }
    public void clickProductButton(){
            WebElement productsButton = driver.findElement(By.cssSelector("i.material-icons.card_travel"));
            productsButton.click();
    }
    public String getProductPageTitle(){
        return driver.getTitle();
    }
    public List<WebElement> getAllProducts(){
        List<WebElement> products = driver.findElements(By.className("single-products"));
        return products;
    }
    public void clickProduct(int productNumber) {
        List<WebElement> products = getAllProducts();
        System.out.println("Numarul de produse");
        System.out.println(products.size());
        products.get(productNumber).click();
    }
    public List getAllAddtoCartButtons(){
            List<WebElement> addToCartButtons = driver.findElements(By.cssSelector("a.btn.btn-default.add-to-cart"));
            return addToCartButtons;
    }
    public void clickProductByIndex(int ProductByIndex){
            List <WebElement> addtoCartButtons = getAllAddtoCartButtons();
//first button element index 0 and 1, then second button 2, 3 etc..
            addtoCartButtons.get(ProductByIndex).click();
    }
    public void clickContinueShoppingButton(){
        WebElement continueShoppingButton = driver.findElement(By.cssSelector("button.btn.btn-success.close-modal.btn-block"));
        continueShoppingButton.click();
    }
    public void clickViewAll(){
        WebElement viewAllRedirect = driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u"));
        viewAllRedirect.click();
    }
    public int numberOfProductinCart(){
        List <WebElement> productinCart = driver.findElements(By.className("cart_product"));
        return productinCart.size();
    }
    public List<String> getprice(){
        List<WebElement> prices = driver.findElements(By.cssSelector("td.cart_price"));
        List<String> priceValues = new ArrayList<>();
        for (WebElement price : prices)
        {
            priceValues.add(price.getText());
        }
        return priceValues;
    }
    public List<Integer> formatPrices(){
            List<Integer> listaNumere = new ArrayList<>();
            Pattern pattern =  Pattern.compile("\\d+");
            for (String str : getprice()){
                Matcher matcher = pattern.matcher(str);
                while (matcher.find()){
                    listaNumere.add(Integer.parseInt(matcher.group()));
                }
            }
            return  listaNumere;
        }
    public void pretTotalInCos(){
        List<Integer> preturiProduse = formatPrices();
        Integer sum_total = preturiProduse.get(0) + preturiProduse.get(1);
        System.out.println(sum_total);
    }

    public void verifyPageProducts(){
        WebElement pageProducts = driver.findElement(By.cssSelector("h2.title"));
        String titlePage = pageProducts.getText();
        System.out.println(titlePage);
        assert titlePage.equals("ALL PRODUCTS");
    }

    public void searchProduct(String productName){
        WebElement searchInput = driver.findElement(By.id("search_product"));
        searchInput.sendKeys(productName);
        WebElement searchButton = driver.findElement(By.id("submit_search"));
        searchButton.click();
    }

    public void getAttributesProduct(){
        WebElement product = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/p"));
        product.isDisplayed();
        String product_title = product.getText();
        System.out.println(product_title);
    }

    public void verifyManyProductsAreDisplayed(){
        List <WebElement> products_searched = driver.findElements(By.className("single-products"));
        if (products_searched.size()>1){
            System.out.println("Avem mai multe produse cautate");
        }
        else assert false;
    }

    public void clickViewProduct(){
        WebElement viewProduct = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a"));
        viewProduct.click();
        }

    public void verifyYourReviewIsVisible(){
        WebElement yourReviewIsVisible = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[3]/div[1]/ul/li/a"));
                yourReviewIsVisible.click();
    }

    public void reviewContent(String name, String email, String review){
        WebElement name_locator = driver.findElement(By.id("name"));
        WebElement email_locator = driver.findElement(By.id("email"));
        WebElement review_locator = driver.findElement(By.id("review"));
        name_locator.sendKeys(name);
        email_locator.sendKeys(email);
        review_locator.sendKeys((review));
    }

    public void clickSubmit(){
        WebElement clickSubmit = driver.findElement(By.id("button-review"));
        clickSubmit.click();
    }

    public void alert_succes_is_displayed(){
        WebElement succes_alert = driver.findElement(By.xpath("//*[@id=\"review-section\"]/div/div/span"));
        succes_alert.isDisplayed();
    }


}