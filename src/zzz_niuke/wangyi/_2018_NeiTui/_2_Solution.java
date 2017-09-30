package zzz_niuke.wangyi._2018_NeiTui;

import java.io.*;
import java.util.* ;

/**
 * Created by tangjialiang on 2017/9/28.
 */
public class _2_Solution{
    private ArrayList<Integer> inputNums = new ArrayList<>() ;
    private int inputLen = -1 ;

    private void work() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));

        // input
        String input1 = null ;
        String input2 = null ;
        try {
            input1 = br.readLine() ;
            input2 = br.readLine() ;
        } catch(Exception e) {

        }

        inputLen = Integer.parseInt(input1) ;
        String[] words = input2.split(" ") ;
        for(int i=0; i<inputLen; i++) {
            int i1 = Integer.parseInt(words[i]);
            inputNums.add(i, i1);
        }

        // do work
        Collections.sort(inputNums) ;
        boolean ans = isSameDiff() ;

        // output
        if (ans) {
            System.out.println("Possible") ;
        } else {
            System.out.println("Impossible") ;
        }
    }

    private boolean isSameDiff() {
        if (inputNums.size() <= 1) return true ;

        int diff = inputNums.get(1) - inputNums.get(0) ;
        for(int i=1; i<inputLen; i++) {
            if (inputNums.get(i) - inputNums.get(i-1) != diff) return false ;
        }

        return true ;
    }

    public static void main(String[] args) {
        _2_Solution sol = new _2_Solution() ;
        sol.work() ;
    }
}