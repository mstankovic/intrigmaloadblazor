package intrigma;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoadTest {

    @Test
    public void waitForCalendarToLoad1(){
        WebDriver _driver = createDriver();
        open(_driver,"https://staging.prod.intrigma.com:10005");
        login(_driver, "account1@intrigma.com", "intrigma4");
        waitToLoad(_driver);
        quitDriver(_driver);
    }

    @Test
    public void waitForCalendarToLoad2(){
        WebDriver _driver = createDriver();
        open(_driver,"https://staging.prod.intrigma.com:10005");
        login(_driver, "account1@intrigma.com", "intrigma4");
        waitToLoad(_driver);
        quitDriver(_driver);
    }

    @Test
    public void waitForCalendarToLoad3(){
        WebDriver _driver = createDriver();
        open(_driver,"https://staging.prod.intrigma.com:10005");
        login(_driver, "account1@intrigma.com", "intrigma4");
        waitToLoad(_driver);
        quitDriver(_driver);
    }

    @Test
    public void waitForCalendarToLoad4(){
        WebDriver _driver = createDriver();
        open(_driver,"https://staging.prod.intrigma.com:10005");
        login(_driver, "account1@intrigma.com", "intrigma4");
        waitToLoad(_driver);
        quitDriver(_driver);
    }

    @Test
    public void waitForCalendarToLoad5(){
        WebDriver _driver = createDriver();
        open(_driver,"https://staging.prod.intrigma.com:10005");
        login(_driver, "account1@intrigma.com", "intrigma4");
        waitToLoad(_driver);
        quitDriver(_driver);
    }

    private WebDriver createDriver(){
        WebDriver _driver;
        if (System.getProperty("os.name").toLowerCase().startsWith("linux")){
            System.setProperty("webdriver.chrome.driver", "drivers"+ File.separator + "chromedriver-linux-64bit");
        }else if (System.getProperty("os.name").toLowerCase().startsWith("windows")){
            System.setProperty("webdriver.chrome.driver", "drivers"+ File.separator + "chromedriver-windows-32bit.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "drivers"+ File.separator + "chromedriver-mac-64bit");
        }
        _driver = new ChromeDriver();
        _driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        _driver.manage().window().maximize();
        return _driver;
    }

    private void quitDriver(WebDriver driver){
        driver.quit();
    }

    private static void open(WebDriver driver, String url){
        driver.get(url);
    }

    private static void login(WebDriver driver, String username, String password){
        driver.findElement(By.xpath("//label[text()='Intrigma ID']/../input")).sendKeys(username);
        driver.findElement(By.xpath("//label[text()='Password']/../input")).sendKeys(password);
        driver.findElement(By.xpath("//button[@aria-label='Log In Progress']")).click();
    }

    private static void waitToLoad(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'e-spin-show')]/div")));

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);

        Boolean vis = true;
        while (vis) {
            try {
                driver.findElement(By.xpath("//div[contains(@class, 'e-spin-show')]/div"));
            } catch (org.openqa.selenium.NoSuchElementException e) {
                vis = false;
            }
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
