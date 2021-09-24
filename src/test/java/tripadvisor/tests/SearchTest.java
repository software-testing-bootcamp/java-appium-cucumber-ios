package tripadvisor.tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Cucumber.class)
public class SearchTest {

    public IOSDriver<MobileElement> driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "iPhone 6s");
        capabilities.setCapability("udid", "94340211c5fd2fc61c15a9bd8bfecb73b13cd448");
       // capabilities.setCapability("platformVersion",  "14.8");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("bundleId", "com.tripadvisor.LocalPicks");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("fullReset", "false");
        capabilities.setCapability("autoAcceptAlerts", "true");
        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

/*    @BeforeStep
    public void beforeStep() {
        //takeScreenshot();
    }

    @AfterStep
    public void afterStep() {

    }

    @After
    public void after() {
        //driver.resetApp();
        //driver.quit();
    }*/

    @Given("Uygulamaya misafir kullanıcı ile giriş yapılır")
    public void uygulamayaMisafirKullanıcıIleGirişYapılır() {
        try {
            MobileElement el1_0 = (MobileElement) driver.findElementByAccessibilityId("");
            el1_0.click();
        } catch (Exception e) {}

        try {
            MobileElement el_1 = (MobileElement) driver.findElementByAccessibilityId("Skip");
            el_1.click();
        } catch (Exception e) {}

        try {
            MobileElement el_2 = (MobileElement) driver.findElementByAccessibilityId("Continue");
            el_2.click();
        } catch (Exception e) {}

    }

    @When("Arama ekranından {string} aratılır")
    public void aramaEkranındanAratılır(String city) {

        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Search");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Where to?");
        el2.click();
        el2.sendKeys(city);
    }

    @And("Bulunan ilk arama sonucu seçilir")
    public void bulunanIlkAramaSonucuSeçilir() throws InterruptedException {
        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("LocationSection_Typeahead_0");
        el4.click();
        
    }

    @And("Otele tıklanır")
    public void oteleTıklanır() throws InterruptedException {
        Thread.sleep(2000);
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("Hotels");
        el5.click();
        
    }

    @Then("Otellerin listelendiği görülmelidir")
    public void otellerinListelendiğiGörülmelidir() throws InterruptedException {
        Thread.sleep(2000);
        MobileElement elHotels = (MobileElement) driver.findElementByAccessibilityId("Hotels");
        assertTrue(elHotels.isDisplayed());
        //assertEquals("Hotels", elHotels.getText());

    }

}

