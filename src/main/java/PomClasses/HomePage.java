package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.Util1;

public class HomePage extends Util1{
	
WebDriver driver;
	
	//HomePage
	@FindBy(xpath="//div[text()='Saggy']")
	private WebElement profileName;
	
	@FindBy(xpath="(//li[@class='_2NOVgj'])[1]")
	private WebElement myProfileText;
	
	
	
	

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public boolean getProfileName() throws InterruptedException{
		Thread.sleep(1000);
		explicitWait(driver, profileName);
		String pName = profileName.getText();
		
		if(pName.equals("Saggy"))
		{
			return true;
		}
		return false;	
	}

	public void moveToProfileName(){
		moveToElement(driver, profileName);
	}
	
	public void clickOnProfileText(){
		WebElement element = explicitWait(driver, myProfileText);
		element.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
