package com.eraldo.thread;

import com.eraldo.Util;

public class RowCheckerThread implements Runnable {
    private volatile boolean result;
    private String threadName;
    private RowCheckerThread thread;
    private int[][] sudokuData;

    public RowCheckerThread(String threadName, int[][] sudokuData) {
        this.sudokuData = sudokuData;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        result = Util.allRowsContain1To9(sudokuData);
    }

    public boolean getThreadValue() {
        return this.result;
    }
}
