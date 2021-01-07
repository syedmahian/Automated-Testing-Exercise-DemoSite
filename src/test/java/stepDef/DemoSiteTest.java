package stepDef;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DemoSiteTest {
	
	public static WebDriver driver;
	private static String URL = "http://thedemosite.co.uk/";
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));

	}
	
	
	@Given("^the correct address$")
	public void the_correct_address() throws Throwable {
		
		driver.get(URL);
		assertEquals("FREE example PHP code and online MySQL database - example username password protected site", driver.getTitle());
	}

	@When("^I create a new user$")
	public void i_create_a_new_user() {
		
		driver.findElement(By.linkText("3. Add a User")).click();
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("guest");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("guest");
		driver.findElement(By.name("FormsButton2")).click();
	}

	@Then("^I can login as the user$")
	public void i_can_login_as_the_user() {
		
		driver.findElement(By.linkText("4. Login")).click();
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("guest");
		driver.findElement(By.name("password")).sendKeys("guest");
		driver.findElement(By.name("FormsButton2")).click();
		driver.findElement(By.cssSelector("font > center")).click();
		
		assertThat(driver.findElement(By.cssSelector("center > b")).getText(), is("**Successful Login**"));
	}


	@After
	public void tearDown() {
		driver.close();
	}

}
