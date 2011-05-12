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
 * LatestNewsInternalFrame.java
 *
 * Created on 19-Jan-2011, 09:22:43
 */
package canreg.client.gui;

/**
 *
 * @author ervikm
 */
import canreg.client.gui.tools.globalpopup.MyPopUpMenu;
import com.sun.cnpi.rss.elements.Category;
import com.sun.cnpi.rss.elements.Item;
import com.sun.cnpi.rss.elements.Link;
import com.sun.cnpi.rss.elements.Rss;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;
import com.sun.cnpi.rss.parser.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import org.jdesktop.application.Action;

public class LatestNewsInternalFrame extends javax.swing.JInternalFrame implements HyperlinkListener {

    /** Creates new form LatestNewsInternalFrame */
    public LatestNewsInternalFrame() {
        initComponents();
        initContent();
        newsEditorPane.addHyperlinkListener(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        newsEditorPane = new javax.swing.JEditorPane();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(LatestNewsInternalFrame.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        newsEditorPane.setEditable(false);
        newsEditorPane.setName("newsEditorPane"); // NOI18N
        newsEditorPane.setRequestFocusEnabled(false);
        newsEditorPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                newsEditorPaneMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                newsEditorPaneMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(newsEditorPane);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
        );

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(LatestNewsInternalFrame.class, this);
        jButton1.setAction(actionMap.get("okAction")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(337, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newsEditorPaneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newsEditorPaneMousePressed
        MyPopUpMenu.potentiallyShowPopUpMenuTextComponent(newsEditorPane, evt);
    }//GEN-LAST:event_newsEditorPaneMousePressed

    private void newsEditorPaneMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newsEditorPaneMouseReleased
        MyPopUpMenu.potentiallyShowPopUpMenuTextComponent(newsEditorPane, evt);
    }//GEN-LAST:event_newsEditorPaneMouseReleased

    public void readRSSDocument() throws RssParserException, IOException {

        // TODO: switch to ROME https://rome.dev.java.net/

        RssParser parser = RssParserFactory.createDefault();
        Rss rss = parser.parse(
                new URL(canreg.common.Globals.CANREG_TWITTER_RSS_URL));
        //Get all XML elements in the feed
        StringBuilder newsStringBuilder = new StringBuilder();
        Collection items = rss.getChannel().getItems();
        DateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        if (items != null && !items.isEmpty()) {
            //Iterate over our main elements. Should have one for each article
            for (Iterator i = items.iterator();
                    i.hasNext();
                    System.out.println()) {
                Item item = (Item) i.next();
                // news+=("<h2>" + item.getTitle() + "</h2><br>");
                // System.out.println("Link: " + item.getLink());
                String description = item.getDescription().toString();
                // remove the canreg: from the twitter feed
                description = description.replaceFirst("canreg:", "");
                Link link = item.getLink();
                String calString = "";
                try {
                    String date = item.getPubDate().toString();
                    Calendar cal = canreg.common.DateHelper.parseTimestamp(date, "EEE, d MMM yyyy HH:mm:ss Z", null);
                    calString = format.format(cal.getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(LatestNewsInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                newsStringBuilder.append("<h5>").append(calString).append(": </h5>");
                newsStringBuilder.append(description);
                newsStringBuilder.append("<br>");
                newsStringBuilder.append("<a href = \"").append(link.getText()).append("\">Link</a>");
                newsStringBuilder.append("<br><br>");
            }
            newsEditorPane.setText(newsStringBuilder.toString());
            newsEditorPane.setCaretPosition(0);
        }

        //Iterate over categories if we are provided with any
        Collection categories = rss.getChannel().getCategories();
        if (categories != null && !categories.isEmpty()) {
            Category cat;
            for (Iterator i = categories.iterator();
                    i.hasNext();
                    System.out.println("Category Domain: " + cat.getDomain())) {
                cat = (Category) i.next();
                System.out.println("Category: " + cat);
            }

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane newsEditorPane;
    // End of variables declaration//GEN-END:variables

    private void initContent() {
        newsEditorPane.setContentType("text/html");
        try {
            readRSSDocument();
        } catch (RssParserException ex) {
            Logger.getLogger(LatestNewsInternalFrame.class.getName()).log(Level.INFO, null, ex);
            newsEditorPane.setText("<h2>No current news found. Please check your internet connection.</h2>");

        } catch (IOException ex) {
            newsEditorPane.setText("<h2>No current news found. Please check your internet connection.</h2>");
            Logger.getLogger(LatestNewsInternalFrame.class.getName()).log(Level.INFO, null, ex);
        }
    }

    @Action
    public void okAction() {
        this.dispose();
    }

    @Override
    public void hyperlinkUpdate(HyperlinkEvent event) {
        if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            try {
                canreg.common.Tools.browse(event.getURL().toString());
            } catch (IOException ex) {
                Logger.getLogger(LatestNewsInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
