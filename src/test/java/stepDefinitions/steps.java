package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.CompendiumevPages;
import seleniumActions.SeleniumActions;

public class steps {
    WebDriver driver;
    SeleniumActions seleniumActions;
    CompendiumevPages compendiumevPages;
    @Before
    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }


    @Given("launching the browser")
    public void launching_the_browser() {
        driver.manage().window().maximize();

        driver.get("https://compendiumdev.co.uk/");
        seleniumActions=new SeleniumActions(driver);

        compendiumevPages=new CompendiumevPages(driver);

        System.out.println("Launching the browser");
    }
    @When("opening the compendiumdev page")
    public void opening_the_compendiumdev_page() {


        System.out.println("Opening the compendiumdev page");
    }
    @Then("clicking the contact")
    public void clicking_the_contact() {

        compendiumevPages.contactButton();
        System.out.println("Clicking the contact");
    }
    @And("filling the form")
    public void filling_the_form() throws InterruptedException {
        Thread.sleep(2000);
        compendiumevPages.nameForm();

        System.out.println("Filling the form");
    }
    @Then("clicking the submit")
    public void clicking_the_submit() {
        compendiumevPages.submitButton();
        System.out.println("Clicking the submit");

    }
    @And("close browser")
    public void close_browser() throws InterruptedException {
        Assert.assertTrue(compendiumevPages.vrification());

        System.out.println("Close browser");
    }
    @After
    public void killSession(){
        driver.quit();
    }

}
