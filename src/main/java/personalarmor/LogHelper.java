package personalarmor;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Helper class witch provides logging system.
 * 
 * @author Julien Rosset
 */
public class LogHelper
{
    private static Logger logger = LogManager.getLogger("PersonalArmor");
    
    /**
     * Log a message.
     * 
     * @param level     Log level.
     * @param message   Message to log.
     */
    public static void log (Level level, String message)
    {
        logger.log(level, message);
    }

    /**
     * Log a TRACE message.
     * 
     * @param message Message to log.
     */
    public static void trace (String message)
    {
        LogHelper.log(Level.TRACE, message);
    }
    /**
     * Log a DEBUG message.
     * 
     * @param message Message to log.
     */
    public static void debug (String message)
    {
        LogHelper.log(Level.DEBUG, message);
    }
    /**
     * Log a INFO message.
     * 
     * @param message Message to log.
     */
    public static void info (String message)
    {
        LogHelper.log(Level.INFO, message);
    }
    /**
     * Log a WARN message.
     * 
     * @param message Message to log.
     */
    public static void warn (String message)
    {
        LogHelper.log(Level.WARN, message);
    }
    /**
     * Log a ERROR message.
     * 
     * @param message Message to log.
     */
    public static void error (String message)
    {
        LogHelper.log(Level.ERROR, message);
    }
    /**
     * Log a FATAL message.
     * 
     * @param message Message to log.
     */
    public static void fatal (String message)
    {
        LogHelper.log(Level.FATAL, message);
    }
}
