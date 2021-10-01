package com.ken.runner;



import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\ken\\feature\\ama .feature",glue="com.ken.stepdefiniton", dryRun = false)
public class Ken_Runner {

	public static WebDriver driver;
	@BeforeClass
	public static void set_Up() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\Madhan Course\\Esclipe\\CucumberData\\Driver\\chromedriver.exe");
		driver= new ChromeDriver();
	
	}
	@AfterClass
	public static void tear_Down() {
		driver.close();
	}
	
	
}
 