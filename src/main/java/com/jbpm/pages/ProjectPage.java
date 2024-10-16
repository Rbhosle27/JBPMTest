package com.jbpm.pages;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class ProjectPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public ProjectPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Methods to interact with the project page
    public void clickProjectsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("projects"))).click();
    }

    public void clickProjectCard() {
        WebElement projectCard = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("(//h5[contains(@class, 'card-pf-contributors')])[3]")));
        projectCard.click();
    }

    public void clickAddProjectButton() {
        WebElement addProjectButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@data-field='other-projects']")));
        addProjectButton.click();
    }
 

    

    public void clickAdddropdownButton() {
    	
    	// Wait for the "Import Project" option to be visible and click it
        WebElement importProjectOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-field='link' and text()='Import Project']")));
        importProjectOption.click();
    }
    public void enterProjectName(String projectName) {
    	WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(
    		    By.xpath("//input[@data-field='repository-url']")));
    		nameField.sendKeys(projectName);

    }
    
    
  public void clickImportButton() {
	// Wait for the "Import" button to be visible and click it
	  WebElement importButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary' and text()='Import']")));
	  importButton.click();

    }
  
  public void SelectImported() {
		
	  WebElement importButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-pf-body']")));
	  importButton.click();

    }
  
  //After import click on ok btn
  public void AfterImportButton() {
		
		  WebElement importButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary' and text()='Ok']")));
		  importButton.click();

	    }
  //GOto business process
  public void BusinessProcess() {
		
	  WebElement importButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='list-group-item-text bold-font'])[2]")));
	  importButton.click();

    }
  //Located the downlaod dropdown
  public void Downlaod() {
		
	  WebElement importButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='caret'])[5]")));
	  importButton.click();

    }
  public void Selectdownlaod() {
		
	  WebElement importButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Download as BPMN']")));
	  importButton.click();

    }
  
  //Deploy the process
  public void Deploy() {
		
	  WebElement deploy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deploy")));
	  deploy.click();

    }
  //Goto the menu section
  public void Menu() {
		
	  WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='mega-menu-dropdown']")));
	  menu.click();

    }
  //Goto the process instance
  public void ProcessInstance() {
		
	  WebElement process = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Process Instances']")));
	  process.click();

    }
  //Goto the Tasks 
  public void Task() throws InterruptedException {
		
	 
	  WebElement task = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Collect Loan Application Details.'])[1]")));
	  task.click();
	   }
//Assuming 'driver' is already initialized
  public void newProcessInstanceButton() {
WebElement newProcessInstanceButton = driver.findElement(By.xpath("//button[text()='New Process Instance']"));
newProcessInstanceButton.click();
  }
  
  public void Start() {
WebElement startButton = driver.findElement(By.xpath("//button[contains(@class, 'btn-primary') and contains(., 'Start')]"));
startButton.click();
  }
  
  public void Start1() {
	  WebElement startButton = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]"));
	  startButton.click();
	    }
  
  public void CMt() {
	  WebElement startButton = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]"));
	  startButton.click();
	    }
//  public void inputfields()
//  {
//	  WebElement creditScoreField = driver.findElement(By.id("gwt-uid-226")); // Adjust locator
//      WebElement loanAmountField = driver.findElement(By.id("gwt-uid-227"));   // Adjust locator
//      WebElement locationField = driver.findElement(By.id("gwt-uid-228"));       // Adjust locator
//
//      creditScoreField.clear();
//      creditScoreField.sendKeys("755");
//
//      loanAmountField.clear();
//      loanAmountField.sendKeys("1400");
//
//      locationField.clear();
//      locationField.sendKeys("Pune");
//
//      // Submit the form
//      WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']")); // Adjust locator
//      submitButton.click();
//  }

  public void fields() throws IOException, InterruptedException
  {
	  String excelFilePath = "C:\\cre.xlsx"; // Excel file path
      String sheetName = "Login"; // Sheet name

      FileInputStream fis = new FileInputStream(excelFilePath);
      XSSFWorkbook workbook = new XSSFWorkbook(fis);

      Sheet sheet = workbook.getSheet(sheetName); // Get the specified sheet by name
      Row row = sheet.getRow(1); // Get the second row (0-indexed)

      if (row != null) {
          // Fetch data from the first three cells
      	String input1 = getCellValueAsString(row.getCell(0));
          String input2 = getCellValueAsString(row.getCell(1));
          String input3 = getCellValueAsString(row.getCell(2));

      

          WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
          WebElement creditScoreField = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='CreditScore']")));
          WebElement loanAmountField = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='LoanAmount']")));
          WebElement locationField = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Location']")));
          creditScoreField.sendKeys(input1);
          loanAmountField.sendKeys(input2);
          locationField.sendKeys(input3);
          
          // Additional logic can be added here
      } else {
          System.out.println("Row is null. Please check the Excel file.");
      }

      // Close resources
      workbook.close();
      fis.close();
      
      // Close the browser
      driver.findElement(By.xpath("//button[text()='Submit']")).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath("//a[@id='mega-menu-dropdown']")).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath("//a[text()='Tasks']")).click();
      
      
      
  }
  private static String getCellValueAsString(Cell cell) {
      if (cell == null) {
          return "";
      }
      switch (cell.getCellType()) {
          case STRING:
              return cell.getStringCellValue();
          case NUMERIC:
              return String.valueOf(cell.getNumericCellValue());
          case BOOLEAN:
              return String.valueOf(cell.getBooleanCellValue());
          case FORMULA:
              return cell.getCellFormula();
          default:
              return "";
      }
  }
   public void switchToWindowWithUrl(String partialUrl) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            String currentUrl = driver.switchTo().window(handle).getCurrentUrl();
            if (currentUrl.contains(partialUrl)) {
                break;
            }
        }
    }

    // Perform project selection and add project
    public void selectAndAddProject(String projectName) throws InterruptedException, IOException {
        Thread.sleep(6000);
    	switchToWindowWithUrl("kie-wb.jsp#HomePerspective");
        clickProjectsLink();
        switchToWindowWithUrl("kie-wb.jsp#LibraryPerspective");
        clickProjectCard();
        switchToWindowWithUrl("kie-wb.jsp#LibraryPerspective%7C$LibraryScreen");
        clickAddProjectButton();
        Thread.sleep(4000);
        clickAdddropdownButton();
        Thread.sleep(4000);
        enterProjectName(projectName);
        clickImportButton();
        Thread.sleep(4000);
        SelectImported();
        AfterImportButton();
        Thread.sleep(6000);
//        BusinessProcess();
//        Thread.sleep(3000);
//        Downlaod();
//        Thread.sleep(3000);
//        Selectdownlaod();
        Deploy();
        Thread.sleep(8000);
        Menu();
        Thread.sleep(2000);
        ProcessInstance();
        Thread.sleep(3000);
        newProcessInstanceButton();
        Thread.sleep(3000);
        Start();
        Thread.sleep(4000);
       fields();
        Thread.sleep(4000);
       
        Task();
        Thread.sleep(5000);
        switchToWindowWithUrl("http://localhost:8080/business-central/kie-wb.jsp#TaskAdmin%7CTaskAdminListScreen%5BWTaskAdminListBasicFiltersScreen,%5D$TaskDetailsScreen");
        Start1();
        Thread.sleep(5000);
        CMt();
        Thread.sleep(4000);
        driver.quit();
    }
    
}
