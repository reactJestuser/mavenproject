package testngRun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Class3 {

    @Test(groups = { "C" })
    public void method3() {

        Assert.assertEquals(true, true);
        System.out.println("Class3 method");
    }
}
