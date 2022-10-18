package StepComponent;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import PagesComponent.History;
import PagesComponent.LoginPage;
import PagesComponent.NumbersPage;
import PagesComponent.OrderPage;
import PagesComponent.Profile;
import PagesComponent.User;
//import PagesComponent.get;
//import PagesComponent.successfully;
import UtilisComponent.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
//import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
//import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tech.grasshopper.pdf.section.dashboard.Dashboard;

public class StepDefinition extends BaseClass {

	NumbersPage NP = new NumbersPage();
	LoginPage LP = new LoginPage();
	OrderPage OP = new OrderPage();
	History H = new History();
	User U = new User();
	Profile P = new Profile();

	@When("User given login credentials")
	public void login() throws Throwable {

		getwait().until(ExpectedConditions.visibilityOf(LP.username));
		LP.enter_the_credential();
	}

	@Given("User fetch the Local and toll free count from dashboard")
	public void getcount_dahboard() throws Throwable {

		LP.getcount();
	}

	@Then("User verify the Local and toll free count in Numbers module")
	public void verifycount() throws Throwable {

		getwait().until(ExpectedConditions.visibilityOf(NP.numbers_menu));
		NP.navigate_To_Number_Menu();
		getwait().until(ExpectedConditions.invisibilityOf(NP.loadingbar));
		getwait().until(ExpectedConditions.visibilityOf(NP.numbers_submenu_local));
		NP.numbers_submenu_local.click();
		getwait().until(ExpectedConditions.invisibilityOf(NP.loadingbar));
		getwait().until(ExpectedConditions.visibilityOf(NP.numbers_count));
		String actuallocal = NP.store_Numbers_Count().trim();
		Assert.assertEquals(LP.expectedlocalcount, actuallocal);
		getwait().until(ExpectedConditions.visibilityOf(NP.numbers_submenu_tollfree));
		NP.numbers_submenu_tollfree.click();
		getwait().until(ExpectedConditions.invisibilityOf(NP.loadingbar));
		getwait().until(ExpectedConditions.visibilityOf(NP.numbers_count));
		String actualtoll = NP.store_Numbers_Count().trim();
		Assert.assertEquals(LP.expectedtollcount, actualtoll);
	}

	@Then("User navigates to the main page")
	public void mainpage() throws Throwable {

		LP.click_login_button();
		getwait().until(ExpectedConditions.visibilityOf(LP.adminfield));
		LP.verify_dashboard();
	}

	@Given("User navigates to {string} module")
	public void number_menu(String module) throws Throwable {
		System.out.println(module);
		if (module.equalsIgnoreCase("Numbers")) {

			getwait().until(ExpectedConditions.visibilityOf(NP.numbers_menu));
			NP.navigate_To_Number_Menu();
		} else if (module.equalsIgnoreCase("Orders")) {

			getwait().until(ExpectedConditions.visibilityOf(OP.orders_menu));
			OP.navigate_To_Order_Menu();
		}
	}

	@When("User click the {string} module")
	public void navigateto_number_submodule(String submodule) throws Throwable {
		System.out.println(submodule);
		if (submodule.equalsIgnoreCase("Local Numbers")) {

			getwait().until(ExpectedConditions.visibilityOf(NP.numbers_submenu_local));
			NP.numbers_submenu_local.click();
		} else if (submodule.equalsIgnoreCase("Toll Free Numbers")) {

			getwait().until(ExpectedConditions.visibilityOf(NP.numbers_submenu_tollfree));
			NP.numbers_submenu_tollfree.click();
		} else if (submodule.equalsIgnoreCase("Return/Restore Numbers")) {

			getwait().until(ExpectedConditions.visibilityOf(NP.numbers_submenu_return));
			NP.numbers_submenu_return.click();
		}
	}

	@Then("User stores the numbers count")
	public void verify_store_numbers_count() throws Throwable {

		getwait().until(ExpectedConditions.visibilityOf(NP.numbers_count));
		NP.store_Numbers_Count();
	}

	@And("User click the add numbers")
	public void click_addnumbers() throws Throwable {

		getwait().until(ExpectedConditions.visibilityOf(NP.addnumber_button));
		NP.click_Addnumbers_Button();
	}

	@And("User click the search button")
	public void click_searchbutton() throws Throwable {

		NP.click_search_button();

	}

	@And("User select the number and click Buy Number button")
	public void click_buynumber() throws Throwable {

		NP.click_buy_numbers();

	}

	@And("User enter the emergency contact {string}")
	public void enter_emergencycontact(String value) throws Throwable {

		NP.emergencycontactnumber.sendKeys(value);
	}

	@And("User enter the Street number {string}")
	public void enter_streetnumber(String value) throws Throwable {

		NP.streetnumber.sendKeys(value);
	}

	@And("User enter the Street name {string}")
	public void enter_streetname(String value) throws Throwable {

		NP.streetname.sendKeys(value);
	}

