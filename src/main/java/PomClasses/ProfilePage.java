package PomClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.Util1;

public class ProfilePage extends Util1{

	WebDriver driver;
	
	@FindBy(xpath="//div[@class='_1ruvv2']")
	private WebElement profileFullName;
	
	@FindBy(xpath="//div[text()='Manage Addresses']")
	private WebElement manageAddressText;
	
	@FindBy(xpath="//div[@class='_1QhEVk']")
	private WebElement addAddressBtn;
	
	@FindBy(xpath="//div[@class='_1lRtwc _1Jqgld']/input")
	private List<WebElement> addressDetails;
	
	@FindBy(xpath="//textarea")
	private WebElement address;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveAddress;
	
	@FindBy(xpath="//div[@class='_1CeZIA']")
	private List<WebElement> savedAddressCount;
	
	
	
	public ProfilePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public boolean getFullProfileName()
	{
		WebElement element = explicitWait(driver, profileFullName);
		String fullName = element.getText();
		
		if(fullName.contains("Saggy"))
		{
			return true;
		}
		
		return false;
	}
	
	public void clickmanageAddressText()
	{
		manageAddressText.click();
	}
	
	public void clickAddAddressText()
	{
		addAddressBtn.click();
	}
	
	public void fillAddressDetails()
	{
		String[] k = {"Ahirrao", "8668269296", "411045", "Shivaji Nagar"};
		
		for(int i=0; i<4; i++)
		{
			addressDetails.get(i).sendKeys(k[i]);
		}
	}
	
	public void fillMainAddress()
	{
		address.sendKeys("Shivaji Nagar, Pune");
	}
	
	public void clickOnSaveBtn() throws InterruptedException
	{
		Thread.sleep(1000);
		saveAddress.click();
	}
	
	public int savedAddressCount()
	{
		return savedAddressCount.size();
	}
	
	
	
}
