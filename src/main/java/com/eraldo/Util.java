package com.eraldo;

import java.util.HashMap;
import java.util.Map;

public class Util {
    public static Map getDefault1To9Map(){
        Map<Integer, Boolean> defaultNumbers = new HashMap<Integer, Boolean>();
        for(int i = 0; i < 9; i++){
            defaultNumbers.put(i+1, false);
        }
        return  defaultNumbers;
    }
}
