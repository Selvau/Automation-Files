package PagesComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import UtilisComponent.BaseClass;

public class User {

	public WebDriver driver;

	@FindBy(xpath = "//*[@id=\"side-menu\"]/li[10]/a/span")
	public WebElement user_menu;

	@FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div[1]/div/div[1]/p/span")
	public WebElement widget_title;

	@FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div[1]/div/div/p/span")
	public WebElement user_count;

	@FindBy(xpath = "//ngx-loading-bar//div")
	public WebElement loadingbar;

	@FindBy(xpath = "//*[@id=\"home\"]/div[1]/div[2]/div/div/button")
	public WebElement click_filter;

	@FindBy(xpath = "//*[@id=\"home\"]/div[1]/div[2]/div/div/div/form/div/div[1]/div[1]/div/input")
	public WebElement first_name;

	@FindBy(xpath = "//*[@id=\"home\"]/div[1]/div[2]/div/div/div/form/div/div[1]/div[2]/div/input")
	public WebElement last_name;

	@FindBy(xpath = "//*[@id=\"home\"]/div[1]/div[2]/div/div/div/form/div/div[2]/div[1]/div/input")
	public WebElement enter_email;

	@FindBy(xpath = "//select[@formcontrolname='status']")
	public WebElement status;

	@FindBy(xpath = "//*[@id=\"home\"]/div[1]/div[2]/div/div/div/form/div/div[3]/div/button[1]")
	public WebElement filter_button;



	BaseClass B = new BaseClass();

	public static String before_count;

	public User() {
		this.driver = BaseClass.driver;
		PageFactory.initElements(driver, this);
	}

	public void navigate_To_user_menu() throws Exception {
		user_menu.click();
	}

	public String stores_user_count() throws Exception {
		B.getwait().until(ExpectedConditions.invisibilityOf(loadingbar));
		before_count = user_count.getText();
		System.out.println("Count : " + before_count);
		return before_count;
	}

	public void click_the_filter_tab() throws Exception {
		click_filter.click();

	}

	public void select_status(WebElement element, String Value) throws Exception {
		Select sc = new Select(element);
		sc.selectByVisibleText(Value);

	}

	public void click_the_filter_button() throws Exception {
		filter_button.click();

	}

	}

