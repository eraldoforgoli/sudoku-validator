package com.eraldo;

import java.util.HashMap;
import java.util.Map;

public class Util {
    private static final int NR_OF_GRIDS = 9;
    private static final int NR_OF_ROWS_PER_GRID = 3;
    private static final int NR_OF_COLS_PER_GRID = 3;
    private static final int SUDOKU_VALID_NUMBERS = 9;

    public static boolean allRowsContain1To9(int[][] sudoku2DArray) {
        for (int i = 0; i < sudoku2DArray.length; i++) {
            Map<Integer, Boolean> defaultNumbers = Util.getDefault1To9Map();
            for (int j = 0; j < sudoku2DArray.length; j++) {
                if (isDublicateNumber(defaultNumbers, sudoku2DArray[i][j]))
                    return false;
                else
                    setNumberStatusToFound(defaultNumbers, sudoku2DArray[i][j]);
            }
        }
        return true;
    }

    public static boolean allColumnsContain1To9(int[][] sudoku2DArray) {
        for (int i = 0; i < sudoku2DArray.length; i++) {
            Map<Integer, Boolean> defaultNumbers = Util.getDefault1To9Map();
            for (int j = 0; j < sudoku2DArray.length; j++) {
                if (isDublicateNumber(defaultNumbers, sudoku2DArray[j][i]))
                    return false;
                else
                    setNumberStatusToFound(defaultNumbers, sudoku2DArray[j][i]);
            }
        }
        return true;
    }

    public static boolean all3X3GridsContain1to9(int[][] sudoku2DArray) {
        for (int gridNr = 0; gridNr < NR_OF_GRIDS; gridNr++) {
            Map<Integer, Boolean> defaultNumbers = Util.getDefault1To9Map();
            for (int gridRow = 0; gridRow < NR_OF_ROWS_PER_GRID; gridRow++) {
                for (int gridCol = 0; gridCol < NR_OF_COLS_PER_GRID; gridCol++) {
                    int row = (gridNr / NR_OF_COLS_PER_GRID) * NR_OF_ROWS_PER_GRID + gridRow;
                    int col = (gridNr % NR_OF_ROWS_PER_GRID) * NR_OF_COLS_PER_GRID + gridCol;
                    if (isDublicateNumber(defaultNumbers, sudoku2DArray[row][col]))
                        return false;
                    else
                        setNumberStatusToFound(defaultNumbers, sudoku2DArray[row][col]);
                }
            }
        }
        return true;
    }

    private static boolean isDublicateNumber(Map<Integer, Boolean> numbers, int number) {
        return numbers.get(number) == true;
    }

    private static void setNumberStatusToFound(Map<Integer, Boolean> numbers, int number) {
        numbers.put(number, true);
    }

    public static Map getDefault1To9Map() {
        Map<Integer, Boolean> defaultNumbers = new HashMap<Integer, Boolean>();
        for (int i = 0; i < SUDOKU_VALID_NUMBERS; i++) {
            defaultNumbers.put(i + 1, false);
        }
        return defaultNumbers;
    }
}
