package stepDef;


import static org.junit.Assert.fail;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

public class HermesMethods {

	WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver newDriver) {
		this.driver=newDriver;
	}
	
	public void connexion(WebDriver driver, String password) {
		
			
			WebElement first = driver.findElement(By.id("username"));
			WebElement pass = driver.findElement(By.id("pass"));
			
			first.sendKeys("andrea.gamba@fr.ibm.com");
			pass.sendKeys(password);
			driver.findElement(By.className("ping-buttons")).click();	
	
			}

	public void connexion_err(WebDriver driver, String fauxmotdepasse, String vraimotdepasse) {
		
		
		WebElement first = driver.findElement(By.id("username"));
		WebElement pass = driver.findElement(By.id("pass"));
		first.sendKeys("andrea.gamba@fr.ibm.com");
		pass.sendKeys(fauxmotdepasse);
		if(fauxmotdepasse == vraimotdepasse) {
		
		
		driver.findElement(By.className("ping-buttons")).click();	
		}else {
			Assert.fail("Mot de passe incorrecte");
		}
		}

	
	public Boolean verification(WebDriver driver) {
		
		try {
			driver.findElement(By.cssSelector(".slick-cell.l0.r0.alignRight"));
		    System.out.println("Element Found");
		    return true;
		} catch (NoSuchElementException e) {
		    System.out.println("Element Not Found");
		   Assert.fail(); 
		    return false;
		}
	}
	public String Base64() {
		
		Encoder encoder = Base64.getEncoder();
		String originalString = "TestAuto22$";
		String encodedString=encoder.encodeToString(originalString.getBytes());
		System.out.println("Le mot de pass Encrypter : " +encodedString);
		Decoder decoder = Base64.getDecoder();
		byte[] bytes=decoder.decode(encodedString);
		String decodedString = new String(bytes);
		return decodedString;
	}
	
