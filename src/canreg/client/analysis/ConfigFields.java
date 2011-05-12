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

package canreg.client.analysis;

import java.util.LinkedList;

public class ConfigFields {

    private String fieldName;
    private LinkedList<String> listOfValues;

    public ConfigFields(String name) {
        fieldName = name;
        listOfValues = new LinkedList();
    }

    /**
     * @return the listOfValues
     */
    public LinkedList<String> getListOfValues() {
        return listOfValues;
    }

    public void addValue(String value) {
        listOfValues.add(value);
    }

    public boolean containsValue(String name) {
        for (String fieldNameString : listOfValues) {
            if (fieldNameString.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public String getFieldName() {
        return fieldName;
    }
}
