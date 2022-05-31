package stepDef;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;



import org.openqa.selenium.Platform;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;



import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class StepDefinitions {
	 
	
	private HermesMethods hermesMethods;
	
	WebDriver driver;
	


	/*
	@Before
	public void SecondSD() throws MalformedURLException {
		String string = "chrome";	
		
			if(string =="firefox")
			{
			 FirefoxOptions firefoxOptions = new FirefoxOptions();
			 firefoxOptions.setCapability("browserName","firefox");
			 firefoxOptions.setCapability("platform", Platform.ANY);
			 driver = new RemoteWebDriver(new URL("https://selenium.wap-test-platform-iks-086d0feb796ce72f6b820703a879a158-0000.eu-de.containers.appdomain.cloud"),firefoxOptions);
			}
		else if (string =="chrome")
			{
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setCapability("browserName","chrome");
				chromeOptions.setCapability("platform", Platform.ANY);
				driver = new RemoteWebDriver(new URL("https://selenium.wap-test-platform-iks-086d0feb796ce72f6b820703a879a158-0000.eu-de.containers.appdomain.cloud"), chromeOptions);	
			}
		else if (string =="local")
		{
			driver = new FirefoxDriver();
		}
	}
	*/
		
	
	@Given("Que je suis sur le site")
	public void visit_site_hermes() throws MalformedURLException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Abdelrazak\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//DesiredCapabilities capa = new DesiredCapabilities(); 
		//System.setProperty("webdriver.chrome.driver","C:\\Abdelrazak\\chromedriver.exe");
		 //driver = new RemoteWebDriver(new URL(" 159.122.175.120:30723"),capa);
		//capa.setBrowserName("chrome");
		//capa.setPlatform(Platform.ANY);
		//driver = new RemoteWebDriver(new URL("https://selenium.wap-test-platform-iks-086d0feb796ce72f6b820703a879a158-0000.eu-de.containers.appdomain.cloud"), capa);
	
	
	driver.get("https://mingle-portal.eu1.inforcloudsuite.com/IBM1_DEM/dd01c7cd-9f46-418c-be0a-9e5612067c74?favoriteContext=%7B%22type%22%3A%22page%22%2C%22id%22%3A%229d2e4bf6-eb67-42e9-856c-15415d03c3e6%22%2C%22source%22%3A7%7D&LogicalId=lid://infor.homepages.1");
	}
	
	@And("Que je saisisse mes identifiants et que je me connecte")
		public void saisi_donnee() throws NoSuchAlgorithmException, NoSuchProviderException {
		hermesMethods = new HermesMethods();
		String pass = hermesMethods.Base64();
		hermesMethods.connexion(driver , pass);
		
		}
	
	
	
	@And ("Dans le menu M3 je navigue vers la page de tableau de valeur")
	public void chercher_mot() {
	driver.get("https://mingle-portal.eu1.inforcloudsuite.com/IBM1_DEM/bd13039e-19fd-43d7-82e7-1df47470691e?favoriteContext=bookmark%3FMMS001%26fieldNames%3DW1OBKV%2C%2CW2OBKV%2C%2CWFSLC2%2C%2CWTSLC2%2C%2CWFSLC3%2C%2CWTSLC3%2C%26includeStartPanel%3DTrue%26source%3DMForms%26requirePanel%3DTrue%26sortingOrder%3D2%26view%3DA02-01%26panel%3DB%26tableName%3DMITMAS%26keys%3DMMCONO%2C770%2CMMITNO%2C%2B&LogicalId=lid://infor.m3.m3");
	driver.switchTo().frame("m3h5_bd13039e-19fd-43d7-82e7-1df47470691e");
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
   
		//EventFiringWebDriver eventHand = new EventFiringWebDriver(driver);
		//eventHand.findElement(By.xpath("/html/body/lm-app/lm-page-container/div/lm-page-list/div/lm-page/div/div/div/lm-widget-container[2]/div/div[1]/button[1]")).click();
		//eventHand.findElement(By.xpath("/html/body/lm-app/lm-page-container/div/lm-page-list/div/lm-page/div/div/div/lm-widget-container[2]/div/div[1]/button[2]")).click();
		//eventHand.findElement(By.xpath("//*[@id=\"m3-menu-search\"]")).sendKeys(mot);
		//eventHand.findElement(By.xpath("//*[@id=\"m3-menu-search\"]")).sendKeys(Keys.ENTER);
		
	}
			
	@And("Je rentre les valeurs TpA = {string} et Code article = {string}")
		public void remplir_champs(String valeur1 , String valeur2) throws MalformedURLException {
		EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
		eventHandler.findElement(By.xpath("//input[@id='W1OBKV']")).sendKeys(valeur1);
			
			
			WebElement num = driver.findElement(By.xpath("//input[@id='W2OBKV']"));
			num.sendKeys(valeur2);
			num.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			num.sendKeys(Keys.chord(Keys.CONTROL,"c"));
			num.sendKeys(Keys.chord(Keys.CONTROL,"r"));
		    System.out.print(valeur1);  
		    System.out.print(valeur2);  

			
		}
	
	
	
	
	
	@And("Que je rentre dans le nouvel onglet, et que je tappe PMS170 et je clique sur le bouton OK")
	public void ongler_PMS() throws MalformedURLException {
		EventFiringWebDriver event = new EventFiringWebDriver(driver);

		 event.findElement(By.id("cmdText")).sendKeys("PMS170");
		 event.findElement(By.id("runTaskButton")).click();
			
		
		event.findElement(By.id("W1RESP")).sendKeys(Keys.chord(Keys.LEFT_SHIFT,Keys.F5));
		 
	}
	
	
	
	  @And("Que je rentre dans le champ produit : je colle la valeur2 et appuie sur le bouton Suivant")
	  public void champ_produit(){
		  EventFiringWebDriver event2 = new EventFiringWebDriver(driver);
		  event2.findElement(By.id("W1PRNO")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
	      driver.findElement(By.cssSelector(".inforFormButton.default")).click();
	  
	  }
	  
		
	  @And("Que je rempli les trois champs: numero programme {string} , date de fin et quantite planifiee {string} et je verifie les informations")
	  public void remplir_champs_valeurs(String valeur4, String valeur3) {
		  
		  driver.findElement(By.xpath("//div[@id='WEFIDTContainer']/button/span")).click();
		  driver.findElement(By.id("WEORQA")).sendKeys(valeur3);
		  driver.findElement(By.cssSelector(".inforLookupField.integerOnly.inforTextbox.numericOnly")).sendKeys(valeur4);
		  driver.findElement(By.cssSelector(".inforFormButton.default")).click();
		  driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[6]/div/div[2]/div[2]/div[1]/div/div[3]/button[2]")).click();
		  driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[6]/div/div[1]/div[2]/div[1]/div/div[3]/button[3]")).click();	 
		  }
		
		
		
		
	  
	  @And("Dans la liste deroulante Ordre de tri, je selectionne {string}")
	  	public void verification(String valeur5) {
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[6]/div/div[2]/div[2]/div[1]/div/div[1]/fieldset/div/div[1]/div[2]/input")).click();
		driver.findElement(By.cssSelector("#list-option0")).click();
		  
	  }
	  
	  @And("Je verifie que mon numero de programme est {string}")
		
		public void verification_num(String valeur4) {
		  ArrayList<String> nums= new ArrayList<String>(100);
		  
		  int i = 0;
		  
		  int count = 5;
		  for(i = 1;i <= count;i++) {
			if(i == 6 ) {
				continue;
			}
			if(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[6]/div/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/div/div[4]/div[3]/div/div["+i+"]/div[14]")).isDisplayed()){
				  String str = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[6]/div/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/div/div[4]/div[3]/div/div["+i+"]/div[14]")).getText();
						nums.add(str);
				  System.out.println(nums.get(i-1));
			  }
			
		  }
		  for (i = 1 ; i<nums.size();i++) {
			  if(nums.get(i-1) == valeur4) {
					 System.out.println("C'est bien la bonne valeur");
					 
				 } else {
					 Assert.fail("Valeur Introuvable");
				 } 
		  }
		
			/*
			hermesMethods = new HermesMethods();
			if (hermesMethods.verification(driver) == true) {
		

			  String val2 = driver.findElement(By.cssSelector(".slick-cell.l0.r0.alignRight")).getText();
			 // Assert.assertTrue(val2.contains(valeur4));
			    
			
			    if (val2.equals(valeur4)) {
				    System.out.print(val2);  
				    System.out.print("C'est La bonne valeur");  	
			    } else {
			    	
				   Assert.fail("mauvaise valeur"); 
			    }
			}
			else {
				Assert.fail("Erreur");
			}
		
				*/
		}
	
	
	
	//@After()
	//public void closeBrowser() {
		//driver.quit();
	//}

}
