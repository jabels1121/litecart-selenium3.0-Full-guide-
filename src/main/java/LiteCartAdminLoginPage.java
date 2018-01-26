import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LiteCartAdminLoginPage {

    private WebDriver driver;

    public LiteCartAdminLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameField = By.xpath("//input[@name='username']");
    private By userPassField = By.xpath("//input[@name='password']");
    private By rememberCheckBox = By.xpath("//inpute[@name='remember_me']");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By emptyUserNameFieldError = By.xpath("//div[@class='alert alert-danger' and contains(text(),'You must provide a username')]");
    private By userCouldNotFoundError = By.xpath("//div[@class='alert alert-danger' and contains(text(),'The user could')]");
    private By wrongCombinationUserPass = By.xpath("//div[@class='alert alert-danger' and contains(text(),'Wrong combination')]");
    private By attempsWarningError = By.xpath("//div[@class='alert alert-danger' and contains(text(),'login attempts left until your account')]");
    private By accountBlockedError = By.xpath("//div[@class='alert alert-danger' and contains(text(),'The account has been temporary blocked 15 minutes')]");
    private By accountBlockedUntil = By.xpath("//div[@class='alert alert-danger' and contains(text(),'The account is blocked until')]");
    private By imgLogo = By.xpath("//div[@class='header']//img");
    private By logoIcon = By.xpath("//div[@class='header']/a");

    public LiteCartAdminLoginPage typeUserNameField(String userName){
        driver.findElement(userNameField).sendKeys(userName);
        return this;
    }

    public WebElement getTheLogo(){
        return driver.findElement(imgLogo);
    }

    public boolean isHaveTheLogo(){
        try {
            getTheLogo();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public LiteCartAdminLoginPage typePassNameField(String password){
        driver.findElement(userPassField).sendKeys(password);
        return this;
    }

    public boolean testCheckBoxIsSelected(){
        if (driver.findElement(rememberCheckBox).isSelected()) return true;
        else return false;
    }

    public LiteCartAdminLoginPage selectCheckBox(){
        if (testCheckBoxIsSelected() == false){
            driver.findElement(rememberCheckBox).click();
        }
        return this;
    }

    public LiteCartAdminLoginPage loginWithEmptyFields(){
        driver.findElement(loginButton).click();
        return new LiteCartAdminLoginPage(driver);
    }

    public LiteCartAdminLoginPage loginWithEmptyPass(String userName){
        typeUserNameField(userName);
        driver.findElement(loginButton).click();
        return new LiteCartAdminLoginPage(driver);
    }

    public LiteCartAdminLoginPage loginWithIncorrectUserName(String incorrectUserName){
        typeUserNameField(incorrectUserName);
        driver.findElement(loginButton).click();
        return new LiteCartAdminLoginPage(driver);
    }

    public LiteCartAdminLoginPage loginWithIncorrectPass(String userName, String incorrectPass){
        typeUserNameField(userName);
        typePassNameField(incorrectPass);
        driver.findElement(loginButton).click();
        return new LiteCartAdminLoginPage(driver);
    }

    public LiteCartAdminPage successLogin(String userName, String password){
        typeUserNameField(userName);
        typePassNameField(password);
        driver.findElement(loginButton).click();
        return new LiteCartAdminPage(driver);
    }

    public LiteCartUserPage clickOnLogoIcon(){
        driver.findElement(logoIcon).click();
        return new LiteCartUserPage(driver);
    }



}
