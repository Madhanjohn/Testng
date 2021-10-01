package com.ken.stepdefiniton;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.ken.runner.Ken_Runner;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step_Definition {
	
	public static WebDriver driver =Ken_Runner.driver;
	Scenario scenario;
	
	@Before
	public void setUp(Scenario s) {
		scenario = s;
	}
	
	@Given("^Launch the Website \"([^\"]*)\"$")
	public void launch_the_Website(String arg1) throws Throwable {
		
	    driver.get(arg1);
	    scenario.write("Open the browser with URL" +arg1 );
	    System.out.println("ama");
	}
	
	@When("^User enter item name in Search Option$")
	public void user_enter_item_name_in_Search_Option() throws Throwable {
		Thread.sleep(3000);
			File f = new File("C:\\Users\\PC\\Desktop\\Madhan Course\\Esclipe\\CucumberData\\rawdata.xlsx");
			FileInputStream fis =  new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheetAt = wb.getSheetAt(0);
			Row row = sheetAt.getRow(0);
			Cell cell = row.getCell(0);
			CellType cellType = cell.getCellType();
			
			if (cellType.equals(cellType.STRING)) {
				String stringCellValue = cell.getStringCellValue();
				Thread.sleep(3000);
				driver.findElement(By.id("twotabsearchtextbox")).sendKeys(stringCellValue);
				Thread.sleep(3000);
				//System.out.println(stringCellValue);
			}
			else if (cellType.equals(CellType.NUMERIC)) {
				double numericCellValue = cell.getNumericCellValue();
				int value = (int) numericCellValue;
				System.out.println(value);
				
			}
	//	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("kids toys");
	}
	

	@Then("^Open the option mentioned in search$")
	public void open_the_option_mentioned_in_search() throws Throwable {
	//	System.out.println("sussessful");
	}
	
	@Given("^Launch the website \"([^\"]*)\"$")
	public void launch_the_website(String arg1) throws Throwable {
		
	    driver.get(arg1);
	    scenario.write("Open the browser with URL" +arg1 );
	    System.out.println("ken");
	}

	
	
	

}
