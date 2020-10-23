//    KrOS POS  - Open Source Point Of Sale
//    Copyright (c) 2009-2018 uniCenta
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

package com.openbravo.pos.payment;

import com.openbravo.pos.forms.AppLocal;
import javax.swing.JComponent;

public class PaymentPanelBasic extends javax.swing.JPanel implements PaymentPanel {

    private double m_dTotal;
    private String m_sTransactionID;
    private JPaymentNotifier m_notifier;
    
    /**
     * Creates new form PaymentPanelSimple
     */
    public PaymentPanelBasic(JPaymentNotifier notifier) {
        
        m_notifier = notifier;
        initComponents();
    }
    
    public JComponent getComponent() {
        return this;
    }
    
    public void activate(String sTransaction, double dTotal) {
        
        m_sTransactionID = sTransaction;
        m_dTotal = dTotal;
        
        jLabel1.setText(
                m_dTotal > 0.0
                ? AppLocal.getIntString("message.paymentgatewayext")
                : AppLocal.getIntString("message.paymentgatewayextrefund"));
        
        m_notifier.setStatus(true, true);            
    }
    
    public PaymentInfoMagcard getPaymentInfoMagcard() {

        if (m_dTotal > 0.0) {
            return new PaymentInfoMagcard(
                    "",
                    "", 
                    "",
                    null,
                    null,
                    null,
                    null,
                    null,
                    m_sTransactionID,
                    m_dTotal);
        } else {
            return new PaymentInfoMagcardRefund( 
                    "",
                    "", 
                    "",
                    null,
                    null,
                    null,
                    null, 
                    null,
                    m_sTransactionID,
                    m_dTotal);
        }
    } 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();

        add(jLabel1);

    }
    // </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
