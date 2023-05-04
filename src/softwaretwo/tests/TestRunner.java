package softwaretwo.tests;

import java.time.Duration;
import java.time.Instant;

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
        Instant starts, ends;
        starts = Instant.now();

        try {
            System.out.println(ANSI_PURPLE + "Running tests" + ANSI_RESET + "...\n" + ANSI_RESET);
            printTestResult(RepoTests.getSignInUserTest(), "getSignInUser");
            testCounter++;

            printTestResult(RepoTests.getAllAppointmentsTest(), "getAllAppointments");
            testCounter++;

            printTestResult(LoginLoggerTests.logUserActivityTest(), "logUserActivityTest");
            testCounter++;

            printTestResult(RepoTests.insertCustomerTest(), "insertCustomerTest");
            testCounter++;

            printTestResult(RepoTests.deleteCustomerTest(), "deleteCustomerTest");
            testCounter++;

            printTestResult(RepoTests.updateCustomerTest(), "updateCustomerTest");
            testCounter++;

            printTestResult(RepoTests.getAllCustomerTest(), "getAllCustomersTest");
            testCounter++;

            printTestResult(RepoTests.getAllCustomerTest(), "getAllCustomersTest");
            testCounter++;

            printTestResult(RepoTests.getDivisionByNameTest(), "getDivisionByNameTest");
            testCounter++;

            printTestResult(RepoTests.getAllContactsTest(), "getAllContactsTest");
            testCounter++;

            printTestResult(RepoTests.insertAppointmentTest(), "insertAppointmentTest");
            testCounter++;

            printTestResult(RepoTests.deleteAppointmentTest(), "deleteAppointmentTest");
            testCounter++;

        } catch (Exception ex) {
            String message = ANSI_RED + "\n[Error]\n" + ANSI_RESET + "Testing Failed, reason: ";
            System.out.println(message + ANSI_YELLOW + ex.getMessage() + ANSI_RESET);
        } finally {
            ends = Instant.now();
            String completeMessage = "\n[Testing Complete]\n" + ANSI_RESET + "Ran " + testCounter + " test(s)";
            long duration = Duration.between(starts, ends).getSeconds();
            String timeText = String.format("%d:%02d:%02d", duration / 3600, (duration % 3600) / 60, (duration % 60));
            System.out.println(ANSI_YELLOW + completeMessage + " in: " + timeText);
        }
    }

    private static void printTestResult(boolean result, String testName) {
        if (result)
            System.out.println("Test [" + ANSI_PURPLE + testName + ANSI_RESET + "]" + ANSI_GREEN + " passed!" + ANSI_RESET);
        else
            System.out.println("Test [" + ANSI_PURPLE + testName + ANSI_RESET + "]" + ANSI_RED + " failed :(" + ANSI_RESET);
    }
}
