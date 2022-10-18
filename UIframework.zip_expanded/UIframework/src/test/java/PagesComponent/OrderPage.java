package PagesComponent;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import UtilisComponent.BaseClass;

public class OrderPage {

	public WebDriver driver;

	@FindBy(xpath = "//*[@id=\"side-menu\"]/li[5]/a/span")
	public WebElement orders_menu;
	
	@FindBy(xpath = "//table/tbody/tr[1]")
	public WebElement first_order;
	
	@FindBy(xpath = "//table/tbody/tr[2]/td/div/ul[1]/li")
	public WebElement first_order_number;
	
	@FindBy(xpath = "//ngx-loading-bar//div")
	public WebElement loadingbar;

	public static String ordernumber=null;

	BaseClass B = new BaseClass();

	public static String before_count;

	public OrderPage() {
		this.driver = BaseClass.driver;
		PageFactory.initElements(driver, this);
	}

	public void navigate_To_Order_Menu() throws Exception {
		orders_menu.click();

	}

	public void fetchordernumber() throws Exception {
		 B.getwait().until(ExpectedConditions.invisibilityOf(loadingbar));
		first_order.click();
		ordernumber=first_order_number.getText();
		System.out.println(ordernumber);

	}
	
	

	


}