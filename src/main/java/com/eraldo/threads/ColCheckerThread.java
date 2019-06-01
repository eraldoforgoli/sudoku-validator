package com.eraldo.threads;

import com.eraldo.Util;


public class ColCheckerThread implements Runnable {
    private volatile boolean result;
    private String threadName;
    private ColCheckerThread thread;
    private int[][] sudokuData;

    public ColCheckerThread(String threadName, int[][] sudokuData) {
        this.sudokuData = sudokuData;
        threadName = threadName;
    }

    @Override
    public void run() {
        result = Util.allColumnsContain1To9(sudokuData);
    }

    public boolean getThreadValue() {
        return this.result;
    }
}
