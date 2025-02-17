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

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.SerializableRead;
import com.openbravo.format.Formats;

public class PaymentInfoTicket extends PaymentInfo implements SerializableRead {

    private static final long serialVersionUID = 8865238639097L;
    
    private double m_dTicket;
    private String m_sName;
    private String m_transactionID;
    private double m_dTendered;
    private String m_dCardName;
    private String m_sVoucher;

    /**
     * Used by with: Cheque, Bank , Slip
     *
     * @param dTicket
     * @param sName
     */
    public PaymentInfoTicket(double dTicket, String sName) {
        this(0.0, sName, null, null);
    }

    /**
     * Used by with: Voucher
     *
     * @param dTicket
     * @param sName
     * @param transactionID
     * @param sVoucher
     */
    public PaymentInfoTicket(double dTicket, String sName, String transactionID, String sVoucher) {
        m_sName = sName;
        m_dTicket = dTicket;
        m_transactionID = transactionID;
        m_sVoucher = sVoucher;
        m_dCardName = null;
        m_dTendered = 0.00;

    }

    /**
     * Used by with: Voucher
     *
     * @param dTicket
     * @param sName
     * @param sVoucher
     */
    public PaymentInfoTicket(double dTicket, String sName, String sVoucher) {
        this(dTicket, sName, null, sVoucher);
    }

    public PaymentInfoTicket() {
        this(0.0, null, null, null);
    }

    @Override
    public void readValues(DataRead dr) throws BasicException {
        m_sName = dr.getString(1);
        m_dTicket = dr.getDouble(2);
        m_transactionID = dr.getString(3);
        if (dr.getDouble(4) != null) {
            m_dTendered = dr.getDouble(4);
        }
        m_dCardName = dr.getString(5);    
    }

    @Override
    public PaymentInfo copyPayment() {
        return new PaymentInfoTicket(m_dTicket, m_sName);
    }

    @Override
    public String getName() {
        return m_sName;
    }

    @Override
    public double getTotal() {
        return m_dTicket;
    }

    @Override
    public String getTransactionID() {
        return m_transactionID;
    }

    @Override
    public double getPaid() {
        return (0.0);
    }

    @Override
    public double getChange() {
        return m_dTendered - m_dTicket;
    }

    @Override
    public double getTendered() {
        return (0.0);
    }

    @Override
    public String getCardName() {
        return m_dCardName;
    }

    public String printPaid() {
        return Formats.CURRENCY.formatValue(m_dTicket);
    }

    public String printVoucherTotal() {
        return Formats.CURRENCY.formatValue(-m_dTicket);
    }

    public String printChange() {
        return Formats.CURRENCY.formatValue(m_dTendered - m_dTicket);
    }

    public String printTendered() {
        return Formats.CURRENCY.formatValue(m_dTendered);
    }

    @Override
    public String getVoucher() {
        return m_sVoucher;
    }

    public String printVoucher() {
        return m_sVoucher;
    }
}
