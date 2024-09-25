package failedTestCases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    int maxTry = 1;
    //    int count = 0;
    ThreadLocal<Integer> count = ThreadLocal.withInitial(() -> 0);

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count.get() < maxTry) {
                count.set(count.get() + 1);
                return true;
            }
        }
        return false;
    }
}
