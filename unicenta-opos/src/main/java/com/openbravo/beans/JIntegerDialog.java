//    KrOS POS  - Open Source Point Of Sale
//    Copyright (c) 2009-2018 uniCenta - joint with Jacinto Rodriguez
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

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.Icon;
import javax.swing.SwingUtilities;

/**
 * Dec 2017
 * @author  Jack Gerarrd uniCenta
 */
public class JIntegerDialog extends JNumberDialog<Integer> {

    public JIntegerDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        m_jnumber = new com.openbravo.editor.JEditorIntegerPositive();
        init();
    }

    public JIntegerDialog(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        m_jnumber = new com.openbravo.editor.JEditorIntegerPositive();
        init();
    }
    
    private void init() {
        m_jnumber.setValue(1);
        setup();
    }

    public static Integer showComponent(Component parent, String title) {
        return showComponent(parent, title, null, null);
    }
    public static Integer showComponent(Component parent, String title, String message) {
        return showComponent(parent, title, message, null);
    }
    public static Integer showComponent(Component parent, String title, String message, Icon icon) {
        
        Window window = SwingUtilities.windowForComponent(parent);
        
        JIntegerDialog entryDialog;
        if (window instanceof Frame) { 
            entryDialog = new JIntegerDialog((Frame) window, true);
        } else {
            entryDialog = new JIntegerDialog((Dialog) window, true);
        }
        
        entryDialog.setTitle(title, message, icon);
        entryDialog.setVisible(true);
        
        return entryDialog.getValue();
    }

}
