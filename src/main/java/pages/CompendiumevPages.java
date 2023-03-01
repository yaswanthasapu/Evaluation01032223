package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import seleniumActions.SeleniumActions;

public class CompendiumevPages {
    SeleniumActions seleniumActions;
    WebDriver driver;
    public CompendiumevPages(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        seleniumActions=new SeleniumActions(driver);
    }
    @FindBy(xpath = "//div[@id='cssmenu']/ul/li[2]/a[text()='Contact']")
    WebElement contact;
    @FindBy(xpath = "//input[@name='name']")
    WebElement name;
    @FindBy(xpath = "//input[@name='email']")
    WebElement email;
    @FindBy(xpath = "//textarea[@name='message']")
    WebElement message;
    @FindBy(xpath = "//div[@role='checkbox']")
    WebElement checkbox;
    @FindBy(xpath = "//div[@role='button']")
    WebElement submit;
    @FindBy(xpath = "//div[@class='Success']")
    WebElement verify;




    public void contactButton(){
        seleniumActions.clickOnElement(contact);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));
    }
    public void nameForm(){
      seleniumActions.EnterValueOnTextfield(name,"Umar");
        seleniumActions.EnterValueOnTextfield(email,"yaswanth@gmail.com");
        seleniumActions.EnterValueOnTextfield(message,"$$$$$$$$$$$$$MONEY$$$$$$$$$$$$$");
        seleniumActions.clickOnElement(checkbox);
    }
    public void submitButton(){

        seleniumActions.clickOnElement(submit);

    }
    public boolean vrification() throws InterruptedException {
        Thread.sleep(1000);
     return verify.isDisplayed();
    }

}
