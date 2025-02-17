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

package com.openbravo.pos.customers;

import com.openbravo.basic.BasicException;
import com.openbravo.data.gui.ListCellRendererBasic;
import com.openbravo.data.loader.ComparatorCreator;
import com.openbravo.data.loader.Vectorer;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.ListProvider;
import com.openbravo.data.user.ListProviderCreator;
import com.openbravo.data.user.SaveProvider;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.panels.JPanelTable;
import javax.swing.ListCellRenderer;

/**
 *
 * @author adrianromero
 */
public class CustomersPanel extends JPanelTable {
    
    private final DataLogicCustomers dlCustomers;
    private final CustomersView jeditor;
    
    /** Creates a new instance of CustomersPanel */
    public CustomersPanel() {    
//        CustomerInfoGlobal.getInstance().setEditableData(bd);
        this.jeditor = new CustomersView(app, dirty);
        this.dlCustomers  = (DataLogicCustomers) app.getBean("com.openbravo.pos.customers.DataLogicCustomers");
    }

    @Override
    protected void init() {}

    @Override
    public void activate() throws BasicException { 
        jeditor.activate();         
        super.activate();
    }

    @Override
    public ListProvider getListProvider() {
        return new ListProviderCreator(dlCustomers.getTableCustomers());
    }

    @Override
    public SaveProvider getSaveProvider() {
        return new SaveProvider(dlCustomers.getTableCustomers(), new int[] {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,            
            15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26});        
    }

    @Override
    public Vectorer getVectorer() {
        return dlCustomers.getTableCustomers().getVectorerBasic(new int[]{1, 2, 3, 4});
    }

    @Override
    public ComparatorCreator getComparatorCreator() {
        return dlCustomers.getTableCustomers().getComparatorCreator(new int[] {1, 2, 3, 4});
    }

    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(dlCustomers.getTableCustomers().getRenderStringBasic(new int[]{3}));
    }

    @Override
    public EditorRecord getEditor() {
        return jeditor;
    }

    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.CustomersManagement");
    }    
}
