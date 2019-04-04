import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Linkedin {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/MyDrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.linkedin.com/");

        WebElement loginEmail = driver.findElement(By.xpath("//input[@id='login-email']"));
        loginEmail.sendKeys("testerok111333@gmail.com");

        WebElement loginPass = driver.findElement(By.xpath("//input[@id='login-password']"));
        loginPass.sendKeys("111333");

        WebElement loginButton = driver.findElement(By.id("login-submit"));
        loginButton.click();

        //сравнение по содержанию
        if (driver.getPageSource().contains("Профиль"))
        {
            System.out.println("page is ok");
        }
        else
        {
            System.out.println("wrong page");
        }
        //сравнение по урл
        if (driver.getCurrentUrl().contains("https://www.linkedin.com/feed"))
        {
            System.out.println("url is ok!");
        }
        else
        {
            System.out.println("wrong url");
        }

        driver.quit();
    }

}
