/**
 * CanReg5 - a tool to input, store, check and analyse cancer registry data.
 * Copyright (C) 2008-2011  International Agency for Research on Cancer
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
 * @author Morten Johannes Ervik, CIN/IARC, ervikm@iarc.fr
 */

/*
 * CanReg4SystemConverterInternalFrame.java
 *
 * Created on 01 July 2008, 13:56
 */
package canreg.client.gui.management;

import canreg.client.CanRegClientApp;
import canreg.client.dataentry.PopulationDataSetHelper;
import canreg.client.gui.CanRegClientView;
import canreg.client.gui.dataentry.PDSEditorInternalFrame;
import canreg.common.Globals;
import canreg.common.database.PopulationDataset;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jdesktop.application.Action;

// Variables declaration - do not modify
/**
 *
 * @author  ervikm
 */
public class CanReg4PDSImporterInternalFrame extends javax.swing.JInternalFrame {

    private JFileChooser chooser;
    private JDesktopPane dtp;
    private PopulationDataset[] worldPopulations;
    private Map<Integer, PopulationDataset> populationDatasets;
    private String PDS_FILE_EXTENSION = "PDS";

    /** Creates new form CanReg4SystemConverterInternalFrame */
    public CanReg4PDSImporterInternalFrame(JDesktopPane dtp, Map<Integer, PopulationDataset> populationDatasets) {
        this.dtp = dtp;
        this.populationDatasets = populationDatasets;
        LinkedList<PopulationDataset> populationDatasetsLinkedList = new LinkedList<PopulationDataset>();
        LinkedList<PopulationDataset> worldPopulationDatasetsLinkedList = new LinkedList<PopulationDataset>();
        for (PopulationDataset pds:populationDatasets.values()){
            if (pds.isWorldPopulationBool()){
                worldPopulationDatasetsLinkedList.add(pds);
            } else {
                populationDatasetsLinkedList.add(pds);
            }
        }
        worldPopulations = worldPopulationDatasetsLinkedList.toArray(new PopulationDataset[]{new PopulationDataset()});

        initComponents();

        File file = new File(Globals.CANREG4_SYSTEM_FOLDER);

        if (!file.exists()) {
            chooser = new JFileChooser();
        } else {
            chooser = new JFileChooser(Globals.CANREG4_SYSTEM_FOLDER);
        }
        // Filter only the DEF-files.
        FileNameExtensionFilter filter = new FileNameExtensionFilter(java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/CanReg4PDSImporterInternalFrame").getString("CANREG4 PDS FILE"), PDS_FILE_EXTENSION);
        chooser.addChoosableFileFilter(filter);
    }

    public void setDesktopPane(JDesktopPane dtp) {
        this.dtp = dtp;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileNameTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        convertButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        nameTextField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(CanReg4PDSImporterInternalFrame.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N

        fileNameTextField.setText(resourceMap.getString("fileNameTextField.text")); // NOI18N
        fileNameTextField.setName("fileNameTextField"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(CanReg4PDSImporterInternalFrame.class, this);
        browseButton.setAction(actionMap.get("browseAction")); // NOI18N
        browseButton.setText(resourceMap.getString("browseButton.text")); // NOI18N
        browseButton.setName("browseButton"); // NOI18N

        convertButton.setAction(actionMap.get("convertAction")); // NOI18N
        convertButton.setText(resourceMap.getString("convertButton.text")); // NOI18N
        convertButton.setName("convertButton"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setName("jTextArea1"); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jButton1.setAction(actionMap.get("cancelAction")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        nameTextField.setEditable(false);
        nameTextField.setName("nameTextField"); // NOI18N

        nameLabel.setText(resourceMap.getString("nameLabel.text")); // NOI18N
        nameLabel.setName("nameLabel"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(convertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton)
                    .addComponent(convertButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName(resourceMap.getString("Form.AccessibleContext.accessibleName")); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 
     */
    @Action
    public void browseAction() {
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                //set the file name
                fileNameTextField.setText(chooser.getSelectedFile().getCanonicalPath());
            // changeFile();
            } catch (IOException ex) {
                Logger.getLogger(CanReg4PDSImporterInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * 
     */
    @Action
    public void cancelAction() {
        this.dispose();
    }

    /**
     * 
     */
    @Action
    public void convertAction() {
        PopulationDataset pds = new PopulationDataset();
        try {
            pds = PopulationDataSetHelper.readCanReg4PDS(fileNameTextField.getText());

            PDSEditorInternalFrame pdseif = new PDSEditorInternalFrame(dtp, worldPopulations, null);
            pdseif.setPopulationDataset(pds);
            JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/CanReg4PDSImporterInternalFrame").getString("POPULATION DATASET LOADED:") + pds.getPopulationDatasetName() + java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/CanReg4PDSImporterInternalFrame").getString("PLEASE VERIFY AND SAVE IT TO THE CANREG DATABASE."), java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/CanReg4PDSImporterInternalFrame").getString("SUCCESS"), JOptionPane.INFORMATION_MESSAGE);

            CanRegClientView.showAndPositionInternalFrame(dtp, pdseif);

            this.dispose();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CanReg4PDSImporterInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/CanReg4PDSImporterInternalFrame").getString("COULD NOT OPEN FILE:") + fileNameTextField.getText().trim() + java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/CanReg4PDSImporterInternalFrame").getString("."), java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/CanReg4PDSImporterInternalFrame").getString("ERROR"), JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(CanReg4PDSImporterInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JButton convertButton;
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    // End of variables declaration//GEN-END:variables
}
