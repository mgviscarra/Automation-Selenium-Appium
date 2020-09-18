import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GitHubWebTests {
    WebDriver driver;

    @Before
    public void launchBrowser(){
        System.setProperty("webdriver.chrome.driver","/Users/mauricio.viscarra/Documents/tesis/github-web-automation/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://github.com/");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void successLoginTest(){
        WebElement signInLink = driver.findElement(By.xpath("//a[@class='HeaderMenu-link no-underline mr-3']"));
        signInLink.click();
        WebElement emailTextBox = driver.findElement(By.id("login_field"));
        emailTextBox.sendKeys("mgviscarra@gmail.com");
        WebElement passwordTextBox = driver.findElement(By.id("password"));
        passwordTextBox.sendKeys("Itsjustforyou1989");
        WebElement signInButton = driver.findElement(By.xpath("//input[@type='submit']"));
        signInButton.click();
        WebElement userLogo = driver.findElement(By.cssSelector("summary.Header-link"));
        Assert.assertTrue(userLogo.isDisplayed());
    }

    @Test
    public void failedLoginTest(){
        WebElement signInLink = driver.findElement(By.xpath("//a[@class='HeaderMenu-link no-underline mr-3']"));
        signInLink.click();
        WebElement emailTextBox = driver.findElement(By.id("login_field"));
        emailTextBox.sendKeys("mgviscarra@gmail.com");
        WebElement passwordTextBox = driver.findElement(By.id("password"));
        passwordTextBox.sendKeys("wrong");
        WebElement signInButton = driver.findElement(By.xpath("//input[@type='submit']"));
        signInButton.click();
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='container-lg px-2']"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void navigationTest(){
        WebElement signInLink = driver.findElement(By.xpath("//a[@class='HeaderMenu-link no-underline mr-3']"));
        signInLink.click();
        WebElement emailTextBox = driver.findElement(By.id("login_field"));
        emailTextBox.sendKeys("mgviscarra@gmail.com");
        WebElement passwordTextBox = driver.findElement(By.id("password"));
        passwordTextBox.sendKeys("Itsjustforyou1989");
        WebElement signInButton = driver.findElement(By.xpath("//input[@type='submit']"));
        signInButton.click();
        WebElement userLogo = driver.findElement(By.cssSelector("summary.Header-link"));
        Assert.assertTrue(userLogo.isDisplayed());
        WebElement issuesButton = driver.findElement(By.xpath("//a[@aria-label='Issues you created']"));
        issuesButton.click();
        WebElement createdTab = driver.findElement(By.xpath("//a[text()='Created']"));
        WebElement assignedTab = driver.findElement(By.xpath("//a[text()='Assigned']"));
        WebElement mentionedTab = driver.findElement(By.xpath("//a[text()='Mentioned']"));
        Assert.assertTrue(createdTab.isDisplayed());
        Assert.assertTrue(assignedTab.isDisplayed());
        Assert.assertTrue(mentionedTab.isDisplayed());
        WebElement pullRequestsButton = driver.findElement(By.xpath("//a[@aria-label='Pull requests you created']"));
        pullRequestsButton.click();
        createdTab = driver.findElement(By.xpath("//a[text()='Created']"));
        assignedTab = driver.findElement(By.xpath("//a[text()='Assigned']"));
        mentionedTab = driver.findElement(By.xpath("//a[text()='Mentioned']"));
        Assert.assertTrue(createdTab.isDisplayed());
        Assert.assertTrue(assignedTab.isDisplayed());
        Assert.assertTrue(mentionedTab.isDisplayed());
        WebElement menuDropdown = driver.findElement(By.xpath("//summary[@aria-label='View profile and more']"));
        menuDropdown.click();
        WebElement repositoriesButton = driver.findElement(By.xpath("//a[text()='Your repositories']"));
        repositoriesButton.click();
        WebElement repositoriesLabel = driver.findElement(By.xpath("//a[@aria-current='page']"));
        Assert.assertTrue(repositoriesLabel.isDisplayed());
        menuDropdown = driver.findElement(By.xpath("//summary[@aria-label='View profile and more']"));
        menuDropdown.click();
        WebElement organizationsButton = driver.findElement(By.xpath("//a[text()='Your organizations']"));
        organizationsButton.click();
        WebElement organizationsLabel = driver.findElement(By.xpath("//a[@aria-current='page']"));
        Assert.assertTrue(organizationsLabel.isDisplayed());
    }

    @After
    public void closeBrowser(){
        driver.close();
    }
}
