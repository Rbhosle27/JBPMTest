package com.jbpm.tests;

import com.jbpm.base.BaseTest;
import com.jbpm.pages.LoginPage;
import com.jbpm.pages.ProjectPage;
import com.jbpm.utils.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) throws InterruptedException, IOException {
        // Initialize page objects
        LoginPage loginPage = new LoginPage(driver);
        ProjectPage projectPage = new ProjectPage(driver);

        // Navigate to login page
        driver.get("http://localhost:8080/business-central/kie-wb.jsp");

        // Perform login
        loginPage.login(username, password);
        Thread.sleep(5000);

        // Add validation logic and proceed to project selection
        if (driver.getCurrentUrl().contains("kie-wb.jsp#HomePerspective")) {
            projectPage.selectAndAddProject("https://github.com/Rbhosle27/JBPM.git");
        } else {
            System.out.println("Login failed. Check your credentials.");
        }
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        String excelPath = "C:\\loginsheet.xlsx";
        String sheetName = "Login";
        ExcelUtils.setExcelFile(excelPath, sheetName);

        int rowCount = ExcelUtils.getRowCount();
        Object[][] data = new Object[rowCount - 1][2];

        for (int i = 1; i < rowCount; i++) {
            data[i - 1][0] = ExcelUtils.getCellData(i, 1);  // Username from column 1
            data[i - 1][1] = ExcelUtils.getCellData(i, 1);  // Password from column 2
          
        }

        return data;
    }
}
