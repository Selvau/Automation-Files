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

public class NumbersPage {

	public WebDriver driver;

	@FindBy(xpath = "//*[@id=\"side-menu\"]/li[3]/a/span")
	public WebElement numbers_menu;

	@FindBy(xpath = "//a[text()=' Local Numbers']")
	public WebElement numbers_submenu_local;

	@FindBy(xpath = "//a[text()='Toll Free Numbers']")
	public WebElement numbers_submenu_tollfree;

	@FindBy(xpath = "//a[text()='Return/Restore Numbers']")
	public WebElement numbers_submenu_return;

	@FindBy(xpath = "//*[@id='page-wrapper']/div/div[1]/div/div[1]/p/span")
	public WebElement numbers_count;

	@FindBy(xpath = "//ngx-loading-bar//div")
	public WebElement loadingbar;

	@FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div[1]/div/div[2]/button")
	public WebElement addnumber_button;

	@FindBy(xpath = "//a[text()=' Local Numbers']")
	public WebElement Localnumber_tab;

	@FindBy(xpath = "//a[text()='Toll Free Numbers']")
	public WebElement Tollfree_tab;

	@FindBy(xpath = "//a[text()='Return/Restore Numbers']")
	public WebElement Return_tab;

	@FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div[1]/form/div[3]/div/div/div[5]/button")
	public WebElement Search_button;

	@FindBy(xpath = "(//div[@class='checkbox'])[2]")
	public WebElement first_checkbox;

	@FindBy(xpath = "//*[@id=\"home\"]/div[1]/div[2]/div/button")
	public WebElement Buynumber_button;

	@FindBy(xpath = "//*[@id=\"collapseOne\"]/div/div[1]/div/label/span")
	public WebElement enable_button;

	@FindBy(xpath = "//*[@id=\"collapseOne\"]/div/div[2]/div[1]/div[1]/input")
	public WebElement emergencycontactnumber;

	@FindBy(xpath = "//select[@formcontrolname='country']")
	public WebElement country;

	@FindBy(xpath = "//*[@id=\"collapseOne\"]/div/div[2]/div[1]/div[2]/input")
	public WebElement streetnumber;

	@FindBy(xpath = "//*[@id=\"collapseOne\"]/div/div[2]/div[2]/div[2]/input")
	public WebElement streetname;

	@FindBy(xpath = "//*[@id=\"collapseOne\"]/div/div[2]/div[1]/div[3]/input")
	public WebElement location;

	@FindBy(xpath = "//*[@id=\"collapseOne\"]/div/div[2]/div[2]/div[3]/div[1]/input")
	public WebElement city;

	@FindBy(xpath = "//select[@formcontrolname='origState']")
	public WebElement state;

	@FindBy(xpath = "//*[@id=\"collapseOne\"]/div/div[2]/div[2]/div[3]/div[3]/input")
	public WebElement zipcode;

	@FindBy(xpath = "//*[@id=\"collapseOne\"]/div/div[3]/div/button[1]")
	public WebElement validatebutton;
	
	@FindBy(xpath = "//*[@id=\"addressConfirmation\"]/div/div/div[3]/button[1]")
	public WebElement okbutton;

	@FindBy(xpath = "//*[@id=\"headingTwo\"]/h2/button")
	public WebElement outboundmenu;

	@FindBy(xpath = "//*[@id=\"collapseTwo\"]/div/div[1]/div/label/span")
	public WebElement outbound_enable;

	@FindBy(xpath = "//*[@id=\"collapseTwo\"]/div/div[2]/div/div/input")
	public WebElement outbound_name;

	@FindBy(xpath = "//*[@id=\"myTabContent\"]/div[3]/form/div[2]/div[2]/button")
	public WebElement placeorderbutton;
	
	@FindBy(xpath = "//div[@role='alertdialog']")
	public WebElement get_message;

	@FindBy(xpath = "//*[@id=\"home\"]/div[1]/div[2]/div/div[2]/button")
	public WebElement filterbutton;

	@FindBy(xpath = "//*[@id=\"home\"]/div[1]/div[2]/div/div[2]/div/form/div/div[1]/div[1]/div/input")
	public WebElement numberfilter;

	@FindBy(xpath = "//*[@id=\"home\"]/div[1]/div[2]/div/div[2]/div/form/div/div[3]/div/button[1]")
	public WebElement searchbutton;

	BaseClass B = new BaseClass();

	public static String before_count;
	
	public static String currentordernumber=null;

	public NumbersPage() {
		this.driver = BaseClass.driver;
		PageFactory.initElements(driver, this);
	}

	public void navigate_To_Number_Menu() throws Exception {
		numbers_menu.click();

	}

	public String store_Numbers_Count() throws Exception {
		B.getwait().until(ExpectedConditions.invisibilityOf(loadingbar));
		before_count = numbers_count.getText();
		System.out.println("Count : " + before_count);
		return before_count;

	}

	public void click_Addnumbers_Button() throws Exception {
		addnumber_button.click();
	}

	public void click_search_button() throws Exception {
		B.getwait().until(ExpectedConditions.invisibilityOf(loadingbar));
		Search_button.click();
	}

	public void click_buy_numbers() throws Exception {
		first_checkbox.click();
		Buynumber_button.click();
		B.getwait().until(ExpectedConditions.invisibilityOf(loadingbar));
		enable_button.click();
		Thread.sleep(2000);
	}

	public void select_value_dropdown(WebElement element, String Value) throws Exception {
		Select sc = new Select(element);
		sc.selectByValue(Value);

	}

	public void click_validate_button() throws Exception {
		B.getwait().until(ExpectedConditions.invisibilityOf(loadingbar));
		validatebutton.click();

	}
	public void click_ok_button() throws Exception {
		B.getwait().until(ExpectedConditions.invisibilityOf(loadingbar));
		okbutton.click();

	}

	public void enter_outbound_name(String Value) throws Exception {
		outboundmenu.click();
		B.getwait().until(ExpectedConditions.visibilityOf(outbound_enable));
		outbound_enable.click();
		outbound_name.sendKeys(Value);
	}

	public void click_placeorder_button() throws Exception {
		placeorderbutton.click();

	}

	public void filter_value(String Value) throws Exception {
		filterbutton.click();
		numberfilter.sendKeys(Value);
		searchbutton.click();
	}
	public void get_the_orders_number() throws Exception {
		B.getwait().until(ExpectedConditions.visibilityOf(get_message));
		String actual = get_message.getText().trim();
		currentordernumber=actual.substring(actual.indexOf("[")+1,actual.indexOf("]"));
		System.out.println(currentordernumber);
		
		}
	
}