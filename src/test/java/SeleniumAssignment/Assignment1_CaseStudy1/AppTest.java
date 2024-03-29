package SeleniumAssignment.Assignment1_CaseStudy1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AppTest {
	@Test
	public void testCase() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Manjiri/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "path_to_geckodriver");
        //i dont have firefox browser 
        String browserName = "chrome"; 
        WebDriver driver = getDriver(browserName);

//navigating to the website        
        driver.get("https://www.coursera.org/");
//maximizing the window
        driver.manage().window().maximize();
//locating the search box and sending keys to it
        WebElement searchBox = driver.findElement(By.className("react-autosuggest__input"));
        searchBox.sendKeys("Data analytics");
        Thread.sleep(5000);
//getting attributes of the searchbox
        String id = searchBox.getAttribute("id");
        String name = searchBox.getAttribute("name");
        String xpath = searchBox.getAttribute("xpath");
        String className = searchBox.getAttribute("class");
        String placeholder = searchBox.getAttribute("placeholder");
        String ariaLabel = searchBox.getAttribute("aria-label");
        String role = searchBox.getAttribute("role");
        String value = searchBox.getAttribute("value");

       
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("XPath: " + xpath);
        System.out.println("Class: " + className);
        System.out.println("Placeholder: " + placeholder);
        System.out.println("Aria-label: " + ariaLabel);
        System.out.println("Role: " + role);
        System.out.println("Value: " + value);
//locating the search icon and clicking on it
        WebElement searchelement = driver.findElement(By.cssSelector("button[class='nostyle search-button'] div[class='magnifier-wrapper']"));
        searchelement.click();
//navigating back to the previous window
        driver.navigate().back();
        Thread.sleep(5000);
//locating the log in link using linktext
        WebElement logIn=driver.findElement(By.linkText("Log In"));
        logIn.click();
        Thread.sleep(5000);
//locating the cross button
        WebElement Cross=driver.findElement(By.xpath("//button[@class='_1wktrlf _1im0dc8']//*[name()='svg']"));
        Cross.click();
        Thread.sleep(5000);
//locating the login link using partialLinkText
        WebElement logInPartial=driver.findElement(By.partialLinkText("Log"));
        logInPartial.click();
        Thread.sleep(5000);
//locating the cross button again
        WebElement svgElement = driver.findElement(By.xpath("//button[@class='_1wktrlf _1im0dc8']//*[name()='svg']"));
	    svgElement.click();
//printing the linktext and partiallinktext
	    String linkText = logIn.getText();
	    String[] partialLink = linkText.split(" ");

       System.out.println("Link Text: " + linkText);
       System.out.println("First part of the text: " + partialLink[0]);
       //closing the window
       driver.quit();
	}
	public static WebDriver getDriver(String browserName) {
        WebDriver driver;
        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        return driver;
    }
}
 