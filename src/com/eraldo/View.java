package com.eraldo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class View extends JFrame {
    private JTable table;
    private JButton button;

    public View(){

        setTitle("Sudoku Validator");
        setLayout(new FlowLayout());
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        table = new JTable(9,9);
        table.setBounds(50, 60, 300, 300);
        table.setTableHeader(null);
        table.setRowHeight(42);
        table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        JScrollPane scrollPane = new JScrollPane(table);

        button = new JButton();
        button.setText("Validate Solution");

        add(scrollPane);
        add(button);

        button.addActionListener(event -> {
            int[][] tableData = getDataFromJtable();
            if(tableData != null) {
                boolean rowsContain1To9 = SudokuController.allRowsContain1To9(tableData);
                boolean columnsContain1to9 = SudokuController.allColumnsContain1To9(tableData);
                boolean gridsContain1to9 = SudokuController.allGridsContain1to9(tableData);
                JOptionPane.showMessageDialog(null, (rowsContain1To9 && columnsContain1to9 && gridsContain1to9) ? "valid solution!" : "Incorrect Solution");
            }
        });
    }

    private int[][] getDataFromJtable(){
        int[][] tableData = new int[9][9];
        try {
            tableData = getJTableData();
            return tableData;
        } catch(IntegerParseException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    private int[][] getJTableData() throws IntegerParseException {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        int nrOfRows = tableModel.getRowCount();
        int nrOfCols = tableModel.getColumnCount();
        int[][] tableData = new int[nrOfRows][nrOfCols];
        for (int i = 0 ; i < nrOfRows ; i++)
            for (int j = 0 ; j < nrOfCols ; j++ ){
                try {
                    tableData[i][j] = Integer.parseInt((String) tableModel.getValueAt(i, j));
                } catch(Exception ex){
                    throw new IntegerParseException("Incorrect input (numbers 1 to 10 only!)");
                }
            }
        return tableData;
    }
}
