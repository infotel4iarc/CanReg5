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
 * WelcomeInternalFrame.java
 *
 * Created on 02 April 2008, 16:24
 */
package canreg.client.gui;

import canreg.client.CanRegClientApp;
import canreg.client.gui.management.InstallNewSystemInternalFrame;
import canreg.common.Globals;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import org.jdesktop.application.Action;
import org.jdesktop.application.FrameView;

/**
 *
 * @author  morten
 */
public class WelcomeInternalFrame extends javax.swing.JInternalFrame {

    private FrameView fv;
    private Properties appInfoProperties;
    private JDialog aboutBox;

    /** Creates new form WelcomeInternalFrame
     * @param fv 
     */
    public WelcomeInternalFrame(FrameView fv) {

        this.fv = fv;
        appInfoProperties = new Properties();
        InputStream in = null;
        try {
            //
            // load properties file
            //
            //
            // get Application information
            //
            in = getClass().getResourceAsStream(Globals.APPINFO_PROPERTIES_PATH);
            appInfoProperties.load(in);
            in.close();
            initComponents();
            // set version
            String versionString = "";
            for (String part : Globals.versionStringParts) {
                versionString += appInfoProperties.getProperty(part);
            }
            versionString += "b" + appInfoProperties.getProperty("program.BUILDNUM");
            versionString += " (" + appInfoProperties.getProperty("program.BUILDDATE") + ")";
            versionLabel.setText(versionLabel.getText() + " " + versionString);
        } catch (IOException ex) {
            Logger.getLogger(WelcomeInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        logoButton = new javax.swing.JButton();
        aboutScrollPane = new javax.swing.JScrollPane();
        aboutEditorPane = new javax.swing.JEditorPane();
        buttonPanel = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        restoreBackupButton = new javax.swing.JButton();
        versionLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(WelcomeInternalFrame.class);
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        mainPanel.setName("mainPanel"); // NOI18N

        logoButton.setIcon(resourceMap.getIcon("logoButton.icon")); // NOI18N
        logoButton.setBorder(null);
        logoButton.setBorderPainted(false);
        logoButton.setContentAreaFilled(false);
        logoButton.setFocusable(false);
        logoButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logoButton.setName("logoButton"); // NOI18N
        logoButton.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        aboutScrollPane.setName("aboutScrollPane"); // NOI18N

        aboutEditorPane.setEditable(false);
        aboutEditorPane.setFont(resourceMap.getFont("aboutEditorPane.font")); // NOI18N
        aboutEditorPane.setText(resourceMap.getString("aboutEditorPane.text")); // NOI18N
        aboutEditorPane.setFocusCycleRoot(false);
        aboutEditorPane.setFocusable(false);
        aboutEditorPane.setMinimumSize(new java.awt.Dimension(50, 76));
        aboutEditorPane.setName("aboutEditorPane"); // NOI18N
        aboutEditorPane.setRequestFocusEnabled(false);
        aboutScrollPane.setViewportView(aboutEditorPane);

        buttonPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonPanel.setName("buttonPanel"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(WelcomeInternalFrame.class, this);
        loginButton.setAction(actionMap.get("showLoginFrame")); // NOI18N
        loginButton.setIcon(resourceMap.getIcon("loginButton.icon")); // NOI18N
        loginButton.setText(resourceMap.getString("loginButton.text")); // NOI18N
        loginButton.setToolTipText(resourceMap.getString("loginButton.toolTipText")); // NOI18N
        loginButton.setActionCommand(resourceMap.getString("loginButton.actionCommand")); // NOI18N
        loginButton.setName("loginButton"); // NOI18N

        restoreBackupButton.setAction(actionMap.get("installNewSystemAction")); // NOI18N
        restoreBackupButton.setToolTipText(resourceMap.getString("restoreBackupButton.toolTipText")); // NOI18N
        restoreBackupButton.setName("restoreBackupButton"); // NOI18N

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loginButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(restoreBackupButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(restoreBackupButton, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        versionLabel.setText(resourceMap.getString("versionLabel.text")); // NOI18N
        versionLabel.setName("versionLabel"); // NOI18N

        jLabel1.setForeground(resourceMap.getColor("jLabel1.foreground")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(aboutScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(versionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(logoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aboutScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(versionLabel)
                            .addComponent(jLabel1))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // We want to keep this window "always on top"
    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        this.toFront();
    }//GEN-LAST:event_formFocusLost

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        if (aboutBox == null) {
            JFrame mainFrame = CanRegClientApp.getApplication().getMainFrame();
            aboutBox = new CanRegClientAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        CanRegClientApp.getApplication().show(aboutBox);
    }//GEN-LAST:event_jLabel1MouseClicked

    /**
     * 
     */
    @Action
    public void showLoginFrame() {
        this.dispose();
        LoginInternalFrame loginInternalFrame = new LoginInternalFrame(fv, desktopPane);
        desktopPane.add(loginInternalFrame, javax.swing.JLayeredPane.DEFAULT_LAYER);
        //JFrame mainFrame = CanRegClientApp.getApplication().getMainFrame();
        loginInternalFrame.setLocation(desktopPane.getWidth() / 2 - loginInternalFrame.getWidth() / 2, desktopPane.getHeight() / 2 - loginInternalFrame.getHeight() / 2);
        loginInternalFrame.setVisible(true);
    }

    /**
     * 
     * @param dtp
     */
    public void setDesktopPane(JDesktopPane dtp) {
        desktopPane = dtp;
    }

    /**
     * 
     */
    @Action
    public void installNewSystemAction() {
        InstallNewSystemInternalFrame internalFrame = new InstallNewSystemInternalFrame();
        desktopPane.add(internalFrame, javax.swing.JLayeredPane.DEFAULT_LAYER);
        //JFrame mainFrame = CanRegClientApp.getApplication().getMainFrame();
        internalFrame.setLocation(desktopPane.getWidth() / 2 - internalFrame.getWidth() / 2, desktopPane.getHeight() / 2 - internalFrame.getHeight() / 2);
        internalFrame.setVisible(true);
        this.dispose();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane aboutEditorPane;
    private javax.swing.JScrollPane aboutScrollPane;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton logoButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton restoreBackupButton;
    private javax.swing.JLabel versionLabel;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JDesktopPane desktopPane;
}
