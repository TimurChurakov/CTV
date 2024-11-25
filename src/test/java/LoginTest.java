import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
public class LoginTest extends BaseTest {

    @Test
    public void testPositiveLogin() {
        browser.findElement(By.id("user-name")).sendKeys("standard_user");
        browser.findElement(By.id("password")).sendKeys("secret_sauce");
        browser.findElement(By.id("login-button")).click();
        boolean isPresent = browser.findElement(By.xpath("//span[@class='title']")).isDisplayed();
        assertTrue(isPresent);
    }

    @Test
    public void testNegativeLoginUserName() {
        browser.findElement(By.id("user-name")).sendKeys("standard_use");
        browser.findElement(By.id("password")).sendKeys("secret_sauce");
        browser.findElement(By.id("login-button")).click();
        String errorMessege = browser.findElement(By.cssSelector("[data-test='error']")).getText();
        assertEquals(errorMessege, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void testNegativeLoginPassword() {
        browser.findElement(By.id("user-name")).sendKeys("standard_user");
        browser.findElement(By.id("password")).sendKeys("");
        browser.findElement(By.id("login-button")).click();
        String errorMessege = browser.findElement(By.cssSelector("[data-test='error']")).getText();
        assertEquals(errorMessege, "Epic sadface: Password is required");
    }

}
