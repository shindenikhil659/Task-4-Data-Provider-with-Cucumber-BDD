package StepDefination;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class ExampleStepDefinitions {

    WebDriver driver;

    @Given("User is on the Coursera login page")
    public void user_is_on_the_coursera_login_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shind\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.coursera.org/");
    }


    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String usernameKey, String passwordKey) {
        Object[][] testData = ExcelDataProvider.getTestData("Sheet1");
        for (Object[] row : testData) {
            String username = (String) row[0];
            String password = (String) row[1];
            if (usernameKey.equals("<username>") && passwordKey.equals("<password>")) {
                driver.findElement(By.name("email")).sendKeys(username);
                driver.findElement(By.name("password")).sendKeys(password);
                driver.findElement(By.cssSelector("button[data-e2e='login-button']")).click();
                break;
            }
        }
    }


    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
    	/*WebElement welcomeMessage = driver.findElement(By.className("welcome-message"));
        assertTrue(welcomeMessage.isDisplayed());

        // Add assertions or verification steps for successful login
        // For example, you can check for the presence of a welcome message or a dashboard element
        // assert(driver.findElement(By.className("welcome-message")).isDisplayed());*/
        driver.quit();
    }
}
