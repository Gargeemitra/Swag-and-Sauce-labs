package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public Properties prop;
	public WebDriver driver;
    
	public WebDriver initializeBrowser()  {
		prop = new Properties();
		File file = new File("src\\main\\java\\resources\\data.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		if(browser.equals("Chrome")) {
			 WebDriverManager.chromedriver().setup();
		        driver = new ChromeDriver();
		}
		else if(browser.equals("Firefox")) {
			 WebDriverManager.firefoxdriver().setup();
		        driver = new FirefoxDriver();
		}
		else if(browser.equals("Edge")) {
			 WebDriverManager.edgedriver().setup();
		        driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
    
   
    
   
    
    public String takeScreenshot (String testName,WebDriver driver) throws IOException {
    	File Sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	String screenshotFilePath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
    	FileUtils.copyFile(Sourcefile, new File(screenshotFilePath));
    	return screenshotFilePath;
    }
}
