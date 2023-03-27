/**
 * CanReg5 - a tool to input, store, check and analyse cancer registry data.
 * Copyright (C) 2008-2015  International Agency for Research on Cancer
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * @author Morten Johannes Ervik, CSU/IARC, ervikm@iarc.fr
 */
package canreg.server.database;

import canreg.client.CanRegClientApp;
import canreg.client.gui.tools.WaitFrame;
import canreg.common.Globals;
import canreg.common.cachingtableapi.DistributedTableDescriptionException;
import canreg.common.database.Patient;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ervikm
 */
public class Migrator {

    private static final Logger LOGGER = Logger.getLogger(Migrator.class.getName());
    private String newVersion;
    private CanRegDAO canRegDAO;

    /**
     *
     * @param newVersion
     * @param canRegDAO
     */
    public Migrator(String newVersion, CanRegDAO canRegDAO) {
        this.newVersion = newVersion;
        this.canRegDAO = canRegDAO;
    }

    /**
     *
     */
    public void migrate() {
        String databaseVersion = canRegDAO.getSystemPropery("DATABASE_VERSION");

        if (databaseVersion == null) {
            databaseVersion = "4.99.0";
        }

        if (!databaseVersion.equalsIgnoreCase(newVersion)) {
            if (databaseVersion.compareTo("4.99.5") < 0) {
                migrateTo_4_99_5(canRegDAO);
            }
            if (databaseVersion.length() < 7 || databaseVersion.substring(0, 7).compareTo("5.00.06") < 0) {
                migrateTo_5_00_06(canRegDAO);
            }
            if (databaseVersion.length() < 7 || databaseVersion.substring(0, 7).compareTo("5.00.17") < 0) {
                migrateTo_5_00_17(canRegDAO);
            }
            if (databaseVersion.length() < 7 || databaseVersion.substring(0, 7).compareTo("5.00.19") < 0) {
                migrateTo_5_00_19(canRegDAO);
            }
            if (databaseVersion.length() < 7 || databaseVersion.substring(0, 7).compareTo("5.00.43") < 0) {
                migrateTo_5_00_43(canRegDAO);
            }
            if (databaseVersion.length() < 7 || databaseVersion.substring(0, 7).compareTo("5.00.44") < 0) {
                JDesktopPane desktopPane = CanRegClientApp.getApplication().getDesktopPane();
                for (Component component: desktopPane.getComponents()) {
                    if (component.getClass() == WaitFrame.class) {
                        WaitFrame waitFrame = (WaitFrame) component;
                        waitFrame.setLabel(java.util.ResourceBundle.getBundle("canreg/client/gui/resources/LoginInternalFrame").getString("MIGRATING_DATABASE_LABEL"));
                        waitFrame.setTitle(java.util.ResourceBundle.getBundle("canreg/client/gui/resources/LoginInternalFrame").getString("MIGRATING_DATABASE_TITLE"));
                        waitFrame.setSize(600, 127);
                        waitFrame.setLocation((desktopPane.getWidth() - waitFrame.getWidth()) / 2, (desktopPane.getHeight() - waitFrame.getHeight()) / 2);
                        break;
                    }
                }
                migrateTo_5_00_44(canRegDAO);
            }
        }
        // canRegDAO.setSystemPropery("DATABASE_VERSION", newVersion);
    }

    private void migrateTo_4_99_5(CanRegDAO db) {
        // no users in the table from before so we just drop it
        db.dropAndRebuildUsersTable();
        db.setSystemPropery("DATABASE_VERSION", "4.99.5");
        LOGGER.log(Level.INFO, "Migrated the database to version 4.99.5.");
    }

    private void migrateTo_5_00_06(CanRegDAO db) {
        try {
            db.dropAndRebuildKeys();
            db.setSystemPropery("DATABASE_VERSION", "5.00.06");
            LOGGER.log(Level.INFO, "Migrated the database to version 5.00.06.");
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    private void migrateTo_5_00_17(CanRegDAO db) {
        try {
            db.addColumnToTable("USER_ROLE", "INT", Globals.USERS_TABLE_NAME);
            db.setSystemPropery("DATABASE_VERSION", "5.00.17");
            LOGGER.log(Level.INFO, "Migrated the database to version 5.00.17.");
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    private void migrateTo_5_00_19(CanRegDAO db) {
        try {
            db.dropColumnFromTable("USER_ROLE", Globals.USERS_TABLE_NAME );
            db.addColumnToTable("USER_ROLE", "VARCHAR(255)", Globals.USERS_TABLE_NAME);
            db.setSystemPropery("DATABASE_VERSION", "5.00.19");
            LOGGER.log(Level.INFO, "Migrated the database to version 5.00.19.");
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }
    private void migrateTo_5_00_43(CanRegDAO db) {
        try {
            try {            
                db.upgrade();
                db.setSystemPropery("DATABASE_VERSION", "5.00.43");
            } catch (RemoteException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }            
            LOGGER.log(Level.INFO, "Migrated the database to version 5.00.43.");
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    private void migrateTo_5_00_44(CanRegDAO db) {
        try {
            try {
                db.upgrade();

                db.addColumnToTable("UUID", "VARCHAR(36) UNIQUE", Globals.PATIENT_TABLE_NAME); // add new column to the Patient table
                ArrayList<Patient> patients = db.getAllPatients();
                // set UUID to be not null & unique
                for (Patient patient : patients) {
                    patient.setUuid(); // set UUID
                    db.editPatient(patient, true); // update the patient in the database
                }
                db.setSystemPropery("DATABASE_VERSION", "5.00.44"); // update version number
            } catch (SQLException | UnknownTableException | DistributedTableDescriptionException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            } catch (RecordLockedException e) {
                LOGGER.log(Level.SEVERE, "record is locked", e);
                System.out.println("record is locked!");
            }
        } catch (RemoteException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        LOGGER.log(Level.INFO, "Migrated the database to version 5.00.44.");
    }
}
