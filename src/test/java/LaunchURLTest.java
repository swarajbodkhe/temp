
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class LaunchURLTest {
    WebDriver driver=null;
    @BeforeMethod
    public void a() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        WebDriverWait wt = new WebDriverWait(driver, 3);
    }
    public WebDriver getdriver(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
    @Test
    public void T1() throws ParseException {
        getdriver().get("https://www.dream11.com/leagues");
        Cookie ck = new Cookie("connect.sid", "", ".dream11.com", "/", new SimpleDateFormat("dd/MM/yyyy").parse("09/10/2021"));
        getdriver().manage().addCookie(ck);
        getdriver().navigate().refresh();
        getdriver().findElement(By.xpath("//a[contains(@href,'/me')]")).click();
        getdriver().findElement(By.xpath("//a[contains(@class,'menuLink')][1]/div/div[1]")).click();
        System.out.println(getdriver().findElement(By.xpath("//p[contains(@class,'teamName')]")).getText());
//        System.out.println(getdriver().findElement(By.xpath("//span[@class='address']/a")).getText());
    }

}