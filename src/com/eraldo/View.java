package com.eraldo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class View extends JFrame {
    private JTable table;
    private JButton button;
    public View(){

        setTitle("Sudoku Validator  ");

        table = new JTable(9,9);
        button = new JButton();
        button.setText("Check solution");

        table.setBounds(50, 60, 300, 300);
        table.setTableHeader(null);
        table.setRowHeight(42);
        JScrollPane sp = new JScrollPane(table);

        add(sp);
        setLayout(new FlowLayout());
        add(button);
        setSize(500, 500);
        setVisible(true);

        button.addActionListener(event -> {
            int[][] tableData = getJTableData();
            boolean rowsContain1To9 = SudokuController.rowsContain1To9(tableData);
            boolean columnsContain1to9 = SudokuController.columnsContain1To9(tableData);
            boolean gridsContain1to9 = SudokuController.gridsContain1to9(tableData);
            JPanel p = new JPanel();
            JOptionPane.showMessageDialog(null, (rowsContain1To9 && columnsContain1to9 && gridsContain1to9) ? "valid solution!" : "Incorrect Solution");

        });

    }

    public int[][] getJTableData(){
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
        int[][] tableData = new int[nRow][nCol];
        for (int i = 0 ; i < nRow ; i++)
            for (int j = 0 ; j < nCol ; j++ ){
                tableData[i][j] = Integer.parseInt((String) dtm.getValueAt(i, j));
            System.out.println(tableData[i][j]);
        }
        return tableData;
    }
}
