package tests;

public class TestRunner {
    public static void RunTests() {
        printTestResult(RepoTests.getSignInUserTest(), "getSignInUser");
    }

    private static void printTestResult(boolean result, String testName) {
        if (result)
            System.out.println("Test [" + testName + "] passed!");
        else
            System.out.println("Test [" + testName + "] failed :(");
    }
}
