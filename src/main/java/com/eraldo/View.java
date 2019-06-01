package com.eraldo;

import controllers.ThreadController;
import exceptions.IntegerParseException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class View extends JFrame {
    private JTable table;
    private JButton button;
    private ThreadController threadManager;

    public View() {

        setTitle("Sudoku Validator");
        setLayout(new FlowLayout());
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        table = new JTable(9, 9);
        table.setBounds(50, 60, 300, 300);
        table.setTableHeader(null);
        table.setRowHeight(44);
        table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        JScrollPane scrollPane = new JScrollPane(table);

        button = new JButton();
        button.setText("Validate Solution");

        add(scrollPane);
        add(button);


        threadManager = new ThreadController();

        button.addActionListener(event -> {
            int[][] tableData = getDataFromJtable();
            if (tableData != null) {
                boolean result = threadManager.getResultFromSuokuData(tableData);
                JOptionPane.showMessageDialog(null, result ? "CORRECT!" : "INCORRECT!");
            }
        });
    }

    private int[][] getDataFromJtable() {
        int[][] tableData = new int[9][9];
        try {
            tableData = getJTableData();
            return tableData;
        } catch (IntegerParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    private int[][] getJTableData() throws IntegerParseException {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        int nrOfRows = tableModel.getRowCount();
        int nrOfCols = tableModel.getColumnCount();
        int[][] tableData = new int[nrOfRows][nrOfCols];
        for (int i = 0; i < nrOfRows; i++)
            for (int j = 0; j < nrOfCols; j++) {
                try {
                    tableData[i][j] = Integer.parseInt((String) tableModel.getValueAt(i, j));
                } catch (Exception ex) {
                    throw new IntegerParseException("Incorrect input (numbers 1 to 10 only!)");
                }
            }
        return tableData;
    }
}
