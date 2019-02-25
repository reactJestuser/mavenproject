package testngRun;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Class2 {

    @Test(groups = { "B" })
    public void method2() {

        Assert.assertEquals(false, true);
        System.out.println("Class2 method");
    }
    
}
