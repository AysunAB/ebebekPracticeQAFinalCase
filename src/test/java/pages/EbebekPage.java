package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class EbebekPage {


    public EbebekPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//img[@class='ins-close-button-c2703']")
    public WebElement notificationText;

    @FindBy(xpath = "//i[@class='icon icon-close-modal cookies__img-close']")
    public WebElement cookies;


    @FindBy(xpath = "//input[@id='txtSearchBox']")
    public WebElement searchBox;

    @FindBy(xpath = "//input[@id='chk3882']")
    public WebElement options;


    @FindBy(xpath = "(//eb-product-list-item[@class='col-6 col-lg-4 col-md-4 col-xl-3 prod-item-col ng-star-inserted'])[10]")
    public WebElement lastProduct;

    @FindBy(xpath = "(//b[text()='Gece Sütlü Rezeneli 8 Tahıllı 200 gr'])[2]")
    public WebElement openedProduct;

    @FindBy(xpath = "(//button[@id='addToCartBtn'])[1]")
    public WebElement addCart;

    @FindBy(xpath = "//a[text()='Sepeti Gör']")
    public WebElement seeCart;

    @FindBy(xpath = "(//span[text()='Alışverişi Tamamla'])[1]")
    public WebElement endShopping;

    @FindBy(xpath = "//button[text()=' Giriş Yap / Üye Ol ']")
    public WebElement memberLogin;

}
