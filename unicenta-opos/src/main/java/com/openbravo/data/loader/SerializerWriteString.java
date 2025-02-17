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

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

import java.lang.reflect.Array;

/**
 *
 * @author JG uniCenta
 */
public class SerializerWriteString implements SerializerWrite<Object> {

    public static final SerializerWrite INSTANCE = new SerializerWriteString();
    private SerializerWriteString() {}

    public void writeValues(DataWrite dp, Object obj) throws BasicException {
        if (obj instanceof Object[]){
            Object[] objectos = (Object[]) obj;
            for (int i = 0 ; i < objectos.length ; i++) {
                Datas.STRING.setValue(dp, i+1, (String)objectos[i]);
            }
        }
        else {
            Datas.STRING.setValue(dp, 1, (String)obj);
        }

    }
}
