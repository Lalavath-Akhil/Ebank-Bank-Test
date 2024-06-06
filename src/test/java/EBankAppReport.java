import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

public class EBankAppReport implements ITestListener {

    @Override
    public void onTestStart (ITestResult result){
        System.out.println("Test Started: " + result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Test Success: " + result.getMethod().getMethodName());
    }
    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Test Failure: " + result.getMethod().getMethodName());
    }
    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println("Test Skipped: " + result.getMethod().getMethodName());
    }
    public void onStart(ITestContext context){
        System.out.println("Starting Test Suite");
    }
    public  void onFinish(ITestContext context){
        System.out.println("Finishing Test Suite");
    }

}
