import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LiteCartAdminPage {

    private WebDriver driver;

    public LiteCartAdminPage(WebDriver driver) {
        this.driver = driver;
    }

    private By logoutButton = By.xpath("//a[@title='Logout']");
    private By seccussLoginMessage = By.xpath("//div[@class='alert alert-success']");


    public LiteCartAdminLoginPage clickLogoutButton(){
        driver.findElement(logoutButton).click();
        return new LiteCartAdminLoginPage(driver);
    }

    public String getSuccessLoginMessageText(){
        return driver.findElement(seccussLoginMessage).getText();
    }
}
