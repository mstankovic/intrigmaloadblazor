package intrigma;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public abstract class WebDriverHandler {
    public static WebDriver _driver;

    @Before
    public void start(){
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
    }

    @After
    public void quit(){
        _driver.quit();
    }
}
