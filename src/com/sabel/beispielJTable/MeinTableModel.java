package com.sabel.beispielJTable;

import javax.swing.table.AbstractTableModel;

/**
 * Created by m.strohmayer on 08.05.2017.
 */
public class MeinTableModel extends AbstractTableModel {
    private String[] spaltenNamen = {"Name", "Alter"};
    private Datenbank datenbank;

    public MeinTableModel(Datenbank datenbank) {
        this.datenbank = datenbank;
    }

    @Override
    public int getRowCount() {
        return datenbank.size();
    }

    @Override
    public int getColumnCount() {
        return spaltenNamen.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = datenbank.findePerson(rowIndex);
        switch (columnIndex) {
            case 0:
                return person.getName();
            case 1:
                return person.getAlter();
            case 2:
                return person.getUuid().toString();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return spaltenNamen[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            case 2:
                return Boolean.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Person person = datenbank.findePerson(rowIndex);
        switch (columnIndex) {
            case 0:
                person.setName((String) aValue);
                break;
            case 1:
                person.setAlter( new Integer(aValue.toString()));
                break;
            case 2:
                break;
        }
    }

    public void neuePerson() {
        datenbank.hinzufuegen(new Person());
    }
    public void loeschePerson(String uuid) {
        System.out.println(uuid);
        datenbank.loeschePerson(uuid);
    }
}
