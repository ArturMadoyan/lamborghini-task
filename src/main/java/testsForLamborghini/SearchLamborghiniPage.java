package testsForLamborghini;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchLamborghiniPage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver, 12);
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    @FindBy(css = "input[name='q'][type='text']")
    private WebElement searchFiled;

    @FindBy(css = "a[aria-label='Page 7']")
    private WebElement sevenPageButton;

    @FindBy(css = "button[class='btn btn-primary consumer-privacy-banner-button flex-shrink-0 w-auto mt-3 mt-sm-0 ml-sm-3 mb-sm-3']")
    private WebElement cookieButton;

    public SearchLamborghiniPage(WebDriver driver) {
        super(driver);
    }


    public String searchFiled(String search){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='q'][type='text']")));
       searchFiled.sendKeys(search + Keys.ENTER);
        return search;
    }

    public void clickOnPageSeven (){
        jse.executeScript("window.scrollTo(0,3100);");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[aria-label='Page 7']")));
        sevenPageButton.click();
    }

    public void clickOnForthLink(){
       jse.executeScript("window.scrollTo(0,300);");
        List<WebElement> list = driver.findElements(By.cssSelector("div[class='yuRUbf']"));
        wait.until(ExpectedConditions.elementToBeClickable(list.get(3)));
        list.get(3).click();
    }

}
