package tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EbebekPage;
import utilities.*;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_001 {


    private static Logger logger = LogManager.getLogger(TC_001.class);//hata raporlarını almada kullanacagım log tanımlanır

   // https://www.e-bebek.com/ sitesi açılır.
   // Arama çubuğuna "kaşık maması" yazılır ve arama sonucunda gelen sonuçlardan en son ürün açılır,
   // açılan ürünle arama sonucunda tıklanan ürünün aynı olduğu doğrulanır.
   // Ürün sepete eklenir.
   // Sağdan açılan modadan sepeti gör butonuna tıklanır.
   // Alışverişi tamamla butonuna tıklanır.
   // Üye girişi ekranının açıldığı doğrulanır.

    EbebekPage ebebekPage;

    @Test
    public void test01(){

    ebebekPage= new EbebekPage();
        Actions actions= new Actions(Driver.getDriver());

        Driver.getDriver().get(ConfigReader.getProperty("url"));// https://www.e-bebek.com/ sitesi açılır.
        ebebekPage.notificationText.click(); // Ekrana gelen uyarı kapatılır
        logger.info("ebebek sitesine gidilir");
        actions.click(ebebekPage.searchBox).sendKeys("Kaşık Maması",Keys.ENTER).perform();// Arama çubuğuna "kaşık maması" yazılır
        ReusableMethods.waitForPageToLoad(1);
        ebebekPage.options.click(); //Kaşık maması ürünleri filtrelenir
        logger.info("Kaşık maması ürünleri filtrelenir");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform(); //Açılan sayfada aşağı inilir
        ReusableMethods.waitForClickablility(ebebekPage.lastProduct,3);
        String lastProduct=ebebekPage.lastProduct.getText();//Sayfadaki son ürünün text i String bir değere atanır
        //System.out.println(lastProduct);
        ReusableMethods.waitFor(3);
        ebebekPage.lastProduct.click();//Sayfadaki son ürüne tıklanır
        logger.info("Sayfadaki son ürüne tıklanır");
        ReusableMethods.waitFor(3);
        String openedProduct=ebebekPage.openedProduct.getText();//Açılan sayfadaki son ürünün text i String bir değere atanır
        System.out.println(openedProduct);
        Assert.assertTrue(lastProduct.contains(openedProduct)); //Açılan ürünün textinin, arama sonucunda tıklanan ürünün textini içerdiği doğrulanarak,
        logger.info("Açılan ürünle arama sonucunda tıklanan ürünün aynı olduğu doğrulanır");                                                      //açılan ürünle arama sonucunda tıklanan ürünün aynı olduğu doğrulanmış olur
        ReusableMethods.waitFor(3);
        ebebekPage.addCart.click(); // Ürün sepete eklenir.
        logger.info("Ürün sepete eklenir");
        ReusableMethods.waitFor(3);
        ebebekPage.seeCart.click(); // Sağdan açılan modadan sepeti gör butonuna tıklanır.
        logger.info("Sağdan açılan modadan sepeti gör butonuna tıklanır");
        ReusableMethods.waitFor(3);
        ebebekPage.endShopping.click();// Alışverişi tamamla butonuna tıklanır.
        logger.info("Alışverişi tamamla butonuna tıklanır");
        ReusableMethods.waitFor(3);
        Assert.assertTrue(ebebekPage.memberLogin.isDisplayed()); // Üye girişi ekranının açıldığı doğrulanır.
        logger.info("Üye girişi ekranının açıldığı doğrulanır");
    }
}
