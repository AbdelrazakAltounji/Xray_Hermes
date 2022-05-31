package stepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class erreurConnexion {
private HermesMethods hermesMethods;
	
	WebDriver driver;
	
	@Given("Je navigue vers le site Hermes")
	public void naviguer_sur_site() {
		System.setProperty("webdriver.chrome.driver","C:\\Abdelrazak\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://mingle-portal.eu1.inforcloudsuite.com/IBM1_DEM/dd01c7cd-9f46-418c-be0a-9e5612067c74?favoriteContext=%7B%22type%22%3A%22page%22%2C%22id%22%3A%229d2e4bf6-eb67-42e9-856c-15415d03c3e6%22%2C%22source%22%3A7%7D&LogicalId=lid://infor.homepages.1");

	}
	
	@And("Je rentre mon identifiant et le mot de passe {string}")
	public void entrer_identifiants(String pass) {
		hermesMethods = new HermesMethods();
		String fauxmotpasse = hermesMethods.Base64_id(pass);
		String vraimotpasse = hermesMethods.Base64();
		hermesMethods.connexion_err(driver , fauxmotpasse,vraimotpasse);
		
	}
	
	
}
