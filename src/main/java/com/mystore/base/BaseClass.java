package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.config.Configurator;
import org.apache.log4j.xml.DOMConfigurator;


public class BaseClass {
	public static Properties prop;
	//public static WebDriver driver;
	
	//Declaring Thread Local for parallella execution 
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	@BeforeSuite(groups={"Smoke","Sanity","Regression"}) 
	public void loadConfig()
	{
		 ExtentManager.setExtent();
		 DOMConfigurator.configure("log4j.xml");
		 
		 try
			{
				prop = new Properties();
				System.out.println("super constructor is invoked");
				FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
				prop.load(ip);
				System.out.println("driver: "+ driver);
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
	}
	
	@AfterSuite
	public void afterSuite()
	{
		ExtentManager.endReport();
	}
	
	public static WebDriver getDriver()
	{
		//Get driver from thread local map
		return driver.get();
	}
	
//	@BeforeTest(groups={"Smoke","Sanity","Regression"}) 
//	public void loadConfig()
//	{
//		
//	}
	
//	public static void launchApp()
//	{
//       	WebDriverManager.chromedriver().setup();
//		
//		String browserName = prop.getProperty("browser");
//		
//		if(browserName.contains("Chrome"))
//		{
//			driver = new ChromeDriver();
//		}
//		else if(browserName.contains("FireFox"))
//		{
//			driver = new FirefoxDriver();
//		}
//		else if(browserName.contains("IE"))
//		{
//			driver = new InternetExplorerDriver();
//		}
//		driver.manage().window().maximize();
//		Action action = new Action();
//        action.implicitWait(driver, 15);
//        action.pageLoadTimeOut(driver, 40);
//        driver.get(prop.getProperty("url"));
//	}

	
	//for parallel execution launchApp method
	public static void launchApp(String browserName)
	{
//		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("FireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}
		getDriver().manage().window().maximize();
		Action action = new Action();
		action.implicitWait(getDriver(), 10);
		action.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(prop.getProperty("url"));
	}
	public void implicitWait(WebDriver driver, int timeOut) {
		// TODO Auto-generated method stub
		
	}

}
