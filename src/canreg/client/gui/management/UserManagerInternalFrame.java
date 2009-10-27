/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserManagerInternalFrame.java
 *
 * Created on 05-May-2009, 16:55:02
 */
package canreg.client.gui.management;

import canreg.common.Globals;
import canreg.common.PasswordService;
import canreg.exceptions.SystemUnavailableException;
import canreg.server.database.User;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;

/**
 *
 * @author ervikm
 */
public class UserManagerInternalFrame extends javax.swing.JInternalFrame {

    private Vector<User> users;
    private DefaultListModel usersListModel;

    /** Creates new form UserManagerInternalFrame */
    public UserManagerInternalFrame() {
        initComponents();
        initData();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        currentUserPanel = new javax.swing.JPanel();
        passwordPanel = new javax.swing.JPanel();
        newPasswordLabel = new javax.swing.JLabel();
        confirmNewPasswordLabel = new javax.swing.JLabel();
        newPasswordField = new javax.swing.JPasswordField();
        confirmNewPasswordField = new javax.swing.JPasswordField();
        changePasswordButton = new javax.swing.JButton();
        lockedRecordsPanel = new javax.swing.JPanel();
        lockedRecordsScrollPane = new javax.swing.JScrollPane();
        lockedRecordsList = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        userManagerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        userRightLevelComboBox = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersList = new javax.swing.JList();
        realNameTextField = new javax.swing.JTextField();
        realNameLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(UserManagerInternalFrame.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        tabbedPane.setName("tabbedPane"); // NOI18N

        currentUserPanel.setName("currentUserPanel"); // NOI18N

        passwordPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("passwordPanel.border.title"))); // NOI18N
        passwordPanel.setName("passwordPanel"); // NOI18N

        newPasswordLabel.setText(resourceMap.getString("newPasswordLabel.text")); // NOI18N
        newPasswordLabel.setName("newPasswordLabel"); // NOI18N

        confirmNewPasswordLabel.setText(resourceMap.getString("confirmNewPasswordLabel.text")); // NOI18N
        confirmNewPasswordLabel.setName("confirmNewPasswordLabel"); // NOI18N

        newPasswordField.setText(resourceMap.getString("newPasswordField.text")); // NOI18N
        newPasswordField.setName("newPasswordField"); // NOI18N

