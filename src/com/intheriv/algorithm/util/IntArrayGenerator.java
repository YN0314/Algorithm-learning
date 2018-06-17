package com.intheriv.algorithm.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IntArrayGenerator {
    /**
     * 整数配列の生成
     * リストサイズと数値最大値を指定
     * @param int size
     * @param int max
     * @return List<Integer> list
     */
    public List<Integer> generateIntArray(int size, int max) {
        List<Integer> list = new ArrayList<Integer>();
        Random rand = new Random();
        
        for (int i = 0; i < size - 1; i++) {
            int element = rand.nextInt(max);
            if (!list.contains(element)) {
                list.add(element);
            }
        }
        System.out.println("サイズ： " + size + ",最大値： " + max + "の整数配列を生成。");
        return list;
    }
    
    /**
     * 整数配列の表示
     * @param List<Integer> list
     */
    public void printIntArray(List<Integer> list) {
        StringBuilder str = new StringBuilder();
        System.out.print("配列は、[");
        for (int i : list) {
            str.append(i).append(" ");
        }
        System.out.println(str + "]");
    }
}
