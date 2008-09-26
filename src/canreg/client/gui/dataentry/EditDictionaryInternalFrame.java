/*
 * EditDictionaryInternalFrame.java
 *
 * Created on 29 February 2008, 14:06
 */
package canreg.client.gui.dataentry;

import canreg.client.CanRegClientApp;
import canreg.client.gui.CanRegClientView;
import canreg.common.DatabaseDictionaryListElement;
import canreg.common.Globals;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;
import org.w3c.dom.Document;

/**
 *
 * @author  morten
 */
public class EditDictionaryInternalFrame extends javax.swing.JInternalFrame {

    private DatabaseDictionaryListElement[] dictionariesInDB;
    private Document doc;
    private JDesktopPane desktopPane;

    /** Creates new form EditDictionaryInternalFrame */
    public EditDictionaryInternalFrame(JDesktopPane dtp) {
        this.desktopPane = dtp;
        initComponents();
        initValues();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        allFieldsPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        oneFieldPanel = new javax.swing.JPanel();
        displayEditLabel = new javax.swing.JLabel();
        chooseDictionaryComboBox = new javax.swing.JComboBox();
        displayScrollPane = new javax.swing.JScrollPane();
        editorTextArea = new javax.swing.JTextArea();
        updateButton = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(EditDictionaryInternalFrame.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        allFieldsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("All Fields"));
        allFieldsPanel.setName("allFieldsPanel"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(EditDictionaryInternalFrame.class, this);
        jButton1.setAction(actionMap.get("exportCompleteDictionaryAction")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jButton2.setAction(actionMap.get("importCompleteDictionaryAction")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        javax.swing.GroupLayout allFieldsPanelLayout = new javax.swing.GroupLayout(allFieldsPanel);
        allFieldsPanel.setLayout(allFieldsPanelLayout);
        allFieldsPanelLayout.setHorizontalGroup(
            allFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allFieldsPanelLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
        );
        allFieldsPanelLayout.setVerticalGroup(
            allFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allFieldsPanelLayout.createSequentialGroup()
                .addGroup(allFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        oneFieldPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("One Field at a time"));
        oneFieldPanel.setName("oneFieldPanel"); // NOI18N

        displayEditLabel.setText(resourceMap.getString("displayEditLabel.text")); // NOI18N
        displayEditLabel.setName("displayEditLabel"); // NOI18N

        chooseDictionaryComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RecordStatus", "Sex", "PersonSearch" }));
        chooseDictionaryComboBox.setAction(actionMap.get("refreshSelectedDictionaryAction")); // NOI18N
        chooseDictionaryComboBox.setName("chooseDictionaryComboBox"); // NOI18N

        displayScrollPane.setName("displayScrollPane"); // NOI18N

        editorTextArea.setColumns(20);
        editorTextArea.setRows(5);
        editorTextArea.setName("editorTextArea"); // NOI18N
        displayScrollPane.setViewportView(editorTextArea);

        updateButton.setAction(actionMap.get("updateDictionaryAction")); // NOI18N
        updateButton.setText(resourceMap.getString("updateButton.text")); // NOI18N
        updateButton.setName("updateButton"); // NOI18N

        javax.swing.GroupLayout oneFieldPanelLayout = new javax.swing.GroupLayout(oneFieldPanel);
        oneFieldPanel.setLayout(oneFieldPanelLayout);
        oneFieldPanelLayout.setHorizontalGroup(
            oneFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oneFieldPanelLayout.createSequentialGroup()
                .addComponent(displayEditLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chooseDictionaryComboBox, 0, 444, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oneFieldPanelLayout.createSequentialGroup()
                .addContainerGap(437, Short.MAX_VALUE)
                .addComponent(updateButton))
            .addComponent(displayScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
        );
        oneFieldPanelLayout.setVerticalGroup(
            oneFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oneFieldPanelLayout.createSequentialGroup()
                .addGroup(oneFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayEditLabel)
                    .addComponent(chooseDictionaryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateButton))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(oneFieldPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(allFieldsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(allFieldsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oneFieldPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel allFieldsPanel;
    private javax.swing.JComboBox chooseDictionaryComboBox;
    private javax.swing.JLabel displayEditLabel;
    private javax.swing.JScrollPane displayScrollPane;
    private javax.swing.JTextArea editorTextArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel oneFieldPanel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
    private void initValues() {
        doc = CanRegClientApp.getApplication().getDatabseDescription();
        // variablesInDB = canreg.common.Tools.getVariableListElements(doc, Globals.NAMESPACE);
        dictionariesInDB = canreg.common.Tools.getDictionaryListElements(doc, Globals.NAMESPACE);
        chooseDictionaryComboBox.setModel(new javax.swing.DefaultComboBoxModel(dictionariesInDB));
        chooseDictionaryComboBox.setSelectedIndex(0);
    }

    @Action
    public void exportCompleteDictionaryAction() {
        
    }

    @Action
    public void importCompleteDictionaryAction() {
        JInternalFrame importFrame = new ImportCompleteDictionaryInternalFrame();
        CanRegClientView.showAndCenterInternalFrame(desktopPane, importFrame);
        this.dispose();
    }

    @Action
    public void selectDictionaryAction() {
        //TODO
    }

    @Action
    public Task updateDictionaryAction() {
        return new UpdateDictionaryActionTask(org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class));
    }

    private class UpdateDictionaryActionTask extends org.jdesktop.application.Task<Object, Void> {

        String dictionaryString;
        DatabaseDictionaryListElement dbdle;

        UpdateDictionaryActionTask(org.jdesktop.application.Application app) {
            // Runs on the EDT.  Copy GUI state that
            // doInBackground() depends on from parameters
            // to UpdateDictionaryActionTask fields, here.
            super(app);
            // first check to see if we have anything at all here
            dictionaryString = editorTextArea.getText().trim();
            dbdle = (DatabaseDictionaryListElement) chooseDictionaryComboBox.getSelectedItem();
        }

        @Override
        protected Object doInBackground() {
            // Your Task's code here.  This method runs
            // on a background thread, so don't reference
            // the Swing GUI from here.

            if (dictionaryString.trim().length() > 0) {
                int dictionaryID = dbdle.getDictionaryID();
                try {
                    canreg.client.dataentry.DictionaryHelper.replaceDictionary(dictionaryID, dictionaryString, CanRegClientApp.getApplication());
                    CanRegClientApp.getApplication().refreshDictionary();
                } catch (RemoteException ex) {
                    Logger.getLogger(EditDictionaryInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                return new String("Error.");
            }
            return null;  // return your result
        }

        @Override
        protected void succeeded(Object result) {
            // Runs on the EDT.  Update the GUI based on
            // the result computed by doInBackground().
            if (result == null) {
                JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), "Successfully updated dictionary: " + dbdle.getName() + ".", "Dictionary successfully updated.", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    @Action
    public void refreshSelectedDictionaryAction() {
        DatabaseDictionaryListElement dbdle = (DatabaseDictionaryListElement) chooseDictionaryComboBox.getSelectedItem();
        Map<String, String> map = canreg.client.dataentry.DictionaryHelper.getDictionaryByID(CanRegClientApp.getApplication().getDictionary(), dbdle.getDictionaryID());
        String str = "";
        if (map != null) {
            // Map sortedMap = new TreeMap(map);

            Iterator iterator = map.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                str += entry.getKey() + "\t" + entry.getValue() + "\n";
            }
        }
        editorTextArea.setText(str);
    }
}
