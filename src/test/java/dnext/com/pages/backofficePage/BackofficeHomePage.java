package dnext.com.pages.backofficePage;

import com.utilities.Driver;
import com.utilities.Utils;
import dnext.com.pages.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

 public  class BackofficeHomePage extends BasePage {

    @FindBy(xpath = "//mat-icon[normalize-space()='more_vert']")
     public WebElement threeDotsOnOpenedPageAfterClickingNameOfCustomer;

    @FindBy(xpath = "//span[text()='ClaimEdit']/parent::button")
     static public WebElement claimEditButton;

     @FindBy(xpath = "//*[contains(text(), 'Corporate Confirmation')]")
     public WebElement corporateConfirmationTextOnCorporateConfirmationPage;

     @FindBy(xpath = "//mat-form-field//*[starts-with(@class,'mat-form-field-outline ')]")
     public WebElement isApprovedDropdownButtonOnCorporateConfirmationPage;

     @FindBy(xpath = "//span[text()='Complete Task']/ancestor::button")
     public WebElement completeTaskButtonOnCorporateConfirmationPage;

     @FindBy(xpath = "//p[normalize-space()='Task Completed']")
     public WebElement taskCompletedPopUpMessageOnCorporateConfirmationPage;

     @FindBy(xpath = "/html/body/app/vertical-layout-1/div/div/div/div/content/app-tasks/app-page-view/div/div[2]/div[2]/div[2]/div[1]/div[1]/app-task-list-item/div/div/div/div[1]/div[1]/span")
     public WebElement customerTaskABC;


     public void openingBackOfficeInNewTab(){
         ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('https://backoffice-ui.uat.dnext.al.vodafone.com/orders/my-group-tasks')");
         Utils.waitFor(5);
         //Driver.getDriver().switchTo().newWindow(WindowType.TAB);
         //Driver.getDriver().get("https://backoffice-ui.uat.dnext.al.vodafone.com/orders/my-group-tasks");
     }

     /***
      *  @And("User should see the name of {string}progressed customer on BackOffice page")
      *     public void userShouldSeeTheNameOfProgressedCustomerOnBackOfficePage(String nameOfCustomer) {
      *         Utils.waitForVisibility(backofficeHomePage.nameOfCustomerOnMyGroupTasks,15);
      *         warningMessage(nameOfCustomer, backofficeHomePage.nameOfCustomerOnMyGroupTasks);
      *     }
      *
      *     @And("User clicks the name of customer  on BackOffice page")
      *     public void userClicksTheNameOfCustomerOnBackOfficePage() {
      *         clickField(backofficeHomePage.nameOfCustomerOnMyGroupTasks);
      *     }
      *
      * */
     public void verifyTheNameOfCustomer(String customerName){
         //Utils.waitForVisibility(customerTaskABC,15);
         //warningMessage(customerName, customerTaskABC);
         String xpathOfTask = "(//span[@class='user-name' and text()='" + customerName + "'])[1]";
         Utils.waitForPageToLoad();
         Utils.waitForVisibility(By.xpath(xpathOfTask), 15);
         WebElement customerNameOfTask = Driver.getDriver().findElement(By.xpath(xpathOfTask));
         Assert.assertEquals(customerName, customerNameOfTask.getText());
     }

     public void clickTheNameOfCustomer(String customerName){
        /* WebElement splashScreen = Driver.getDriver().findElement(By.id("fuse-splash-screen"));
         Driver.getDriver().switchTo().frame(splashScreen);*/
         String xpathOfTask = "(//span[@class='user-name' and text()='" + customerName + "'])[1]";
         WebElement customerNameOfTask = Driver.getDriver().findElement(By.xpath(xpathOfTask));
         customerNameOfTask.click();
     }

     public void claimEditButtonUsage(){
         Utils.clickWithJS(claimEditButton);
         Utils.waitFor(5);
         System.out.println("Driver.getDriver().getWindowHandles().size() = " + Driver.getDriver().getWindowHandles().size());
         switchToWindowNew(2);
     }

     public void assertionOfBackOfficePage(String text){
         System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());
         warningMessage(text, corporateConfirmationTextOnCorporateConfirmationPage);
     }

     public void selectApproveOption(String option){
         String xpathOfOption = "//span[text()='" + option + "']/parent::mat-option";
         Utils.waitForVisibility(By.xpath(xpathOfOption), 15);
         WebElement approvedOption = Driver.getDriver().findElement(By.xpath(xpathOfOption));
         clickField(approvedOption);
     }

     private void switchToDnextFromBackOffice() {
         switchToWindowNew(0);
         System.out.println("moved to Dnext succesfully!!");
     }
     public void turningBackToCustomerManagementPage(){
         Utils.waitFor(30);
         Driver.getDriver().navigate().refresh();
         switchToDnextFromBackOffice();
     }

}
