package PagesComponent;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import UtilisComponent.BaseClass;

public class LoginPage {

	public WebDriver driver;

	@FindBy(xpath = "//input[@type='email']")
	public WebElement username;

	@FindBy(xpath = "//input[@type='password']")
	public WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginfield;

	@FindBy(xpath = "//a[@class='setting']")
	public WebElement adminfield;
	
	@FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div/div[1]/div/div[2]/span")
	public WebElement expectedtoll;
	
	@FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div/div[2]/div/div[2]/span")
	public WebElement expectedlocal;
	
	@FindBy(xpath = "//ngx-loading-bar//div")
	public WebElement loadingbar;

	
	public static String expectedlocalcount=null;
	public static String expectedtollcount=null;
	
	BaseClass B = new BaseClass();

	public LoginPage() {
		this.driver = BaseClass.driver;
		PageFactory.initElements(driver, this);
	}

	public void enter_the_credential() throws Exception {
		username.sendKeys(B.getpropvalue("USERNAME"));
		password.sendKeys(B.getpropvalue("PASSWORD"));
	}

	public void click_login_button() throws Exception {
		loginfield.click();
	}

	public void verify_dashboard() throws Exception {
		String actual = adminfield.getText();
		Assert.assertEquals("ADMIN", actual);
	}
	
	public void getcount()
	{
		B.getwait().until(ExpectedConditions.invisibilityOf(loadingbar));
		expectedlocalcount=expectedlocal.getText().trim();
		expectedtollcount=expectedtoll.getText().trim();
		System.out.println(expectedlocalcount);
		System.out.println(expectedtollcount);
	}

}
