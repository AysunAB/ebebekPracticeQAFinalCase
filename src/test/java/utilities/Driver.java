package utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;


public class Driver {

    private Driver(){

    }

    static WebDriver driver;


    public static WebDriver getDriver(){ //driver'i getir her yerde kullanabilmek içinde static yaptık

        if (driver==null) {

            switch (ConfigReader.getProperty("browser")){

                case "chrome" :  //browser kısmı değiştirilebilir hangisini istersek onun ayarlamasını yaparız
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver= new EdgeDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "headless-chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }



            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }

        return driver;
    }

    public static void closeDriver(){

        if (driver!=null) { //diver'a değer atanmamışsa
            driver.close();
            driver = null; //Kapandıktan sonraki açmaları garanti altına almak için driver'i tekrar null yaptık
        }

    }

    public static void quitDriver(){

        if (driver!=null) {//diver'a değer atanmamışsa
            driver.quit();
            driver = null;//Kapandıktan sonraki açmaları garanti altına almak için driver'i tekrar null yaptık
        }

    }

}
