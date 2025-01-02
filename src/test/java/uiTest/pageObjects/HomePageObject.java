package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import uiTest.helpers.TestHelper;

public class HomePageObject extends PageObject {
    private TestHelper testHelper;

    public HomePageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }

    public void verifyHomePage() {

        testHelper.switchToIFrame("framelive");

        WebElement element = testHelper.findElementUsingSelector("#wrapper > div > nav > ol > li > span");

        String breadcrumbItem = (String) ((JavascriptExecutor) getDriver())
                .executeScript("return arguments[0].textContent", element);

        Assert.assertEquals("Couldn't verify the Home page", "Home", breadcrumbItem.trim());
    }

    public void verifyHomePageAfterSignIn() {
        testHelper.switchToIFrame("framelive");
        this.verifyHomePage();

        WebElement element = testHelper.findElementUsingSelector("#_desktop_user_info > div > a.logout.hidden-sm-down");
        String loginStatus = (String) ((JavascriptExecutor) getDriver())
                .executeScript("return arguments[0].childNodes[2].textContent", element);

        Assert.assertEquals("Couldn't verify the Home page", "Sign out", loginStatus.trim());
    }

    public void clickSignIn() {
        testHelper.switchToIFrame("framelive");
        WebElement signInButton = testHelper.findElementUsingXpath("//*[@id=\"_desktop_user_info\"]/div/a");
        signInButton.click();
    }

    public void clickProduct() {
        testHelper.switchToIFrame("framelive");
        WebElement clickProduct = testHelper.findElementUsingXpath("//*[@id=\"content\"]/section[1]/div/div[1]/article/div/div[1]/a");
        clickProduct.click();
    }


}