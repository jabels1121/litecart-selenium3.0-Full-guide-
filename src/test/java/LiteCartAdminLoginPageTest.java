import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LiteCartAdminLoginPageTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private LiteCartAdminLoginPage liteCartAdminLoginPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\IdeaProjects\\testselenium\\drivers\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://litecart/admin");
        liteCartAdminLoginPage = new LiteCartAdminLoginPage(driver);
    }

    @Test
    public void successLoginTest(){
        LiteCartAdminPage liteCartAdminPage = liteCartAdminLoginPage.successLogin("admin", "admin");
        String successLogin = liteCartAdminPage.getSuccessLoginMessageText();
        Assert.assertEquals("×\n" + "You are now logged in as admin", successLogin);
    }

    @Test
    public void loginLogoutTest(){
        LiteCartAdminPage liteCartAdminPage = liteCartAdminLoginPage.successLogin("admin", "admin");
        LiteCartAdminLoginPage liteCartAdminLoginPage = liteCartAdminPage.clickLogoutButton();
        Assert.assertTrue(liteCartAdminLoginPage.isHaveTheLogo());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
