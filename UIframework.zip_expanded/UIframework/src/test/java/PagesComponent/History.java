package PagesComponent;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import UtilisComponent.BaseClass;

public class History {

	public WebDriver driver;

	@FindBy(xpath = "//*[@id=\"side-menu\"]/li[8]/a/span")
	public WebElement history_menu;

	@FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/h2/span")
	public WebElement widget_title;

	@FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div[1]/div/div/p/span")//*[@id="page-wrapper"]/div/div[1]/div/div/p/span
	public WebElement history_count;
	
	@FindBy(xpath = "//ngx-loading-bar//div")
	public WebElement loadingbar;

	BaseClass B = new BaseClass();

	public static String before_count;

	public History() {
		this.driver = BaseClass.driver;
		PageFactory.initElements(driver, this);
	}

	public void navigate_To_history_menu() throws Exception {
		history_menu.click();
	}

	public void widget_title() throws Exception {
		String actual = widget_title.getText().trim();
		System.out.println(actual);
		Assert.assertEquals("History", actual);

	}
	public String store_history_count() throws Exception {
		B.getwait().until(ExpectedConditions.invisibilityOf(loadingbar));
		before_count = history_count.getText();
		System.out.println("Count : " + before_count);
		return before_count;
		
	}

	

}
