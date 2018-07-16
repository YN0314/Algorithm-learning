package com.intheriv.algorithm.search;

import java.util.Collections;
import java.util.List;

import com.intheriv.algorithm.util.CommonUtils;
import com.intheriv.algorithm.util.IntArrayGenerator;
import com.intheriv.algorithm.util.ProcessingTimer;

public class LinerSearchLogic {
    
    // リターンコード
    static final int errorCode = -1;
    
    /**
     * メインメソッド
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        
        // ターゲット
        int target = 100001;
        // タイマーインスタンス生成、整数配列インスタンス生成
        ProcessingTimer timer = new ProcessingTimer();
        IntArrayGenerator generator = new IntArrayGenerator();
        CommonUtils utils = new CommonUtils();
        // 整数配列の生成
        timer.setStartTime();
        List<Integer> intArray = generator.generateIntArray(10000, 10000);
        System.out.println(timer.startTimeMessage() + ", " + timer.endTimeMessage() + ", " + timer.procTimeMessage());
        
        //generator.printIntArray(intArray);
        
        int arraySize = intArray.size() - 1;
        Collections.sort(intArray);
        
        System.out.println("----- 「単純」線形探索開始 -----");
        timer.setStartTime();
        int simpleLinerSearchResult = simpleLinerSearch(intArray, arraySize, target);
        utils.outputJudgeMessage(simpleLinerSearchResult, target, errorCode);
        System.out.println("----- 探索終了 -----");
        System.out.println(timer.startTimeMessage() + ", " + timer.endTimeMessage() + ", " + timer.procTimeMessage());
        
        System.out.println("");
        
        System.out.println("----- 「番兵」線形探索開始 -----");
        timer.setStartTime();
        int sentinelLinerSearchResult = sentinelLinerSeach(intArray, arraySize, target);
        utils.outputJudgeMessage(sentinelLinerSearchResult, target, errorCode);
        System.out.println("----- 探索終了 -----");
        System.out.println(timer.startTimeMessage() + ", " + timer.endTimeMessage() + ", " + timer.procTimeMessage());
        
    }

    
    
    /**
     * 単純な線形探索を行う。
     * 探索成功：上から順にターゲットとなる数値を比較し一致
     * 探索失敗：インクリメント値がリスト最大値に到達
     * @param List<Integer> a
     * @param int n
     * @param int target
     * @return int result
     */
    static int simpleLinerSearch(List<Integer> a, int n, int target) {
        int result;
        int errorJudgeTrialCount = 0;
        int successJudgeTrialCount = 0;
        int i = 0;
        while (true) {
            errorJudgeTrialCount++;
            if (i == n) {
                result = errorCode;
                break;
            }
            successJudgeTrialCount++;
            if (a.get(i) == target) {
                result = i;
                break;
            }
            i++;
        }
        System.out.println("探索失敗判定回数：" + errorJudgeTrialCount + ", 探索成功判定回数：" + successJudgeTrialCount);
        return result;
    }
    
    /**
     * 番兵を利用した線形探索を行う。番兵：リスト最後尾に配置したターゲット値
     * 探索成功：上から順にターゲットとなる数値を比較し一致
     * 探索失敗：上から順にターゲットとなる数値を比較し番兵と一致
     * @param List<Integer> a
     * @param int n
     * @param int target
     * @return int result
     */
    static int sentinelLinerSeach(List<Integer> a, int n, int target) {
        int result;
        int errorJudgeTrialCount = 0;
        int successJudgeTrialCount = 0;
        
        // 番兵の追加
        a.add(target);
        int i = 0;
        while (true) {
            // 番兵を利用した線形探索
            successJudgeTrialCount++;
            if (a.get(i) == target) {
                break;
            }
            i++;
        }
        errorJudgeTrialCount++;
        result = (i - 1) == n ? errorCode : i;
        System.out.println("探索失敗判定回数：" + errorJudgeTrialCount + ", 探索成功判定回数：" + successJudgeTrialCount);
        return result;
    }
}