public String Base64_id(String motdepasse) {
		
		Encoder encoder = Base64.getEncoder();
		String originalString = motdepasse;
		String encodedString=encoder.encodeToString(originalString.getBytes());
		System.out.println("Le mot de pass Encrypter :: " +encodedString);
		Decoder decoder = Base64.getDecoder();
		byte[] bytes=decoder.decode(encodedString);
		String decodedString = new String(bytes);
		System.out.println(decodedString);
		return decodedString;
	}
	
	
	
	public String decryptage(String hashedPass) {
		byte[] decodedBytes = Base64.getDecoder().decode(hashedPass);
		String decodedString = new String(decodedBytes);
		return decodedString;
	}
	
	public WebDriver Naviguation_Site_Hermes(String valeur1,String valeur2) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Abdelrazak\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://mingle-portal.eu1.inforcloudsuite.com/IBM1_DEM/dd01c7cd-9f46-418c-be0a-9e5612067c74?favoriteContext=%7B%22type%22%3A%22page%22%2C%22id%22%3A%229d2e4bf6-eb67-42e9-856c-15415d03c3e6%22%2C%22source%22%3A7%7D&LogicalId=lid://infor.homepages.1");
		
		String pass = Base64();
		connexion(driver , pass);
		
		driver.get("https://mingle-portal.eu1.inforcloudsuite.com/IBM1_DEM/bd13039e-19fd-43d7-82e7-1df47470691e?favoriteContext=bookmark%3FMMS001%26fieldNames%3DW1OBKV%2C%2CW2OBKV%2C%2CWFSLC2%2C%2CWTSLC2%2C%2CWFSLC3%2C%2CWTSLC3%2C%26includeStartPanel%3DTrue%26source%3DMForms%26requirePanel%3DTrue%26sortingOrder%3D2%26view%3DA02-01%26panel%3DB%26tableName%3DMITMAS%26keys%3DMMCONO%2C770%2CMMITNO%2C%2B&LogicalId=lid://infor.m3.m3");
		driver.switchTo().frame("m3h5_bd13039e-19fd-43d7-82e7-1df47470691e");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
		eventHandler.findElement(By.xpath("//input[@id='W1OBKV']")).sendKeys(valeur1);
		WebElement num = driver.findElement(By.xpath("//input[@id='W2OBKV']"));
		num.sendKeys(valeur2);
		num.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		num.sendKeys(Keys.chord(Keys.CONTROL,"c"));
		num.sendKeys(Keys.chord(Keys.CONTROL,"r"));
	    
		EventFiringWebDriver event = new EventFiringWebDriver(driver);
		event.findElement(By.id("cmdText")).sendKeys("PMS170");
		event.findElement(By.id("runTaskButton")).click();
		event.findElement(By.id("W1RESP")).sendKeys(Keys.chord(Keys.LEFT_SHIFT,Keys.F5));
		
		EventFiringWebDriver event2 = new EventFiringWebDriver(driver);
		event2.findElement(By.id("W1PRNO")).sendKeys(Keys.chord(Keys.CONTROL,"v"));  
		driver.findElement(By.cssSelector(".inforFormButton.default")).click();
		
		return driver;
		
		 

		
	   
		
		
	}
	
	public WebDriver Naviguation_Site_Hermes_Remote(String valeur1,String valeur2) throws MalformedURLException {
	DesiredCapabilities capa = new DesiredCapabilities(); 
	capa.setBrowserName("chrome");
	capa.setPlatform(Platform.ANY);
	driver = new RemoteWebDriver(new URL("https://selenium.wap-test-platform-iks-086d0feb796ce72f6b820703a879a158-0000.eu-de.containers.appdomain.cloud"), capa);
	
	driver.get("https://mingle-portal.eu1.inforcloudsuite.com/IBM1_DEM/dd01c7cd-9f46-418c-be0a-9e5612067c74?favoriteContext=%7B%22type%22%3A%22page%22%2C%22id%22%3A%229d2e4bf6-eb67-42e9-856c-15415d03c3e6%22%2C%22source%22%3A7%7D&LogicalId=lid://infor.homepages.1");
	
	String pass = Base64();
	connexion(driver , pass);
	
	driver.get("https://mingle-portal.eu1.inforcloudsuite.com/IBM1_DEM/bd13039e-19fd-43d7-82e7-1df47470691e?favoriteContext=bookmark%3FMMS001%26fieldNames%3DW1OBKV%2C%2CW2OBKV%2C%2CWFSLC2%2C%2CWTSLC2%2C%2CWFSLC3%2C%2CWTSLC3%2C%26includeStartPanel%3DTrue%26source%3DMForms%26requirePanel%3DTrue%26sortingOrder%3D2%26view%3DA02-01%26panel%3DB%26tableName%3DMITMAS%26keys%3DMMCONO%2C770%2CMMITNO%2C%2B&LogicalId=lid://infor.m3.m3");
	driver.switchTo().frame("m3h5_bd13039e-19fd-43d7-82e7-1df47470691e");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
	eventHandler.findElement(By.xpath("//input[@id='W1OBKV']")).sendKeys(valeur1);
	WebElement num = driver.findElement(By.xpath("//input[@id='W2OBKV']"));
	num.sendKeys(valeur2);
	num.sendKeys(Keys.chord(Keys.CONTROL,"a"));
	num.sendKeys(Keys.chord(Keys.CONTROL,"c"));
	num.sendKeys(Keys.chord(Keys.CONTROL,"r"));
    
	EventFiringWebDriver event = new EventFiringWebDriver(driver);
	event.findElement(By.id("cmdText")).sendKeys("PMS170");
	event.findElement(By.id("runTaskButton")).click();
	event.findElement(By.id("W1RESP")).sendKeys(Keys.chord(Keys.LEFT_SHIFT,Keys.F5));
	
	EventFiringWebDriver event2 = new EventFiringWebDriver(driver);
	event2.findElement(By.id("W1PRNO")).sendKeys(Keys.chord(Keys.CONTROL,"v"));  
	driver.findElement(By.cssSelector(".inforFormButton.default")).click();
	return driver;
	}
	
	
	public ArrayList<String> create_Array(WebDriver driver) {
		
		
		ArrayList<String> nums= new ArrayList<String>();
		
		
		
		for(int i =1;i<20;i++) {
			
			if(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[6]/div/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/div/div[4]/div[3]/div/div["+i+"]/div[1]")).isDisplayed());
			{
				String str2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[6]/div/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/div/div[4]/div[3]/div/div["+i+"]/div[1]")).getText();

				nums.add(str2); 
			    System.out.println(nums.get(i-1));
			} 
		    
			
		   
		    
		    
		   // System.out.println(str3);
		  
		}
		 System.out.println(nums);
	
		
			
		
		return nums;
		
		/*
		
		
		
		if(str == valeur) {
			suppr.click();
			suppr.sendKeys(Keys.DELETE);
			WebElement apply = driver.findElement(By.cssSelector("#WDSCHN"));
			apply.sendKeys(Keys.ENTER);
			
		}
		*/
		
		/*
		WebElement suppr = driver. findElement(By.xpath("//*[@id=\"R11\"]/div[1]"));
		suppr.click();
		suppr.sendKeys(Keys.DELETE);
		WebElement apply = driver.findElement(By.cssSelector("#WDSCHN"));
		apply.sendKeys(Keys.ENTER);
		
		//WebElement back = driver.findElement(By.xpath("//*[@id=\"W1OBKV\"]"));
		suppr.findElement(By.xpath("//*[@id=\\\"R9\\\"]/div[1]")).sendKeys(Keys.F12);
		*/
	}
	
}
