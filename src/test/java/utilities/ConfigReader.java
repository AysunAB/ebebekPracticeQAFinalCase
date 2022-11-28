package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties; //her yerden ulaşmak için class seviyesinde yapıyoruz

    static {  //her methoddan önce çalışır

        String dosyaYolu ="configuration.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            /*
            fis dosyayolunu tanimladigimiz configuration.properties dosyasini okudu
             */

            properties = new Properties();
            properties.load(fis);//fis'in okuduğu bilgileri properties'e yükledi

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public static String getProperty(String key){ // testMETHOD'UNDAN BURAYA KEY GELECEK
        /*
         Test methodundan yolladigimiz String key degerini alip properties classindan
         getProperty() methodunu kullanarak bu key'e ait value'yu bize getirir
         */

        return properties.getProperty(key); // BURADA DA VALUE ALIP DONECEK
                                           /*
                                           TARGET altinda olusturduğumuz configuration.propertiers
                                           kısmından key leri aliyor ve donup value degerlerini de aliyor
                                            */
    }

}
