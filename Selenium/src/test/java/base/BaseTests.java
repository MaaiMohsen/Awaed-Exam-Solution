package base;


import Pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTests {
    private WebDriver driver;
    protected LogInPage logInPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.testyou.in/Login.aspx");
        driver.manage().window().maximize();
        logInPage = new LogInPage(driver);
    }

    @AfterClass
    public void tearDown (){
        driver.quit();
    }
}
