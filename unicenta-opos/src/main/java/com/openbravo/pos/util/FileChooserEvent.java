//    KrOS POS  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2017 uniCenta
//    https://unicenta.com
//
//    This file is part of KrOS POS
//
//    KrOS POS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   KrOS POS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with KrOS POS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.JTextComponent;
import com.openbravo.pos.forms.AppLocal;

/**
 *
 * @author JG uniCenta
 */
public class FileChooserEvent implements ActionListener {
    
    private JTextComponent m_jTxtField;
    private JFileChooser m_fc;
    
    /** Creates a new instance of FileChooser
     * @param TxtField */
    public FileChooserEvent(JTextComponent TxtField) {
        m_jTxtField = TxtField;
        m_fc = new JFileChooser();
        
        m_fc.resetChoosableFileFilters();
        m_fc.addChoosableFileFilter(new FileFilter() {
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    String filename = f.getName();
                    return filename.endsWith(".jpg")
                        || filename.endsWith(".JPG")
                        || filename.endsWith(".png")
                        || filename.endsWith(".PNG");
                }
            }
            @Override
            public String getDescription() {
                return AppLocal.getIntString("filter.imgfile");
            }
        });
        m_fc.setFileSelectionMode(JFileChooser.FILES_ONLY );
    }
       
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        
        m_fc.setCurrentDirectory(new File(m_jTxtField.getText()));      
        if (m_fc.showOpenDialog(m_jTxtField) == JFileChooser.APPROVE_OPTION) {
            m_jTxtField.setText(m_fc.getSelectedFile().getAbsolutePath());
        }
    }       
    
}
