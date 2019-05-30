package com.eraldo;

import java.util.Map;
import com.eraldo.Util;

public class SudokuController {
    public  boolean allRowsContain1To9(int[][] sudoku2DArray){
        for(int i = 0; i < sudoku2DArray.length; i++){
            Map<Integer, Boolean> defaultNumbers = Util.getDefault1To9Map();
            for(int j = 0; j < sudoku2DArray.length; j++){
                if(isDublicateNumber(defaultNumbers, sudoku2DArray[i][j]))
                    return false;
                else
                    setNumberStatusToFound(defaultNumbers, sudoku2DArray[i][j]);
            }
        }
        return true;
    }

    public boolean allColumnsContain1To9(int[][] sudoku2DArray){
        for(int i = 0; i < sudoku2DArray.length; i++){
            Map<Integer, Boolean> defaultNumbers = Util.getDefault1To9Map();
            for(int j = 0; j < sudoku2DArray.length; j++){
                if(isDublicateNumber(defaultNumbers, sudoku2DArray[j][i]))
                    return false;
                else
                    setNumberStatusToFound(defaultNumbers, sudoku2DArray[j][i]);
            }
        }
        return true;
    }

    public boolean allGridsContain1to9(int[][] sudoku2DArray){
        for(int gridNr = 0; gridNr < 9; gridNr++){
            Map<Integer, Boolean> defaultNumbers = Util.getDefault1To9Map();
            for(int gridRow = 0; gridRow < 3; gridRow++){
                for(int gridCol = 0; gridCol < 3; gridCol++){
                    int row = (gridNr/3)*3 + gridRow;
                    int col = (gridNr%3)*3 + gridCol;
                    if(isDublicateNumber(defaultNumbers, sudoku2DArray[row][col]))
                        return false;
                    else
                        setNumberStatusToFound(defaultNumbers, sudoku2DArray[row][col]);
                }
            }
        }
        return true;
    }

    private boolean isDublicateNumber(Map<Integer, Boolean> numbers, int number){
        return numbers.get(number) == true;
    }

    private void setNumberStatusToFound(Map<Integer, Boolean> numbers, int number){
        numbers.put(number,  true);
    }
}
