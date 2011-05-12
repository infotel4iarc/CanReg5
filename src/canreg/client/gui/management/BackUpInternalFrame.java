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
 * BackUpInternalFrame.java
 *
 * Created on 29 February 2008, 15:08
 */
package canreg.client.gui.management;

import canreg.client.gui.tools.globalpopup.MyPopUpMenu;
import canreg.common.Globals;
import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;

/**
 *
 * @author  morten
 */
public class BackUpInternalFrame extends javax.swing.JInternalFrame {

    String backupPath;

    /** Creates new form BackUpInternalFrame */
    public BackUpInternalFrame() {
        initComponents();
        openFolderButton.setEnabled(canreg.client.CanRegClientApp.getApplication().isCanRegServerRunningOnThisMachine());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        performBackupButton = new javax.swing.JButton();
        openFolderButton = new javax.swing.JButton();
        feedbackLabel = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        setClosable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(BackUpInternalFrame.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        mainPanel.setName("mainPanel"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(BackUpInternalFrame.class, this);
        performBackupButton.setAction(actionMap.get("performBackupAction")); // NOI18N
        performBackupButton.setName("performBackupButton"); // NOI18N

        openFolderButton.setAction(actionMap.get("openFolderAction")); // NOI18N
        openFolderButton.setName("openFolderButton"); // NOI18N

        feedbackLabel.setName("feedbackLabel"); // NOI18N

        scrollPane.setName("scrollPane"); // NOI18N

        textArea.setColumns(20);
        textArea.setEditable(false);
        textArea.setRows(5);
        textArea.setName("textArea"); // NOI18N
        textArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textAreaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                textAreaMouseReleased(evt);
            }
        });
        scrollPane.setViewportView(textArea);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(performBackupButton, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
            .addComponent(feedbackLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
            .addComponent(openFolderButton, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(performBackupButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(feedbackLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(openFolderButton))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textAreaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textAreaMouseReleased
        MyPopUpMenu.potentiallyShowPopUpMenuTextComponent(textArea, evt);
    }//GEN-LAST:event_textAreaMouseReleased

    private void textAreaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textAreaMousePressed
        MyPopUpMenu.potentiallyShowPopUpMenuTextComponent(textArea, evt);
    }//GEN-LAST:event_textAreaMousePressed

    /**
     * 
     * @return
     */
    @Action
    public Task performBackupAction() {
        return new PerformBackupActionTask(org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class));
    }

    private class PerformBackupActionTask extends org.jdesktop.application.Task<Object, Void> {

        PerformBackupActionTask(org.jdesktop.application.Application app) {
            super(app);
            Cursor hourglassCursor = new Cursor(Cursor.WAIT_CURSOR);
            setCursor(hourglassCursor);
            performBackupButton.setEnabled(false);
            textArea.setText(java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/BackUpInternalFrame").getString("BACKING_UP_DATABASE...") + java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/BackUpInternalFrame").getString("PLEASE_WAIT."));
        }

        @Override
        protected Object doInBackground() {
            backupPath = canreg.client.CanRegClientApp.getApplication().performBackup();
            return null;
        }

        @Override
        protected void succeeded(Object result) {
            Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
            setCursor(normalCursor);
            textArea.setText(textArea.getText() + "\n" +java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/BackUpInternalFrame").getString("BACKED_UP_TO_") + backupPath + ".");
        }
    }

    /**
     * 
     */
    @Action
    // This only works in Windows so far...
    public void openFolderAction() {
        if (canreg.client.CanRegClientApp.getApplication().isCanregServerRunningInThisThread()) {
            if (System.getProperty("os.name").toString().substring(0, 3).equalsIgnoreCase("win")) {
                try {
                    File file = new File(Globals.CANREG_BACKUP_FOLDER);
                    Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + file.getAbsolutePath());
                } catch (IOException ex) {
                    Logger.getLogger(BackUpInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel feedbackLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton openFolderButton;
    private javax.swing.JButton performBackupButton;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
