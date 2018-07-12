package automationpractice.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="passwd")
	public WebElement password;
	
	@FindBy(id="SubmitLogin")
	public WebElement loginButton;
	
	public void login(String user, String password) {
		email.sendKeys(user);
		this.password.sendKeys(password);
		loginButton.click();
	}
}