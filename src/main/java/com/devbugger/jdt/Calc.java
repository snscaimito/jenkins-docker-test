package com.devbugger.jdt;

/**
 * Created by Dag Østgulen Heradstveit.
 */
public class Calc {

    public int calc(int high, int low) {
        return (low + high) >>> 1;
    }
}
