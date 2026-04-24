package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JMeterManager 
{
    static String JMETER_HOME = "C:\\Users\\harsh\\Downloads\\apache-jmeter-5.6.3\\apache-jmeter-5.6.3"; 
    static String JMETER_EXECUTABLE = JMETER_HOME + "\\bin\\jmeter.bat";
    static String TEST_PLAN = "src/test/resources/jmeter/capstone_load.jmx";
    static String RESULT_FILE = "target/capstone_results.jtl";

    public static void executeLoadTest() throws Exception 
    {
        System.out.println("Firing JMeter Performance Test...");
        ProcessBuilder pb = new ProcessBuilder(JMETER_EXECUTABLE, "-n", "-t", TEST_PLAN, "-l", RESULT_FILE);
        pb.redirectErrorStream(true);
        Process process = pb.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) 
        {
            System.out.println(line);
        }

        if (process.waitFor() != 0) 
        {
            throw new RuntimeException("JMeter execution failed!");
        }
    }
}