package com.sabel.beispielJTable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.TableRowSorter;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.YES_OPTION;

/**
 * Created by m.strohmayer on 08.05.2017.
 */
public class Fenster extends JFrame {
    private Container c;
    private JTable jTable;
    private JScrollPane jScrollPane;
    private JPanel jpSouth;
    private MeinTableModel model;
    private JButton jbNeu, jbLoeschen;

    public Fenster() throws HeadlessException {
        super("Beispiel JTable");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.initComponents();
        this.initEvents();
        this.pack();
        this.setVisible(true);
    }

    private void initEvents() {
        this.jbNeu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                neu();
            }
        });
        this.jbLoeschen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loeschen();
            }
        });
    }

    private void loeschen() {
        int selectetRow = jTable.getSelectedRow();
        if (selectetRow < 0) {
            return;
        }
        int result = JOptionPane.showConfirmDialog(this,"Wollen Sie die ausgewählte Person wirklich löschen");
        if (result == YES_OPTION) {
            int modelRow = jTable.convertRowIndexToModel(selectetRow);
            System.out.println("selectedRow: "+ selectetRow);
            System.out.println("modelRow: "+ modelRow);
            model.loeschePerson((String) model.getValueAt(selectetRow,2));
            model.fireTableDataChanged();
        }
    }

    private void neu(){
        model.neuePerson();
        model.fireTableDataChanged();
    }

    private void initComponents() {
        c = this.getContentPane();
        model = new MeinTableModel(Datenbank.erzeugeTestDatenbank());
        jTable = new JTable(model);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable.setRowSorter(new TableRowSorter<>(model));
        jScrollPane = new JScrollPane(jTable);
        c.add(jScrollPane, BorderLayout.CENTER);

        jpSouth = new JPanel();
        jbNeu = new JButton("Neu");
        jbLoeschen = new JButton("Löschen");
        jpSouth.add(jbNeu);
        jpSouth.add(jbLoeschen);

        c.add(jpSouth, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new Fenster();
    }
}
