import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PikabuTests {
    private WebDriver driver;

    @Before
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown (){
        driver.quit();
    }

    private final String titleText = "Горячее – самые интересные и обсуждаемые посты | Пикабу";
    private final String login = "QwertyQwerty";
    private final String password = "QwertyQwerty";
    private final By buttonLoginLocator = By.xpath("//button[@class = 'pkb-normal-btn header-right-menu__login-button']");
    private final By authPopUpLocator = By.xpath("//div[@class = 'auth-modal']");
    private final By inputLoginPopUpLocator = By.xpath("//div[@class = 'auth-modal']//input[@name= 'username'][@placeholder = 'Логин']");
    private final By inputPasswordPopUpLocator = By.xpath("//div[@class = 'auth-modal']//input[@name= 'password'][@placeholder = 'Пароль']");
    private final By buttonLoginPopUpLocator = By.xpath("//div[@class = 'auth-modal']//button[@type = 'submit']/span/ancestor::button");
    private final By errorLoginLocator = By.xpath("//div[@class = 'auth-modal']//button[@type = 'submit']/span/ancestor::button");


    @Test
    public void testingCitePikabuTitle () {
        driver.navigate().to("https://pikabu.ru/");
        Assert.assertEquals(driver.getTitle(), titleText);
    }

    @Test
    public void testingCitePikabuLogin () {
        driver.navigate().to("https://pikabu.ru/");
        var buttonLoginElement = driver.findElement(buttonLoginLocator);
        buttonLoginElement.click();
        var authPopUpElement = driver.findElement(authPopUpLocator);
        var inputLoginPopUpElement = driver.findElement(inputLoginPopUpLocator);
        var inputPasswordPopUpElement = driver.findElement(inputPasswordPopUpLocator);
        authPopUpElement.isDisplayed();
        inputLoginPopUpElement.isDisplayed();
        inputPasswordPopUpElement.isDisplayed();
    }

    @Test
    public void testingAuthorization () {
        driver.navigate().to("https://pikabu.ru/");
        var buttonLoginElement = driver.findElement(buttonLoginLocator);
        buttonLoginElement.click();
        var inputLoginPopUpElement = driver.findElement(inputLoginPopUpLocator);
        var inputPasswordPopUpElement = driver.findElement(inputPasswordPopUpLocator);
        inputLoginPopUpElement.sendKeys(login);
        inputPasswordPopUpElement.sendKeys(password);
        var buttonLoginPopUpElement = driver.findElement(buttonLoginPopUpLocator);
        buttonLoginPopUpElement.click();
        var errorLoginElement = driver.findElement(errorLoginLocator);
        errorLoginElement.isDisplayed();

    }
}
