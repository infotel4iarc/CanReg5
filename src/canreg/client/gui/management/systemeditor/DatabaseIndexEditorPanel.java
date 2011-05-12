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
 * DatabaseIndexEditorPanel.java
 *
 * Created on 27-Jan-2011, 15:21:24
 */
package canreg.client.gui.management.systemeditor;

import canreg.common.DatabaseIndexesListElement;
import canreg.common.DatabaseVariablesListElement;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.application.Action;
import canreg.common.Globals;
import java.util.LinkedList;

/**
 *
 * @author ervikm
 */
public class DatabaseIndexEditorPanel extends javax.swing.JPanel implements ActionListener {

    public static String REMOVE_VARIABLE = "remove_indexed_variable";
    private DatabaseVariablesListElement[] variablesInDB;
    private DatabaseIndexesListElement databaseIndexesListElement;
    private DatabaseVariablesListElement[] variablesInChosenTable;

    /** Creates new form DatabaseIndexEditorPanel */
    public DatabaseIndexEditorPanel() {
        initComponents();
        tableComboBox.setModel(new DefaultComboBoxModel(Globals.TABLE_LIST));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableLabel = new javax.swing.JLabel();
        tableComboBox = new javax.swing.JComboBox();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        variablesPanel = new javax.swing.JPanel();
        variablesScrollPane = new javax.swing.JScrollPane();
        variablesScrollPanePanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(DatabaseIndexEditorPanel.class);
        tableLabel.setText(resourceMap.getString("tableLabel.text")); // NOI18N
        tableLabel.setName("tableLabel"); // NOI18N

        tableComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(DatabaseIndexEditorPanel.class, this);
        tableComboBox.setAction(actionMap.get("tableChanged")); // NOI18N
        tableComboBox.setName("tableComboBox"); // NOI18N

        nameLabel.setText(resourceMap.getString("nameLabel.text")); // NOI18N
        nameLabel.setName("nameLabel"); // NOI18N

        nameTextField.setText(resourceMap.getString("nameTextField.text")); // NOI18N
        nameTextField.setName("nameTextField"); // NOI18N
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        variablesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("variablesPanel.border.title"))); // NOI18N
        variablesPanel.setName("variablesPanel"); // NOI18N

        variablesScrollPane.setName("variablesScrollPane"); // NOI18N

        variablesScrollPanePanel.setName("variablesScrollPanePanel"); // NOI18N
        variablesScrollPanePanel.setLayout(new java.awt.GridLayout(0, 1));
        variablesScrollPane.setViewportView(variablesScrollPanePanel);

        addButton.setAction(actionMap.get("addAction")); // NOI18N
        addButton.setName("addButton"); // NOI18N

        javax.swing.GroupLayout variablesPanelLayout = new javax.swing.GroupLayout(variablesPanel);
        variablesPanel.setLayout(variablesPanelLayout);
        variablesPanelLayout.setHorizontalGroup(
            variablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, variablesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton))
            .addComponent(variablesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );
        variablesPanelLayout.setVerticalGroup(
            variablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, variablesPanelLayout.createSequentialGroup()
                .addComponent(variablesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addButton))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(variablesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tableLabel)
                            .addComponent(nameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                            .addComponent(tableComboBox, 0, 390, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tableLabel)
                    .addComponent(tableComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(variablesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }

    @Action
    public void addAction() {
        addVariable(variablesInDB[0], variablesInChosenTable);
    }//GEN-LAST:event_nameTextFieldActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JComboBox tableComboBox;
    private javax.swing.JLabel tableLabel;
    private javax.swing.JPanel variablesPanel;
    private javax.swing.JScrollPane variablesScrollPane;
    private javax.swing.JPanel variablesScrollPanePanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(REMOVE_VARIABLE)) {
            variablesPanel.remove((javax.swing.JPanel) e.getSource());
        }
    }

    public void setDatabaseIndexesListElement(DatabaseIndexesListElement dile) {
        this.databaseIndexesListElement = dile;
        nameTextField.setText(dile.getIndexName());
        tableComboBox.setSelectedItem(dile.getDatabaseTableName());
        tableChanged();
        for (DatabaseVariablesListElement datababaseVariableListElement : dile.getVariableListElementsInIndex()) {
            addVariable(datababaseVariableListElement, variablesInChosenTable);
        }
    }

    public void setVariablesInDatabase(DatabaseVariablesListElement[] variables) {
        this.variablesInDB = variables;
    }

    public void refreshDatabaseIndexesListElement() {
        databaseIndexesListElement.setIndexName(nameTextField.getText());
        databaseIndexesListElement.setDatabaseTableName(tableComboBox.getSelectedItem().toString());
        databaseIndexesListElement.setVariablesInIndex(getVariablesInIndex());
    }

    private DatabaseVariablesListElement[] getVariablesInIndex() {
        DatabaseVariablesListElement[] variables = new DatabaseVariablesListElement[variablesScrollPanePanel.getComponents().length];
        int i = 0;
        for (Component panel : variablesScrollPanePanel.getComponents()) {
            IndexedVariablePanel ivp = (IndexedVariablePanel) panel;
            variables[i++] = (DatabaseVariablesListElement) ivp.getSelectedValue();
        }
        return variables;
    }

    private void addVariable(DatabaseVariablesListElement datababaseVariableListElement, DatabaseVariablesListElement[] possibleValues) {
        IndexedVariablePanel ivp = new IndexedVariablePanel();
        ivp.setPossibleValues(possibleValues);
        ivp.setSelectedValue(datababaseVariableListElement);
        ivp.setListener(this);
        variablesScrollPanePanel.add(ivp);
        variablesScrollPanePanel.revalidate();
        variablesScrollPanePanel.repaint();
    }

    @Action
    public void tableChanged() {
        LinkedList<DatabaseVariablesListElement> tempList = new LinkedList<DatabaseVariablesListElement>();
        String selectedTable = tableComboBox.getSelectedItem().toString();
        for (DatabaseVariablesListElement dvle : variablesInDB) {
            if (dvle.getDatabaseTableName().equalsIgnoreCase(selectedTable)) {
                tempList.add(dvle);
            }
        }
        variablesInChosenTable = tempList.toArray(new DatabaseVariablesListElement[0]);
        for (Component panel : variablesScrollPanePanel.getComponents()) {
            IndexedVariablePanel ivp = (IndexedVariablePanel) panel;
            ivp.setPossibleValues(variablesInChosenTable);
        }
    }
}
