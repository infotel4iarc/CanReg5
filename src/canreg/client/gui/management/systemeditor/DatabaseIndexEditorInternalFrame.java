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
 * DatabaseIndexEditorInternalFrame.java
 *
 * Created on 27-Jan-2011, 16:05:32
 */
package canreg.client.gui.management.systemeditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jdesktop.application.Action;
import canreg.common.DatabaseIndexesListElement;
import canreg.common.DatabaseVariablesListElement;

/**
 *
 * @author ervikm
 */
public class DatabaseIndexEditorInternalFrame extends javax.swing.JInternalFrame {

    public static String UPDATED = "index_updated";
    private ActionListener listener;

    /** Creates new form DatabaseIndexEditorInternalFrame */
    public DatabaseIndexEditorInternalFrame() {
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

        databaseIndexEditorPanel1 = new canreg.client.gui.management.systemeditor.DatabaseIndexEditorPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(DatabaseIndexEditorInternalFrame.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        databaseIndexEditorPanel1.setName("databaseIndexEditorPanel1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(DatabaseIndexEditorInternalFrame.class, this);
        jButton1.setAction(actionMap.get("okAction")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jButton2.setAction(actionMap.get("cancelAction")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(347, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(databaseIndexEditorPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(databaseIndexEditorPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private canreg.client.gui.management.systemeditor.DatabaseIndexEditorPanel databaseIndexEditorPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables

    @Action
    public void cancelAction() {
        this.dispose();
    }

    @Action
    public void okAction() {
        databaseIndexEditorPanel1.refreshDatabaseIndexesListElement();
        listener.actionPerformed(new ActionEvent(this, 0, UPDATED));
        this.dispose();
    }

    public void setActionListener(ActionListener listener) {
        this.listener = listener;
    }

    public void setDatabaseIndexesListElement(DatabaseIndexesListElement databaseIndexesListElement) {
        databaseIndexEditorPanel1.setDatabaseIndexesListElement(databaseIndexesListElement);
    }

    public void setVariablesInDatabase(DatabaseVariablesListElement[] variables) {
        databaseIndexEditorPanel1.setVariablesInDatabase(variables);
    }
}
