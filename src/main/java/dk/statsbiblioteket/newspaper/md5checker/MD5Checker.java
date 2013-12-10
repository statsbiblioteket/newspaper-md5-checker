package dk.statsbiblioteket.newspaper.md5checker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.statsbiblioteket.medieplatform.autonomous.CallResult;
import dk.statsbiblioteket.medieplatform.autonomous.RunnableComponent;
import dk.statsbiblioteket.medieplatform.autonomous.AutonomousComponentUtils;

import java.util.Map;
import java.util.Properties;

/** This is a sample component to serve as a guide to developers */
public class MD5Checker {


    private static Logger log = LoggerFactory.getLogger(MD5Checker.class);

    /**
     * The class must have a main method, so it can be started as a command line tool
     *
     * @param args the arguments.
     *
     * @throws Exception
     * @see AutonomousComponentUtils#parseArgs(String[])
     */
    public static void main(String... args) throws Exception {
        System.exit(doMain(args));
    }

    /**
     * The class must have a main method, so it can be started as a command line tool
     *
     * @param args the arguments.
     *
     * @throws Exception
     * @see AutonomousComponentUtils#parseArgs(String[])
     */
    public static int doMain(String[] args) throws Exception {
        log.info("Starting with args {}", args);

        //Parse the args to a properties construct
        Properties properties = AutonomousComponentUtils.parseArgs(args);

        //make a new runnable component from the properties
        RunnableComponent component = new MD5CheckerComponent(properties);

        CallResult result = AutonomousComponentUtils.startAutonomousComponent(properties, component);

        System.out.println(result);
        return result.containsFailures();
    }
}