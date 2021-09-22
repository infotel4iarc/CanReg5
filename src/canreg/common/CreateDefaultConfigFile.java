package canreg.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateDefaultConfigFile {

    /**
     * Write the hard coded credentials in a dedicate file.
     * The file is set once at the installation and filed with the default supervisor credentials.
     * The file will also be created if it doesn't exist.
     * If the file exists it will not be overwritten 
     * It will be later replace with new credentials from a supervisor
     *
     * @return
     */

    public boolean writeDefaultConfigFile() {
        boolean success = false;
        OutputStream propOutputStream = null;
        Properties properties = new Properties();
        properties.setProperty("username", "morten");
        properties.setProperty("password", "ervik");

        try {
            File f = new File(Globals.CANREG_CONFIG_FILENAME);
            if (!f.exists()) {
                propOutputStream = new FileOutputStream(Globals.CANREG_CONFIG_FILENAME);
                properties.storeToXML(propOutputStream, "properties");
                Logger.getLogger(CreateDefaultConfigFile.class.getName()).log(Level.INFO,
                    "The default file config.properties was successfully created");
            } else {
                Logger.getLogger(CreateDefaultConfigFile.class.getName()).log(Level.INFO,
                    "The default file config.properties already exists ");
            }
            success = true;
        } catch (IOException ex) {
            Logger.getLogger(CreateDefaultConfigFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (propOutputStream != null) {
                try {
                    propOutputStream.flush();
                    propOutputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(CreateDefaultConfigFile.class.getName()).log(Level.SEVERE, "Error while creating"
                        + " the default file config.properties", ex);
                    success = false;
                }
            }
        }
        return success;
    }

    /**
     * Read the config file and create the config file if it doesn't exist
     * @return the properties
     */
    public Properties readConfigFile() {

       // create the default file if not present
        writeDefaultConfigFile();
        
        Properties properties = new Properties();
        try {
            FileInputStream propInputStream = new FileInputStream(Globals.CANREG_CONFIG_FILENAME);
            properties.loadFromXML(propInputStream);
        } catch (IOException ex) {
            Logger.getLogger(CreateDefaultConfigFile.class.getName()).log(Level.SEVERE, "Error while reading"
                + " the default file config.properties", ex);
        }
        return properties;
    }
}