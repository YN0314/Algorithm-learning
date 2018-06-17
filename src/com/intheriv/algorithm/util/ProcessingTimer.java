package com.intheriv.algorithm.util;

public class ProcessingTimer {
    
    static long startTime;
    static long endTime;
    
    static final String startMsgHeader = "開始時間：";
    static final String endMsgHeader = "終了時間：";
    static final String procMsgHeader = "処理時間：";
    static final String unit = "ms";
    
    // コンストラクタ
    public ProcessingTimer(){
        // インスタンス生成時の時間を取得
        startTime = System.currentTimeMillis();
    }
    
    public void setStartTime() {
        startTime = System.currentTimeMillis();
    }
    
    public String startTimeMessage() {
        return startMsgHeader + startTime + unit;
    }
    
    public String endTimeMessage() {
        endTime = System.currentTimeMillis();
        return endMsgHeader + endTime + unit;
    }
    
    public String procTimeMessage() {
        long procTime = endTime - startTime;
        return procMsgHeader + procTime + unit;
    }
}
