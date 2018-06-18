package com.intheriv.algorithm.util;

public class CommonUtils {
    
    // コンストラクタ
    public CommonUtils(){};
    
    /**
     * 判定処理：引数のresultがエラーコードと同一であればエラーメッセージ出力
     * @param int result
     * @param int target
     * @param int errorCode
     */
    public void outputJudgeMessage(int result, int target, int errorCode) {
        if (result == errorCode) {
            System.out.println("【探索失敗】ターゲット: " + target + "は、見つかりませんでした。");
        } else {
            System.out.println("【探索成功】ターゲット: " + target + ", 配置位置： " + (result + 1));
        }
    }

}
