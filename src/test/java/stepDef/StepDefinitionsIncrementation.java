
package stepDef;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;

public class StepDefinitionsIncrementation {

	private HermesMethods hermesMethods;
	
	WebDriver driver;
	WebDriver driver1;
	 
	
	
	
	
	@Given("Je navigue sur le site Hermes en rentrant les valeurs Tpa:{string} et Code article:{string}") 
	public void naviguation_site_hermes(String valeur1 , String valeur2) {
		hermesMethods = new HermesMethods();
		WebDriver driver = hermesMethods.Naviguation_Site_Hermes(valeur1, valeur2);
		hermesMethods.setDriver(driver);
		driver1 = hermesMethods.getDriver();
		
		
	}
	
	@And("Appuie sur la fleche pour acceder au tableau de valeur")
	public void appuie_fleche() {
		
		driver1.findElement(By.xpath("//*[@id=\"WESCHNContainer\"]/button")).click();
		
		
		
		
	}
	
	
	@And("appuyer sur utiliser")
	public void appuyer() {
		driver1.findElement(By.id("BTN_L2T24")).click();

	}
	
	@And("selectioner la valeur a supprimer {string} et appuyer sur SUPPR+ENTRER")
	public void valeur_a_supprimer(String valeur) {
		
		WebElement suppr = driver1.findElement(By.xpath("//*[@id=\"R14\"]/div[1]"));
		suppr.click();
		suppr.sendKeys(Keys.DELETE);
		WebElement apply = driver1.findElement(By.cssSelector("#WDSCHN"));
		apply.sendKeys(Keys.ENTER);
		
		//hermesMethods = new HermesMethods();
	    //hermesMethods.create_Array(driver1);
		/*
		for(int i = 0 ; i<Array.getLength(enteredValue);i++) {
			if(enteredValue.get(i) == valeur) {
				
				WebElement suppr = driver1.findElement(By.xpath("//*[@id=\"R12\"]/div[1]"));
				suppr.click();
				suppr.sendKeys(Keys.DELETE);
				WebElement apply = driver1.findElement(By.cssSelector("#WDSCHN"));
				apply.sendKeys(Keys.ENTER);
			}
		}
		*/
		
		
	}
	
	
	//@And("revenir a la page de depart")
	//public void appuyer_touches() {
		//WebElement back = driver1.findElement(By.id("Prev"));

		//back.sendKeys(Keys.F12);
		
	//}
	
	
}
