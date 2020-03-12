package CommonFunctionLibrary;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.PropertyFileUtil;

public class FunctionLibrary 
{
	public static WebDriver startBrowser(WebDriver driver) throws Throwable
	{
		if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();	
	   
		}
		else
			if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("chrome"))
			{
				System.setProperty("WebDriver chrome driver","./CommonJarFiles/chromedriver.exe");
				driver=new ChromeDriver();
			}
			else
			
				if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("IE"))
				{
					driver=new InternetExplorerDriver();
				}
				else
				
					if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("safari"))
					{
						driver=new SafariDriver();
				}
	
	
		return driver;
	}
     public static void openApplication(WebDriver driver) throws Throwable 
     {
    	 driver.manage().window().maximize();
    	 driver.get(PropertyFileUtil.getValueForKey("Url"));
     }
      public static void closeApplication(WebDriver driver)
      {
    	 driver.close(); 
      }
      public static void clickAction(WebDriver driver,String locatorType,String locatorValue)
       {
    	  if(locatorType.equalsIgnoreCase("id"))
    	  {
    		  driver.findElement(By.id(locatorType)).click();
    	  }else
    		  if(locatorType.equalsIgnoreCase("name"))
    		  {
    			  driver.findElement(By.name(locatorValue)).clear();
    		  }else
    			  if(locatorType.equalsIgnoreCase("xpath"))
    			  {
    				  driver.findElement(By.xpath(locatorValue)).click();
    			  }
    	  
          }
      public static void typeAction(WebDriver driver,String locatorType,String locaorValue,String data)
      {
    	  if(locatorType.equalsIgnoreCase("id"))
    	  {
    		  driver.findElement(By.id(locaorValue)).clear();
    		  driver.findElement(By.id(locaorValue)).sendKeys(data);
    		  
    	  }else
    		  if(locatorType.equalsIgnoreCase("name"))
    		  {
    			  driver.findElement(By.name(locaorValue)).clear();
    			  driver.findElement(By.name(locaorValue)).sendKeys(data);
    			  
    		  }else
    			  if(locatorType.equalsIgnoreCase("xpath"))
    			  {
    				  driver.findElement(By.xpath(locaorValue)).clear();
        			  driver.findElement(By.xpath(locaorValue)).sendKeys(data); 
    			  }
    	  
      }
      public static void waitForElement(WebDriver driver ,String locatorType,String locatorValue,String waittime)
      {
    	  WebDriverWait wait=new WebDriverWait(driver,Integer.parseInt(waittime));
    	 if(locatorType.equalsIgnoreCase("id"))
    	 {
    		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
    		 
    	 }else
    		 if(locatorType.equalsIgnoreCase("name"))
    		 {
    			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
    		 }
    		 else
    			 if(locatorType.equalsIgnoreCase("xpath"))
    			 {
    				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
    			 }
    	  
      }
      public static String generateDate()
      {
    	  Date date=new Date();
    	  SimpleDateFormat sof=new SimpleDateFormat("YYY-mm-dd-ss");
    	  return sof.format(date);
    	  
      }
}

	
	

