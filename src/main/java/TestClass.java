import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestClass {

    private static WebDriver driver;



    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\IdeaProjects\\testselenium\\drivers\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://litecart/admin");
        LiteCartAdminLoginPage liteCartAdminLoginPage = new LiteCartAdminLoginPage(driver);


    }
}
