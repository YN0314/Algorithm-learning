package com.intheriv.algorithm.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * int型スタックテスト
 * @author kraft
 */
public class IntStack {
    // クラス変数定義
    private int maximum;
    private int pointer;
    private int[] stack;
    private final int EMPTY = 0;
    
    /**
     * コンストラクタ
     * @param int capacity
     */
    public IntStack(int capacity) {
        pointer = 0;
        maximum = capacity;
        try {
            stack = new int[maximum];
        } catch (OutOfMemoryError ome) {
            System.out.println("スタックの初期化失敗！");
            maximum = 0;
        }
    }
    
    /**
     * プッシュメソッド
     * スタックに引数を格納, スタックがフルキャパの場合Exception
     * @param int x
     * @return int
     * @throws Exception
     */
    public int push(int x) throws OverFlowIntStackException {
        // スタックがフルキャパの場合、Exception スロー
        if (pointer >= maximum) {
            throw new OverFlowIntStackException();
        } else {
            return stack[pointer++] = x;
        }
    }
    
    /**
     * ポップメソッド
     * スタックから値を取り出す, スタックが空以下の場合Exception
     * @return int
     * @throws Exception
     */
    public int pop() throws EmptyIntStackException {
        if (pointer <= EMPTY) {
            throw new EmptyIntStackException();
        } else {
            return stack[--pointer];
        }
    }
    
    /**
     * ピークメソッド
     * スタックの最上位データを確認する, スタックが空以下の場合Exception
     * @return
     * @throws Exception
     */
    public int peek() throws EmptyIntStackException {
       if (pointer <= EMPTY) {
           throw new EmptyIntStackException();
       } else {
           return stack[pointer - 1];
       }
    }
    
    /**
     * スタック内の値検索
     * @param int x
     * @return int
     */
    public int indexOf(int x) {
        // 最上位ポインタから検索
        for (int i = pointer - 1; i >= EMPTY; i--) {
            if (stack[i] == x) {
                return i;
            } else {
                // 処理なし
            }
        }
        return -1;
    }
    
    /**
     * クリアメソッド
     * スタックを空にします.
     */
    public void clear() {
        pointer = 0;
    }
    
    /**
     * キャパシティ確認メソッド
     * スタックの最大値を返します.
     * @return int
     */
    public int capaicty() {
        return maximum;
    }
    
    /**
     * ポインタ確認メソッド
     * ポインタを確認します.
     * @return int
     */
    public int size() {
        return pointer;
    }
    
    /**
     * スタックの値がからか確認する.
     * @return int
     */
    public boolean isEmpty() {
        return pointer <= 0;
    }
    
    /**
     * スタックの値が満杯か確認する.
     * @return int
     */
    public boolean isFull() {
        return pointer >= maximum;
    }
    
    /**
     * スタックの中身を確認する.
     */
    public void dump() {
        if (pointer <= 0) {
            System.out.println("スタックは空です。");
        } else {
            for (int i = 0; i < pointer; i++) {
                System.out.print(stack[i] + ", ");
            }
            System.out.println("");
        }
    }
    
    /**
     * InnerExceptionClass
     * @author kraft
     */
    public class EmptyIntStackException extends RuntimeException {
        // 空のコンストラクタ
        public EmptyIntStackException() {};
    }
    
    /**
     * InnerExceptionClass
     * @author kraft
     */
    public class OverFlowIntStackException extends RuntimeException {
        // 空のコンストラクタ
        public OverFlowIntStackException() {};
    }

}
