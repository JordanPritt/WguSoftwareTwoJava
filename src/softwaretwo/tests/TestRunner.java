package softwaretwo.tests;

/**
 * A class for running tests and displaying their results.
 */
public class TestRunner {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_PURPLE = "\u001B[35m";

    /**
     * Runs the provided tests and prints the results.
     */
    public static void RunTests() {
        int testCounter = 0;
        try {
            System.out.println(ANSI_PURPLE + "Running tests" + ANSI_RESET + "...\n" + ANSI_RESET);
            printTestResult(RepoTests.getSignInUserTest(), "getSignInUser");
            testCounter++;
            printTestResult(RepoTests.getAllAppointmentsTest(), "getAllAppointments");
            testCounter++;
        } catch (Exception ex) {
            String message = ANSI_RED + "\n[Error]\n" + ANSI_RESET + "Testing Failed, reason: ";
            System.out.println(message + ANSI_YELLOW + ex.getMessage() + ANSI_RESET);
        } finally {
            String completeMessage = "\n[Testing Complete]\n" + ANSI_RESET + "Ran: " + testCounter + " test(s)";
            System.out.println(ANSI_YELLOW + completeMessage);
        }
    }

    private static void printTestResult(boolean result, String testName) {
        if (result)
            System.out.println("Test [" + ANSI_PURPLE + testName + ANSI_RESET + "]" + ANSI_GREEN + " passed!" + ANSI_RESET);
        else
            System.out.println("Test [" + ANSI_PURPLE + testName + ANSI_RESET + "]" + ANSI_RED + " failed :(" + ANSI_RESET);
    }
}
