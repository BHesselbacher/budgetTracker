package persistence;

import java.io.*;
import java.util.*;
import org.apache.logging.log4j.*;

/**
 * This Interface contains a default method that can be used anywhere a
 * Properties object is needed to be loaded.
 *
 * @author bhesselbacher
 */
public interface PropertiesLoader {
    /**
     * This default method will load a properties file into a Properties instance
     * and return it
     *
     * @param propertiesFilePath a path to a file on the java classpath list
     * @return a populated Properties instance or an empty Properties instance if
     * the file path was not found
     */
    default Properties loadProperties(String propertiesFilePath) {
        final Logger logger = LogManager.getLogger(this.getClass());
        Properties properties = new Properties();

        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            logger.error("Can't load the properties file.", ioException);
        } catch (Exception exception) {
            logger.error("Problem: ", exception);
        }

        return properties;
    }
}
