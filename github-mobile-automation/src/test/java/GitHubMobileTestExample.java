import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.core.annotation.Order;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GitHubMobileTestExample {
    AndroidDriver driver;

    @Before
    public void launchApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Device");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("appPackage","com.github.android");
        capabilities.setCapability("appActivity","com.github.android.activities.MainActivity");
        capabilities.setCapability("app", "/Users/mauricio.viscarra/Documents/tesis/github-mobile-automation/src/test/resources/github.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    @Order(1)
    public void loginFailTest(){
        AndroidElement signInButton = (AndroidElement) driver.findElement(By.id("com.github.android:id/login_button"));
        signInButton.click();
        AndroidElement emailTextBox = (AndroidElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[3]/android.view.View/android.view.View/android.widget.EditText[1]"));
        emailTextBox.sendKeys("mgviscarra@gmail.com");
        AndroidElement passwordTextBox = (AndroidElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[3]/android.view.View/android.view.View/android.widget.EditText[2]"));
        passwordTextBox.sendKeys("wrong");
        AndroidElement signIn = (AndroidElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[3]/android.view.View/android.view.View/android.widget.Button"));
        signIn.click();
        AndroidElement incorrectLoginMessage = (AndroidElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[3]/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.view.View/android.widget.TextView"));
        Assert.assertTrue(incorrectLoginMessage.isDisplayed());
    }

    @Test
    @Order(2)
    public void loginSuccessTest() throws InterruptedException {
        AndroidElement signInButton = (AndroidElement) driver.findElement(By.id("com.github.android:id/login_button"));
        signInButton.click();
        AndroidElement emailTextBox = (AndroidElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[3]/android.view.View/android.view.View/android.widget.EditText[1]"));
        emailTextBox.sendKeys("mgviscarra@gmail.com");
        AndroidElement passwordTextBox = (AndroidElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[3]/android.view.View/android.view.View/android.widget.EditText[2]"));
        passwordTextBox.sendKeys("Itsjustforyou1989");
        AndroidElement signIn = (AndroidElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[3]/android.view.View/android.view.View/android.widget.Button"));
        signIn.click();
        AndroidElement userIcon = (AndroidElement) driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Profile\"]"));
        Assert.assertTrue(userIcon.isDisplayed());
    }


    @Test
    @Order(3)
    public void navigationTest() throws InterruptedException {
        AndroidElement signInButton = (AndroidElement) driver.findElement(By.id("com.github.android:id/login_button"));
        signInButton.click();
        Thread.sleep(5000);
        AndroidElement userIcon = (AndroidElement) driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Profile\"]"));
        Assert.assertTrue(userIcon.isDisplayed());
        AndroidElement issuesButton = (AndroidElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ViewAnimator/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
        issuesButton.click();
        AndroidElement issuesCreatedTab = (AndroidElement) driver.findElement(By.xpath("//o.b.k.a.c[@content-desc=\"Created\"]/android.widget.TextView"));
        AndroidElement issuesAssignedTab = (AndroidElement) driver.findElement(By.xpath("//o.b.k.a.c[@content-desc=\"Assigned\"]/android.widget.TextView"));
        AndroidElement issuesMentionedTab = (AndroidElement) driver.findElement(By.xpath("//o.b.k.a.c[@content-desc=\"Mentioned\"]/android.widget.TextView"));
        Assert.assertTrue(issuesCreatedTab.isDisplayed());
        Assert.assertTrue(issuesAssignedTab.isDisplayed());
        Assert.assertTrue(issuesMentionedTab.isDisplayed());
        AndroidElement backButton = (AndroidElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton"));
        backButton.click();
        AndroidElement pullRequestsButton = (AndroidElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ViewAnimator/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView"));
        pullRequestsButton.click();
        AndroidElement pullRequestsCreatedTab = (AndroidElement) driver.findElement(By.xpath("//o.b.k.a.c[@content-desc=\"Created\"]/android.widget.TextView"));
        AndroidElement pullRequestsAssignedTab = (AndroidElement) driver.findElement(By.xpath("//o.b.k.a.c[@content-desc=\"Assigned\"]/android.widget.TextView"));
        AndroidElement pullRequestsMentionedTab = (AndroidElement) driver.findElement(By.xpath("//o.b.k.a.c[@content-desc=\"Mentioned\"]/android.widget.TextView"));
        Assert.assertTrue(pullRequestsCreatedTab.isDisplayed());
        Assert.assertTrue(pullRequestsAssignedTab.isDisplayed());
        Assert.assertTrue(pullRequestsMentionedTab.isDisplayed());
        backButton = (AndroidElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton"));
        backButton.click();
        AndroidElement repositoriesButton = (AndroidElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ViewAnimator/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView"));
        repositoriesButton.click();
        Thread.sleep(5000);
        AndroidElement repositoriesHeader = (AndroidElement) (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.github.android:id/title")));
        Assert.assertTrue(repositoriesHeader.isDisplayed());
        backButton = (AndroidElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton"));
        backButton.click();
        AndroidElement organizationsButton = (AndroidElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ViewAnimator/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.TextView"));
        organizationsButton.click();
        Thread.sleep(5000);
        WebElement organizationsHeader = driver.findElement(By.id("com.github.android:id/title"));
        Assert.assertTrue(organizationsHeader.isDisplayed());
        backButton = (AndroidElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton"));
        backButton.click();
    }

    @After
    public void closeApp(){
        driver.closeApp();
    }
}
