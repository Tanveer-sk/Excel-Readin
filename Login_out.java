package Git_Pract.SampleGit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {

	WebDriver driver;

	public static void main(String[] args) {
		App obj = new App();
		obj.broweserLaunch();
		obj.goToWebsite("http://mail.google.com");
		obj.enterCreds();
		obj.signOut();
		obj.closeWindow();
	}

	public void broweserLaunch() {

		driver = new FirefoxDriver(); // Launch new Browser insatance
		driver.manage().window().maximize(); // Maximize browser window

	}

	public void goToWebsite(String url) {

		driver.get(url);

	}

	public void enterCreds() {

		String user = "ENTER THE USERNAME"; // Enter the username here
		WebElement username;
		username = driver.findElement(By.xpath(".//*[@id='Email']"));
		username.sendKeys(user);
		;
		driver.findElement(By.xpath(".//*[@id='next']")).click();
		WebElement password;
		String pass = "ENTER USER PASSWORD"; // ENTER THE PASSWORD HERE
		WebDriverWait timer = new WebDriverWait(driver, 20);
		timer.until(ExpectedConditions.presenceOfElementLocated(By.id("Passwd")));
		password = driver.findElement(By.xpath(".//*[@id='Passwd']"));
		password.sendKeys(pass);
		driver.findElement(By.xpath(".//*[@id='PersistentCookie']")).click();
		driver.findElement(By.xpath(".//*[@id='signIn']")).click();

	}

	public void signOut() {

		driver.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
		driver.findElement(By.id("gb_71")).click();

	}

	public void closeWindow() {

		driver.close();

	}
}
