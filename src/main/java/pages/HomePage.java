package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
		
	       @FindBy (xpath = "//a[@title='Take a look at Messenger.']")
	        private WebElement MessengerPage;


           


			public  HomePage (WebDriver driver)
				{
					PageFactory.initElements(driver, this);
				}
				
				public void OpenHomepage() {
					MessengerPage.click();
					
					
				}
				}



