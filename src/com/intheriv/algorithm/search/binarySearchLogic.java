package com.intheriv.algorithm.search;

import java.util.ArrayList;
import java.util.List;

public class binarySearchLogic {

    static Integer binarySearch(List<Integer> a, int n , int key) {
        int low = 0;
        int hi = n - 1;
        
        do {
            int middle = (low + hi) / 2;
            if (a.get(middle) == key) {
                return middle;
            } else if (a.get(middle) < key) {
                low = middle + 1;
            } else {
                hi = middle - 1;
            }
        } while(low <= hi);
        return -1;
    }
    
    public static void main(String[] args) {
        int target = 92;
        List<Integer> intArray = new ArrayList<Integer>() {
            {
                add(15);
                add(27);
                add(39);
                add(77);
                add(92);
                add(108);
                add(121);
            }
        };
        
        int arraySize = intArray.size() - 1;
        int result = binarySearch(intArray,arraySize,target);
        
        if (result == -1) {
            System.out.println("Not Found! Target: " + target);
        } else {
            System.out.println("Im found! Target: " + target + ", Index: " + result);
        }
    }

}
