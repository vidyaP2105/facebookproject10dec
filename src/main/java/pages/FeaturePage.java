package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeaturePage

{
 
	
	        @FindBy (xpath = "(//a[@class='_4vo5'])[1]")
	        private WebElement FeaturesPage;
	        
	        
	        public FeaturePage (WebDriver driver)
	        {
	        	PageFactory.initElements(driver, this);
	        }
	        
	        public void OpenFeaturePage()
	        {
	        	FeaturesPage.click();
	        }
}
