package PagesComponent;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import UtilisComponent.BaseClass;

public class Profile {

	public WebDriver driver;

	@FindBy(xpath = "//*[@id=\"navbarDropdownMenuLink\"]")
	public WebElement profile_tab;

	@FindBy(xpath = "/html/body/app-root/app-nav-bar/nav/div/div/div/ul/li/a[2]/div/a[1]")
	public WebElement myprofile_tab;

	@FindBy(xpath = "//ngx-loading-bar//div")
	public WebElement loadingbar;

	@FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/h2/span")
	public WebElement widget_title;


	@FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div/div/div[1]/div/div/form/button")
	public WebElement update_button;
	
	@FindBy(xpath = "//div[@role='alertdialog']")
	public WebElement get_message;

	@FindBy(xpath = "//*[@id=\"currentPassword\"]")
	public WebElement current_password;
	
	@FindBy(xpath = "//*[@id=\"formGroupExampleInput\"]")
	public WebElement new_password;
	
	@FindBy(xpath = "//*[@id=\"confirmNewPassword\"]")
	public WebElement confirm_new_password;
	
	@FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div/div/div[2]/div/form/div/button")
	public WebElement click_change;
	
	@FindBy(xpath = "//input[@type='file']")
	public WebElement profile_upload;

	
	@FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div/div/div[3]/div/div/div/div[2]/button")
	public WebElement upload_picture;
	
	BaseClass B = new BaseClass();

	public static String before_count;

	public Profile() {
		this.driver = BaseClass.driver;
		PageFactory.initElements(driver, this);
	}

	public void navigate_To_profile_tab() throws Exception {
		B.getwait().until(ExpectedConditions.invisibilityOf(loadingbar));
		profile_tab.click();

	}

	public void click_the_myprofile_tab() throws Exception {
	
		myprofile_tab.click();
		B.getwait().until(ExpectedConditions.invisibilityOf(loadingbar));
		System.out.println(myprofile_tab);

	}

	public void verify_the_widget_title(String value) throws Exception {
		B.getwait().until(ExpectedConditions.invisibilityOf(loadingbar));
		widget_title.isDisplayed();
		}
	public void click_update_button() throws Exception {
		B.getwait().until(ExpectedConditions.invisibilityOf(loadingbar));
		update_button.click();
		}
	public void get_the_message() throws Exception {
		B.getwait().until(ExpectedConditions.visibilityOf(get_message));
		String actual = get_message.getText().trim();
		Assert.assertEquals("updated successfully", actual);
		}
	
	public void click_change_password() throws Exception {
		B.getwait().until(ExpectedConditions.invisibilityOf(loadingbar));
		click_change.click();
        get_the_password();
	}
	public void get_the_password() throws Exception {
		B.getwait().until(ExpectedConditions.visibilityOf(get_message));
		String actual = get_message.getText().trim();
		Assert.assertEquals("password updated", actual);
		}
	
	public void file_upload() throws Exception {
		B.getwait().until(ExpectedConditions.invisibilityOf(loadingbar));
		profile_upload.sendKeys("C:\\Users\\user\\OneDrive\\Pictures\\Screenshots\\2022-02-04.png");
		

	}	
	public void get_the_profile() throws Exception {
		B.getwait().until(ExpectedConditions.visibilityOf(get_message));
		String actual = get_message.getText().trim();
		Assert.assertEquals("profile picture updated successfully", actual);
		}
	
	public void click_upload_picture() throws Exception {
		B.getwait().until(ExpectedConditions.invisibilityOf(loadingbar));
		upload_picture.click();
		get_the_profile();
		
}

}