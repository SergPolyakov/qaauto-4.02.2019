import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BadCodeExampl {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/MyDrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        String searchTerm = "Selenium";

        WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
        search.sendKeys(searchTerm);
        search.sendKeys(Keys.ENTER);

        List<WebElement> searchResults =
                driver.findElements(By.xpath("//div[@class='g']"));
        System.out.println("Найденных результатов на странице - " + searchResults.size());

        //for each webelement in result list print text
        for (WebElement searchResult : searchResults) {
            String searchResultString = searchResult.getText();
            System.out.println(searchResult.getText());

            if (searchResultString.toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("SearchTerm found \n");
            } else {
                System.out.println("SearchTerm not found");
            }

        }


    }
}
