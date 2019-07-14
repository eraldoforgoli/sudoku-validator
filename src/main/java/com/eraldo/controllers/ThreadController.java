package controllers;

import com.eraldo.threads.ColCheckerThread;
import com.eraldo.threads.GridsCheckerThread;
import com.eraldo.threads.RowCheckerThread;

public class ThreadController {
    public boolean getResultFromSuokuData(int[][] sudokuData) {
        boolean rowResult = getResultFromRows(sudokuData);
        boolean colResult = getResultFromCols(sudokuData);
        boolean gridResult = getResultFrom3X3Grids(sudokuData);
        return (colResult && rowResult && gridResult);
    }

    private boolean getResultFromCols(int[][] sudokuData) {
        ColCheckerThread colCheckerThread = new ColCheckerThread("Check if all cols contain 1 to 9", sudokuData);
        Thread colThread = new Thread(colCheckerThread);
        colThread.start();
        waitForThreadToComplete(colThread);
        return colCheckerThread.getThreadValue();
    }

    private boolean getResultFromRows(int[][] sudokuData) {
        RowCheckerThread rowCheckerThread = new RowCheckerThread("Check if all rows contain 1 to 9", sudokuData);
        Thread rowThread = new Thread(rowCheckerThread);
        rowThread.start();
        waitForThreadToComplete(rowThread);
        return rowCheckerThread.getThreadValue();
    }

    private boolean getResultFrom3X3Grids(int[][] sudokuData) {
        GridsCheckerThread gridCheckerThread = new GridsCheckerThread("Check if all 3X3 grids contain 1 to 9", sudokuData);
        Thread gridThread = new Thread(gridCheckerThread);
        gridThread.start();
        waitForThreadToComplete(gridThread);
        return gridCheckerThread.getThreadValue();
    }

    public void waitForThreadToComplete(Thread thread) {
        try {
            thread.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
