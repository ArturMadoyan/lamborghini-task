package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import testsForLamborghini.Constants;
import testsForLamborghini.SearchLamborghiniPage;

public class LamborghiniTest extends BaseTest{
    @Test
    public void lamborghiniTask() {
        driver.get("https://www.google.com/");
        SearchLamborghiniPage lmbPage = new SearchLamborghiniPage(driver);
        lmbPage.searchFiled("Lamborghini");
        lmbPage.clickOnPageSeven();
        lmbPage.clickOnLmbLosAngelesButton();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(Constants.EXPECTED_TITLE,actualTitle);
        Assert.assertEquals("https://www.ogaracoach.com/lamborghini.htm",driver.getCurrentUrl());
    }
}