	@And("User enter the city {string}")
	public void enter_city(String value) throws Throwable {

		NP.city.sendKeys(value);
	}

	@And("User enter the zipcode {string}")
	public void enter_zipcode(String value) throws Throwable {

		NP.zipcode.sendKeys(value);
	}

	@And("User select the country {string}")
	public void enter_country(String value) throws Throwable {

		NP.select_value_dropdown(NP.country, value);

	}

	@And("User select the state {string}")
	public void enter_state(String value) throws Throwable {

		NP.select_value_dropdown(NP.state, value);

	}

	@And("User click the validate button")
	public void click_validate() throws Throwable {

		NP.click_validate_button();

	}

	@Then("User click the ok button")
	public void click_ok() throws Throwable {

		NP.click_ok_button();

	}

	@And("User enter Outbound caller Name {string}")
	public void enter_outboundname(String value) throws Throwable {

		NP.enter_outbound_name(value);

	}

	@Then("User click the placeorder button")
	public void click_placeorderbutton() throws Throwable {

		NP.click_placeorder_button();
		

	}
	
	@Then("User fetch the ordered number")
	public void fetch_order_number() throws Throwable {
		System.out.println("=================================================");
		NP.get_the_orders_number();
		Thread.sleep(600000);
		

	}
	
	

	@Then("User fetch the order number")
	public void fetchorder() throws Throwable {

		OP.fetchordernumber();

	}

	@Then("User apply the filter")
	public void filter() throws Throwable {

		NP.filter_value(OP.ordernumber);

	}

	@Given("User navigates to the history screen")
	public void navigate_To_history_menu() throws Throwable {

		getwait().until(ExpectedConditions.invisibilityOf(NP.loadingbar));
		H.navigate_To_history_menu();

	}

	@When("User verify the widget title")
	public void verify_the_widget() throws Throwable {

		getwait().until(ExpectedConditions.invisibilityOf(NP.loadingbar));
		H.widget_title();

	}

	@And("User stores the history count")
	public void stores_history_count() throws Throwable {
		getwait().until(ExpectedConditions.visibilityOf(H.history_count));
		H.store_history_count();

	}

	@When("User navigates to the user screen")
	public void navigate_To_user_menu() throws Throwable {
		U.navigate_To_user_menu();

	}

	@And("User stores the user count")
	public void stores_user_count() throws Throwable {
		getwait().until(ExpectedConditions.visibilityOf(U.user_count));
		U.stores_user_count();

	}

	@And("User click the filter tab")
	public void click_filter_tab() throws Throwable {
		getwait().until(ExpectedConditions.visibilityOf(U.click_filter));
		U.click_the_filter_tab();

	}

	@And("User enter the First name {string}")
	public void enter_first_name(String value) throws Throwable {
		U.first_name.sendKeys(value);
	}

	@And("User enter the Last name {string}")
	public void enter_last_name(String value) throws Throwable {
		U.last_name.sendKeys(value);
	}

	@And("User enter the Email {string}")
	public void enter_the_email(String value) throws Throwable {
		U.enter_email.sendKeys(value);
	}

	@And("User click the Status {string}")
	public void enter_the_status(String value) throws Throwable {

		U.select_status(U.status, value);
	}

	@Then("User click the Filter button")
	public void click_filter_button() throws Throwable {

		U.click_the_filter_button();

	}
	@Given("User navigates to the profile tab")
	public void navigates_profile_tab() throws Throwable {
		P.navigate_To_profile_tab();
	
		
	}
	@When("User click the Myprofile subtab")
	public void click_myprofile_subtab() throws Throwable {
		P.click_the_myprofile_tab();
	
		
	}

	@And("User verify the Widget title {string}")
	public void verify_widget_title(String value) throws Throwable {
		P.verify_the_widget_title(value);
	}

	@Then("User click the Update button")
	public void click_the_update_button() throws Throwable {
		P.click_update_button();
	}
	@And("User get the successfully message")
	public void get_successfully_message() throws Throwable {
		P.get_the_message();
	}
	@And("User enter the current password {string}")
	public void enter_current_password(String value) throws Throwable {
		P.current_password.sendKeys(value);
	}
	@And("User enter the New password {string}")
	public void enter_new_password(String value) throws Throwable {
		P.new_password.sendKeys(value);
	}
	@And("User enter the confirm New password {string}")
	public void enter_confirm_new_password(String value) throws Throwable {
		P.confirm_new_password.sendKeys(value);
	}
	@Then("User click change password")
	public void click_change_password() throws Throwable {
		P.click_change_password();
	}
	@And("User upload the profile picture")
	public void upload_profile_picture() throws Throwable {
		P.file_upload();
	}
	@Then("User click the upload picture")
	public void click_upload_picture() throws Throwable {
		P.click_upload_picture();
	}
//	@Given("User navigates to number screen")
//	public void navigates_number_screen(String value) throws Throwable {
//	    
//	}
	  
}