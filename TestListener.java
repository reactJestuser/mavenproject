package testngRun;

import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;

public class TestListener implements ITestListener {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    Boolean projectSetupFailed = false;
    
    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        getTestLog(result, "PASS", ANSI_GREEN);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        getTestLog(result, "FAIL", ANSI_RED);
        if (result.getTestContext().getName().equalsIgnoreCase(
                "Test1")) {
            projectSetupFailed = true;
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getTestLog(result, "SKIP", ANSI_YELLOW);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onStart(ITestContext context) {

        if (projectSetupFailed) {
            throw new SkipException(
                    "One or more methods failed in set up project suite");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        
    }
    
    private void getTestLog (ITestResult result, String testStatus, String statusColor) {

        float timetakenToExecute = (result.getEndMillis() - result
                .getStartMillis()) / 1000.0f;
        StringBuilder log = new StringBuilder();
        String methodname = result.getTestClass().getName() + "." + result
                .getMethod().getMethodName();
        String status = statusColor + testStatus + ANSI_RESET;
        log.append(methodname);

        // Add 1st parameter name in case of data providers
        if (result.getParameters().length > 1) {
            for (Object eachObject : result.getParameters()) {
                String parameter = eachObject.toString();
                String[] parameterName = parameter.split("_");
                log.append("." + parameterName[0]);
                break;
            }
        }
        log.append(" ...  ");
        log.append(status);
        log.append(" ");
        log.append("(" + timetakenToExecute + "s)");
        System.out.println(log);
    }
}
