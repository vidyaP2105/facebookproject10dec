package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utiles {
          
	    public static void CaptureScreenShot(WebDriver driver, int testId) throws IOException {
	    	 DateFormat dateFormat=new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
			  Date date=new Date();
			   String date1=dateFormat.format(date);
			
			   File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;
			  
			    File dest = new File("C:\\Users\\Admin\\Pictures\\Selenium\\"+date1+".jpg");
			    FileHandler.copy(src, dest);
	    }
}
