package com.eraldo.threads;

import com.eraldo.Util;

public class GridsCheckerThread implements Runnable {
    private volatile boolean result;
    private String threadName;
    private GridsCheckerThread thread;
    private int[][] sudokuData;

    public GridsCheckerThread(String threadName, int[][] sudokuData) {
        this.sudokuData = sudokuData;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        result = Util.all3X3GridsContain1to9(sudokuData);
    }

    public boolean getThreadValue() {
        return this.result;
    }
}
