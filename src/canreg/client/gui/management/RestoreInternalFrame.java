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
 * RestoreInternalFrame.java
 *
 * Created on 02 July 2008, 10:11
 */
package canreg.client.gui.management;

import canreg.client.CanRegClientApp;
import canreg.common.Globals;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;

/**
 *
 * @author  ervikm
 */
public class RestoreInternalFrame extends javax.swing.JInternalFrame {

    /** Creates new form RestoreInternalFrame */
    public RestoreInternalFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        restoreFromLabel = new javax.swing.JLabel();
        folderNameTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(RestoreInternalFrame.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        restoreFromLabel.setText(resourceMap.getString("restoreFromLabel.text")); // NOI18N
        restoreFromLabel.setName("restoreFromLabel"); // NOI18N

        folderNameTextField.setText(resourceMap.getString("folderNameTextField.text")); // NOI18N
        folderNameTextField.setName("folderNameTextField"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(RestoreInternalFrame.class, this);
        browseButton.setAction(actionMap.get("browseAction")); // NOI18N
        browseButton.setName("browseButton"); // NOI18N

        okButton.setAction(actionMap.get("okAction")); // NOI18N
        okButton.setName("okButton"); // NOI18N

        cancelButton.setAction(actionMap.get("cancelAction")); // NOI18N
        cancelButton.setName("cancelButton"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(restoreFromLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(folderNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(restoreFromLabel)
                    .addComponent(browseButton)
                    .addComponent(folderNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 
     */
    @Action
    public void browseAction() {
//                FileNameExtensionFilter filter = new FileNameExtensionFilter("XML file", "xml");
 
        JFileChooser chooser = new JFileChooser(Globals.CANREG_BACKUP_FOLDER);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        chooser.addChoosableFileFilter(filter);

        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                //set the file name
                folderNameTextField.setText(chooser.getSelectedFile().getCanonicalPath());
                // changeFile();
            } catch (IOException ex) {
                Logger.getLogger(RestoreInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
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
     * @return
     */
    @Action
    public Task okAction() {
        if (folderNameTextField.getText().trim().length()==0){
            JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/RestoreInternalFrame").getString("PLEASE SPECIFY A FOLDER NAME."), java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/RestoreInternalFrame").getString("ERROR"), JOptionPane.ERROR_MESSAGE);
            return null;
        }
            this.dispose();
        return new OkActionTask(org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class));
    }

    private class OkActionTask extends org.jdesktop.application.Task<Object, Void> {
        String folderName = null;
        OkActionTask(org.jdesktop.application.Application app) {
            // Runs on the EDT.  Copy GUI state that
            // doInBackground() depends on from parameters
            // to OkActionTask fields, here.
            super(app);
            folderName = folderNameTextField.getText().trim();
        }
        @Override protected String doInBackground() {
            // Your Task's code here.  This method runs
            // on a background thread, so don't reference
            // the Swing GUI from here.            
            String success = "";
            
            if (folderName.length()>0)
                try {
                success = canreg.client.CanRegClientApp.getApplication().restoreBackup(folderName);
            } catch (SecurityException ex) {
                Logger.getLogger(RestoreInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                return "security exception";
            } catch (RemoteException ex) {
                Logger.getLogger(RestoreInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                return "remote exception";
            }
            else {
                return "no name";
            }
            return success;  // return your result
        }
        @Override protected void succeeded(Object result) {
            // Runs on the EDT.  Update the GUI based on
            // the result computed by doInBackground().
            String resultString = (String) result;
            
            if (resultString.equals("security exception")){
                JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/RestoreInternalFrame").getString("YOU DON'T HAVE THE USER LEVEL TO DO THIS."), java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/RestoreInternalFrame").getString("ERROR"), JOptionPane.ERROR_MESSAGE);
            } else if (resultString.equals("remote exception")){
                // You don't have the user level to do this...
                JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/RestoreInternalFrame").getString("SERVER ERROR."), java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/RestoreInternalFrame").getString("ERROR"), JOptionPane.ERROR_MESSAGE);
            } else if (resultString.equals("no name")){
                JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/RestoreInternalFrame").getString("PLEASE SPECIFY A FOLDER NAME."), java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/RestoreInternalFrame").getString("ERROR"), JOptionPane.ERROR_MESSAGE);
            } else if (resultString.equals("shutdown failed")){
                JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/RestoreInternalFrame").getString("COULD NOT SHUT DOWN THE DATABASE."), java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/RestoreInternalFrame").getString("ERROR"), JOptionPane.ERROR_MESSAGE);
            } else if (resultString.equals("failed")){
                // Restore not successfull
                JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/RestoreInternalFrame").getString("RESTORE NOT SUCCESSFULL."), java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/RestoreInternalFrame").getString("ERROR"), JOptionPane.ERROR_MESSAGE);
            } else {
                // All went well
                JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/RestoreInternalFrame").getString("RESTORE SUCCESSFULL.")+"\n"+java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/RestoreInternalFrame").getString("PLEASE RESTART YOUR CANREG SYSTEM."), java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/RestoreInternalFrame").getString("MESSAGE"), JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField folderNameTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel restoreFromLabel;
    // End of variables declaration//GEN-END:variables

}
