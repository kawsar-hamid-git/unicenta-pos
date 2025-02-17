//    KrOS POS  - Open Source Point Of Sale
//    Copyright (c) 2021 poolborges
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

package com.openbravo.pos.admin;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.IKeyed;
import com.openbravo.data.loader.SerializableRead;

/**
 *
 * @author pauloborges
 */
public class ResourceInfo implements SerializableRead, IKeyed {
    
    private static final long serialVersionUID = 9110127845966L;
    
    private String id;
    private String name;
    private int restype;
    private byte[] content;

    @Override
    public void readValues(DataRead dr) throws BasicException {
        id = dr.getString(1);
        name = dr.getString(2);
        restype = dr.getInt(3);
        content = dr.getBytes(4);
    }

    @Override
    public Object getKey() {
        return id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRestype() {
        return restype;
    }

    public byte[] getContent() {
        return content;
    }
}
