package com.intheriv.algorithm.search;

import java.util.Collections;
import java.util.List;

import com.intheriv.algorithm.util.CommonUtils;
import com.intheriv.algorithm.util.IntArrayGenerator;
import com.intheriv.algorithm.util.ProcessingTimer;

public class BinarySearchLogic {

    static final int errorCode = -1;
    
    public static void main(String[] args) {
        int target = 899;
        
        ProcessingTimer timer = new ProcessingTimer();
        IntArrayGenerator generator = new IntArrayGenerator();
        CommonUtils utils = new CommonUtils();
        
        timer.setStartTime();
        List<Integer> intArray = generator.generateIntArray(10000, 10000);
        System.out.println(timer.startTimeMessage() + ", " + timer.endTimeMessage() + ", " + timer.procTimeMessage());
        
        int arraySize = intArray.size() - 1;
        
        // ソートが前提
        Collections.sort(intArray);
        
        timer.setStartTime();
        System.out.println("----- 二分探索開始 -----");
        int result = binarySearch(intArray,arraySize,target);
        System.out.println("----- 二分探索終了 -----");
        System.out.println(timer.startTimeMessage() + ", " + timer.endTimeMessage() + ", " + timer.procTimeMessage());
        
        utils.outputJudgeMessage(result, target, errorCode);
    }

    /**
     * 
     * @param list
     * @param size
     * @param target
     * @return
     */
    static Integer binarySearch(List<Integer> list, int size , int target) {
        int low = 0;
        int hi = size - 1;
        ProcessingTimer timer = new ProcessingTimer();
        
        // 試行回数を取得
        int errorJudgeTrialCount = 0;
        int successJudgeTrialCount = 0;
        
        do {
            // 中央値インデックスを取得
            int middle = (low + hi) / 2;
            // 中央値インデックスの配列値の検証
            successJudgeTrialCount++;
            if (list.get(middle) == target) {
                System.out.println("探索失敗判定回数：" + errorJudgeTrialCount + ", 探索成功判定回数：" + successJudgeTrialCount);
                return middle;
            } else if (list.get(middle) < target) {   // ターゲット値の方が大きい場合、下限値を再設定
                low = middle + 1;
            } else {                                  // ターゲット値の方が小きい場合、上限値を再設定
                hi = middle - 1;
            }
        } while(low <= hi);                           // 下限値と上限値が上回ったらブレイク
        errorJudgeTrialCount++;
        
        System.out.println("探索失敗判定回数：" + errorJudgeTrialCount + ", 探索成功判定回数：" + successJudgeTrialCount);
        return errorCode;
    }
}