        confirmNewPasswordField.setText(resourceMap.getString("confirmNewPasswordField.text")); // NOI18N
        confirmNewPasswordField.setName("confirmNewPasswordField"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(UserManagerInternalFrame.class, this);
        changePasswordButton.setAction(actionMap.get("changePasswordAction")); // NOI18N
        changePasswordButton.setText(resourceMap.getString("changePasswordButton.text")); // NOI18N
        changePasswordButton.setName("changePasswordButton"); // NOI18N

        javax.swing.GroupLayout passwordPanelLayout = new javax.swing.GroupLayout(passwordPanel);
        passwordPanel.setLayout(passwordPanelLayout);
        passwordPanelLayout.setHorizontalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(changePasswordButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passwordPanelLayout.createSequentialGroup()
                        .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmNewPasswordLabel)
                            .addComponent(newPasswordLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(confirmNewPasswordField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)))))
        );
        passwordPanelLayout.setVerticalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passwordPanelLayout.createSequentialGroup()
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPasswordLabel)
                    .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmNewPasswordLabel)
                    .addComponent(confirmNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(changePasswordButton))
        );

        javax.swing.GroupLayout currentUserPanelLayout = new javax.swing.GroupLayout(currentUserPanel);
        currentUserPanel.setLayout(currentUserPanelLayout);
        currentUserPanelLayout.setHorizontalGroup(
            currentUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(passwordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        currentUserPanelLayout.setVerticalGroup(
            currentUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentUserPanelLayout.createSequentialGroup()
                .addComponent(passwordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        tabbedPane.addTab(resourceMap.getString("currentUserPanel.TabConstraints.tabTitle"), currentUserPanel); // NOI18N

        lockedRecordsPanel.setName("lockedRecordsPanel"); // NOI18N

        lockedRecordsScrollPane.setName("lockedRecordsScrollPane"); // NOI18N

        lockedRecordsList.setName("lockedRecordsList"); // NOI18N
        lockedRecordsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lockedRecordsListValueChanged(evt);
            }
        });
        lockedRecordsScrollPane.setViewportView(lockedRecordsList);

        jButton1.setAction(actionMap.get("refreshLockedRecordsAction")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        javax.swing.GroupLayout lockedRecordsPanelLayout = new javax.swing.GroupLayout(lockedRecordsPanel);
        lockedRecordsPanel.setLayout(lockedRecordsPanelLayout);
        lockedRecordsPanelLayout.setHorizontalGroup(
            lockedRecordsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lockedRecordsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lockedRecordsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lockedRecordsScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addContainerGap())
        );
        lockedRecordsPanelLayout.setVerticalGroup(
            lockedRecordsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lockedRecordsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lockedRecordsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );

        tabbedPane.addTab(resourceMap.getString("lockedRecordsPanel.TabConstraints.tabTitle"), lockedRecordsPanel); // NOI18N

        userManagerPanel.setName("userManagerPanel"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        usernameTextField.setEditable(false);
        usernameTextField.setText(resourceMap.getString("usernameTextField.text")); // NOI18N
        usernameTextField.setName("usernameTextField"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        userRightLevelComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        userRightLevelComboBox.setName("userRightLevelComboBox"); // NOI18N

        jButton2.setAction(actionMap.get("resetPasswordAction")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        jButton3.setAction(actionMap.get("updateUserAction")); // NOI18N
        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N

        jButton4.setAction(actionMap.get("deleteUserAction")); // NOI18N
        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setName("jButton4"); // NOI18N

        jButton5.setAction(actionMap.get("addUserAction")); // NOI18N
        jButton5.setName("jButton5"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        usersList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        usersList.setName("usersList"); // NOI18N
        usersList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                usersListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(usersList);

        realNameTextField.setText(resourceMap.getString("realNameTextField.text")); // NOI18N
        realNameTextField.setName("realNameTextField"); // NOI18N

        realNameLabel.setText(resourceMap.getString("realNameLabel.text")); // NOI18N
        realNameLabel.setName("realNameLabel"); // NOI18N

        emailTextField.setText(resourceMap.getString("emailTextField.text")); // NOI18N
        emailTextField.setName("emailTextField"); // NOI18N

        emailLabel.setText(resourceMap.getString("emailLabel.text")); // NOI18N
        emailLabel.setName("emailLabel"); // NOI18N

        javax.swing.GroupLayout userManagerPanelLayout = new javax.swing.GroupLayout(userManagerPanel);
        userManagerPanel.setLayout(userManagerPanelLayout);
        userManagerPanelLayout.setHorizontalGroup(
            userManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userManagerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                    .addGroup(userManagerPanelLayout.createSequentialGroup()
                        .addGroup(userManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(realNameLabel)
                            .addComponent(emailLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(userManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                            .addComponent(userRightLevelComboBox, 0, 331, Short.MAX_VALUE)
                            .addComponent(realNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                            .addComponent(emailTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userManagerPanelLayout.createSequentialGroup()
                        .addGroup(userManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(userManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        userManagerPanelLayout.setVerticalGroup(
            userManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userManagerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(userManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userRightLevelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(realNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(realNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel))
                .addGap(11, 11, 11)
                .addGroup(userManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        tabbedPane.addTab(resourceMap.getString("userManagerPanel.TabConstraints.tabTitle"), userManagerPanel); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initData() {
        Globals.UserRightLevels level = canreg.client.CanRegClientApp.getApplication().getUserRightLevel();
        if (level == Globals.UserRightLevels.SUPERVISOR) {
            refreshUsersList();
            DefaultComboBoxModel userLevelsModel = new DefaultComboBoxModel(Globals.UserRightLevels.values());
            userRightLevelComboBox.setModel(userLevelsModel);
            usersList.setSelectedIndex(0);
        } else {
            tabbedPane.setEnabledAt(tabbedPane.indexOfComponent(userManagerPanel), false);
        }
    }

    private void usersListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_usersListValueChanged
        User user = (User) usersList.getSelectedValue();
        if (user != null) {
            usernameTextField.setText(user.getUserName());
            userRightLevelComboBox.setSelectedItem(user.getUserRightLevel());
            realNameTextField.setText(user.getRealName());
            emailTextField.setText(user.getEmail());
        } else {
            usernameTextField.setText("");
            userRightLevelComboBox.setSelectedItem(null);
            realNameTextField.setText("");
            emailTextField.setText("");
        }
    }//GEN-LAST:event_usersListValueChanged

    private void lockedRecordsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lockedRecordsListValueChanged
        // TODO add your handling code here:
}//GEN-LAST:event_lockedRecordsListValueChanged

    @Action
    public void addUserAction() {
        User user = new User();
        String userName = JOptionPane.showInputDialog("User name:");
        if (userName == null) {
            return;
        }
        while (userName.length() > Globals.MAX_USERNAME_LENGHT) {
            JOptionPane.showInternalMessageDialog(rootPane, "User name too long. (Max " + Globals.MAX_USERNAME_LENGHT + " characters long.)", "User name too long.", JOptionPane.ERROR_MESSAGE);
            userName = JOptionPane.showInputDialog("User name:");
            if (userName == null) {
                return;
            }
        }
        user.setUserName(userName);
        user.setRealName("");
        user.setEmail("");
        user.setUserRightLevel(Globals.UserRightLevels.ANALYST);
        try {
            String encrypted = PasswordService.getInstance().encrypt(user.getUserName());
            user.setPassword(encrypted.toCharArray());
            canreg.client.CanRegClientApp.getApplication().saveUser(user);
            JOptionPane.showInternalMessageDialog(this, "User added. Temporary password is " + userName + ".");
        } catch (SystemUnavailableException ex) {
            Logger.getLogger(UserManagerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserManagerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(UserManagerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(UserManagerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshUsersList();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changePasswordButton;
    private javax.swing.JPasswordField confirmNewPasswordField;
    private javax.swing.JLabel confirmNewPasswordLabel;
    private javax.swing.JPanel currentUserPanel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lockedRecordsList;
    private javax.swing.JPanel lockedRecordsPanel;
    private javax.swing.JScrollPane lockedRecordsScrollPane;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JLabel newPasswordLabel;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JLabel realNameLabel;
    private javax.swing.JTextField realNameTextField;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JPanel userManagerPanel;
    private javax.swing.JComboBox userRightLevelComboBox;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JList usersList;
    // End of variables declaration//GEN-END:variables

    private void refreshUsersList() {
        try {
            users = canreg.client.CanRegClientApp.getApplication().listUsers();
            usersListModel = new DefaultListModel();
            for (User user : users) {
                usersListModel.addElement(user);
            }
            usersList.setModel(usersListModel);
        } catch (SecurityException ex) {
            Logger.getLogger(UserManagerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(UserManagerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Action
    public void changePasswordAction() {
        // verify if passwords match...
        if (Arrays.equals(newPasswordField.getPassword(), confirmNewPasswordField.getPassword())) {
            String passwordString = new String(newPasswordField.getPassword());
            try {
                String encrypted = PasswordService.getInstance().encrypt(passwordString);
                passwordString = null;
                try {
                    canreg.client.CanRegClientApp.getApplication().changePassword(encrypted);
                    JOptionPane.showInternalMessageDialog(this, "Password changed.");
                } catch (SecurityException ex) {
                    Logger.getLogger(UserManagerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(UserManagerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SystemUnavailableException ex) {
                Logger.getLogger(UserManagerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // set password...
    }

    private void refreshLockedRecordsList() {
    }

    @Action
    public void refreshLockedRecordsAction() {
        refreshLockedRecordsList();
    }

    @Action
    public void updateUserAction() {
        User user = (User) usersList.getSelectedValue();
        boolean okToChange;

        if (user.getUserRightLevel() == Globals.UserRightLevels.SUPERVISOR && (Globals.UserRightLevels) userRightLevelComboBox.getSelectedItem() != Globals.UserRightLevels.SUPERVISOR) {
            okToChange = canRemoveSupervisor(user);
            if (!okToChange) {
                JOptionPane.showInternalMessageDialog(this, "Not allowed to change user level of the last supervisor user.");
                return;
            }
        }

        int index = usersList.getSelectedIndex();
        user.setUserRightLevel((Globals.UserRightLevels) userRightLevelComboBox.getSelectedItem());
        user.setEmail(emailTextField.getText());
        user.setRealName(realNameTextField.getText());
        try {
            canreg.client.CanRegClientApp.getApplication().saveUser(user);
            JOptionPane.showInternalMessageDialog(this, "User updated.");
        } catch (SQLException ex) {
            Logger.getLogger(UserManagerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(UserManagerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(UserManagerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshUsersList();
        usersList.setSelectedIndex(index);
    }

    @Action
    public void resetPasswordAction() {
        User user = (User) usersList.getSelectedValue();
        try {
            String encrypted = PasswordService.getInstance().encrypt(user.getUserName());
            user.setPassword(encrypted.toCharArray());
            canreg.client.CanRegClientApp.getApplication().saveUser(user);
            JOptionPane.showInternalMessageDialog(this, "User password reset. Temporary password is " + user.getUserName() + ".");
        } catch (SystemUnavailableException ex) {
            Logger.getLogger(UserManagerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserManagerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(UserManagerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(UserManagerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Action
    public void deleteUserAction() {
        User user = (User) usersList.getSelectedValue();
        boolean okToDelete = true;
        if (user.getUserRightLevel() == Globals.UserRightLevels.SUPERVISOR) {
            okToDelete = canRemoveSupervisor(user);
            if (!okToDelete) {
                JOptionPane.showInternalMessageDialog(this, "Not allowed to delete the last supervisor user.");
            }
        }
        int id = user.getID();
        if (okToDelete && id > 0) {
            try {
                canreg.client.CanRegClientApp.getApplication().deleteRecord(id, "USERS");
            } catch (SecurityException ex) {
                Logger.getLogger(UserManagerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(UserManagerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        refreshUsersList();
    }

    private boolean canRemoveSupervisor(User user) {
        boolean ok = true;
        int numberOfSupervisors = 0;
        for (User tempUser : users) {
            if (tempUser.getUserRightLevel() == Globals.UserRightLevels.SUPERVISOR) {
                numberOfSupervisors++;
            }
        }
        if (numberOfSupervisors == 1) {
            ok = false;
        }
        return ok;
    }
}
