
package StepComponent;

import UtilisComponent.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass{
	
	
	@Before
	public void landingpage() throws Throwable {
		setdriver("chrome");
		launchurl(getpropvalue("URL"));
	}
	
	@After
	public void afterhooks() throws Throwable {
		driver.quit();
	}



}
