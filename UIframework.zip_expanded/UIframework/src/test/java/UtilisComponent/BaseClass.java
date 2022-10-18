package UtilisComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static JSONObject dataobject;
	public static WebDriver wait;
	public static WebDriver driver;
	public static WebElement findElement;

	public static void setdriver(String browsername) {

		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public static WebDriver getdriver() {
		return driver;
	}

	public static boolean launchurl(String url) {
		boolean flag = false;
		try {
			driver.get(url);
			flag = true;
		} catch (Exception e) {
			System.out.println("Error in Launchurl : " + e.getMessage());
		}
		return flag;

	}

	public static WebDriverWait getwait() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait;

	}

	public static String getpropvalue(String key) {
		String value = null;
		try {
			String Userdirectory = System.getProperty("user.dir");
			Properties prop = new Properties();
			FileInputStream ip = new FileInputStream(Userdirectory + "//config.properties");
			prop.load(ip);
			value = prop.getProperty(key);
			ip.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void setjsonfile(String filepath) throws Exception {
		try {
			System.out.println(filepath);
			JSONParser parser = new JSONParser();

			JSONObject myobj = (JSONObject) parser
					.parse(new InputStreamReader(new FileInputStream(new File(filepath))));
			dataobject = (JSONObject) myobj.get("data");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getData(String key) throws Exception {
		try {
			setjsonfile(System.getProperty("user.dir") + "/Testdata.json");
			return dataobject.get(key).toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(key + " not found");
		}
	}

	public static String gettext(WebElement element) throws Exception {
		String Output = null;
		try {
			Output = element.getText();
		} catch (Exception e) {
			System.out.println("Error in gettext reusuable method" + e.getMessage());
		}
		return Output;
	}
	public static boolean isTextPresent(String text){
	    try{
	        boolean b = driver.getPageSource().contains(text);
	        return b;
	    }
	    catch(Exception e){
	        return false;
	    }
	  }
	

}
