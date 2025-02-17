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
package com.openbravo.pos.forms;

import com.openbravo.pos.instance.AppMessage;
import java.rmi.RemoteException;
import javax.swing.JFrame;

import java.util.logging.Logger;

/**
 *
 * @author adrianromero
 */
public class JRootKiosk extends javax.swing.JFrame implements AppMessage {

    private static final Logger LOGGER = Logger.getLogger(JRootFrame.class.getName());

    private final JRootApp m_rootapp;

    /**
     * Creates new form JRootKiosk
     * @param props
     */
    public JRootKiosk(AppProperties props) {
        m_rootapp = new JRootApp(props);
        initComponents();
        setupComponents();
    }
    
    private void setupComponents(){
    
        setUndecorated(true);
        setResizable(false);
    }

    @Override
    public void restoreWindow() throws RemoteException {
        java.awt.EventQueue.invokeLater(() -> {
            if (getExtendedState() == JFrame.ICONIFIED) {
                setExtendedState(JFrame.NORMAL);
            }
            requestFocus();
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        LOGGER.info("Windows closing");
        m_rootapp.tryToClose();

    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

        LOGGER.info("Windows closed");
        m_rootapp.releaseResources();
        System.exit(0);

    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
