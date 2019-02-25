package testngRun;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Class1 {

    @Test(groups = { "A" })
    public void method1() {

        Assert.assertEquals(true, true);
        System.out.println("Class1 method");
    }
}
