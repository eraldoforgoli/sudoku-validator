package com.eraldo.threads;

import com.eraldo.Util;

public class RowCheckerThread implements Runnable {
    private volatile boolean result;
    private String threadName;
    private RowCheckerThread thread;
    private int[][] sudokuData;

    public RowCheckerThread(String threadName, int[][] sudokuData) {
        this.sudokuData = sudokuData;
        threadName = threadName;
    }

    @Override
    public void run() {
        result = Util.allRowsContain1To9(sudokuData);
    }

    public boolean getThreadValue() {
        return this.result;
    }
}
