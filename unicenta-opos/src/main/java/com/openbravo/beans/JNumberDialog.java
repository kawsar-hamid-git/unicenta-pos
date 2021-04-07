//    KrOS POS  - Open Source Point Of Sale
//    Copyright (c) 2009-2018 uniCenta & previous Openbravo POS works
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.beans;

import com.openbravo.editor.JEditorNumber;
import javax.swing.Icon;

/**
 *
 * @author  adrian
 * @param <T>
 */
public abstract class JNumberDialog<T extends Number> extends javax.swing.JDialog {
    
    private static LocaleResources m_resources;
    
    protected JEditorNumber<T> m_jnumber;
    private T m_value;
    
    /** Creates new form JNumberDialog
     * @param parent
     * @param modal */
    public JNumberDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        init();
    }
    
    /** Creates new form JNumberDialog
     * @param parent
     * @param modal */
    public JNumberDialog(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        init();
    }

    private void init() {
        
        if (m_resources == null) {
            m_resources = new LocaleResources();
            m_resources.addBundleName("beans_messages");
        }
        
        initComponents();        
        getRootPane().setDefaultButton(jcmdOK);   
        m_jPanelTitle.setBorder(RoundedBorder.createGradientBorder());
    }
    
    protected void setup(){
   
        m_jnumber.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jnumber.setMinimumSize(new java.awt.Dimension(100, 20));
        m_jnumber.setPreferredSize(new java.awt.Dimension(132, 20));
        m_jnumber.reset();
        m_jnumber.activate();
        m_jnumber.setVisible(false);
        m_jnumber.addEditorKeys(m_jKeys);
        
        jInputPanel.removeAll();
        jInputPanel.add(m_jnumber, java.awt.BorderLayout.PAGE_START);

        m_value = null;
    }
    
    protected void setTitle(String title, String message, Icon icon) {
        setTitle(title);
        m_lblMessage.setText(message);
        m_lblMessage.setIcon(icon);
    }

    public T getValue(){
        return m_value;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcmdCancel = new javax.swing.JButton();
        jcmdOK = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanelGrid = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        m_jKeys = new com.openbravo.editor.JEditorKeys();
        jInputPanel = new javax.swing.JPanel();
        m_jPanelTitle = new javax.swing.JPanel();
        m_lblMessage = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(310, 410));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jcmdCancel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcmdCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/cancel.png"))); // NOI18N
        jcmdCancel.setText(m_resources.getString("button.cancel")); // NOI18N
        jcmdCancel.setMargin(new java.awt.Insets(8, 16, 8, 16));
        jcmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmdCancelActionPerformed(evt);
            }
        });
        jPanel1.add(jcmdCancel);

        jcmdOK.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcmdOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/ok.png"))); // NOI18N
        jcmdOK.setText(m_resources.getString("button.ok")); // NOI18N
        jcmdOK.setMargin(new java.awt.Insets(8, 16, 8, 16));
        jcmdOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmdOKActionPerformed(evt);
            }
        });
        jPanel1.add(jcmdOK);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanelGrid.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanelGrid.setPreferredSize(new java.awt.Dimension(300, 320));

        jPanel3.setPreferredSize(new java.awt.Dimension(300, 350));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        m_jKeys.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jKeys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jKeysActionPerformed(evt);
            }
        });
        jPanel3.add(m_jKeys);

        jInputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jInputPanel.setMinimumSize(new java.awt.Dimension(110, 30));
        jInputPanel.setPreferredSize(new java.awt.Dimension(142, 30));
        jInputPanel.setLayout(new java.awt.BorderLayout());
        jPanel3.add(jInputPanel);

        javax.swing.GroupLayout jPanelGridLayout = new javax.swing.GroupLayout(jPanelGrid);
        jPanelGrid.setLayout(jPanelGridLayout);
        jPanelGridLayout.setHorizontalGroup(
            jPanelGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGridLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelGridLayout.setVerticalGroup(
            jPanelGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGridLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel2.add(jPanelGrid, java.awt.BorderLayout.CENTER);

        m_jPanelTitle.setLayout(new java.awt.BorderLayout());

        m_lblMessage.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_lblMessage.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, java.awt.Color.darkGray), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        m_jPanelTitle.add(m_lblMessage, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(m_jPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(m_jPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(358, 479));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdOKActionPerformed

        //m_value = m_jnumber.getValue();
        setVisible(false);
        dispose();

        
    }//GEN-LAST:event_jcmdOKActionPerformed

    private void jcmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdCancelActionPerformed

        setVisible(false);
        dispose();
        
    }//GEN-LAST:event_jcmdCancelActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        setVisible(false);
        dispose();
        
    }//GEN-LAST:event_formWindowClosing

    private void m_jKeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jKeysActionPerformed

    }//GEN-LAST:event_m_jKeysActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jInputPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelGrid;
    private javax.swing.JButton jcmdCancel;
    private javax.swing.JButton jcmdOK;
    private com.openbravo.editor.JEditorKeys m_jKeys;
    private javax.swing.JPanel m_jPanelTitle;
    private javax.swing.JLabel m_lblMessage;
    // End of variables declaration//GEN-END:variables
    
}
