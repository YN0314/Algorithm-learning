package com.intheriv.algorithm.stack;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import junit.framework.TestCase;

public class TestIntStack extends TestCase {
    // コンストラクタ
    public TestIntStack() {
        // 処理があれば追加
    }
    
    public void testIntStackCase01() throws Exception {
        int max = 64;
        Scanner stdIn = new Scanner(System.in);
        IntStack stack = new IntStack(max);
        
        System.out.println("スタックのテストを開始します。");
        
        while (true) {
            System.out.println("現在のデータ：" + stack.size() + "/" + stack.capaicty());
            System.out.println("(1):Push, (2):Pop, (3):Peek, (4):Dump, (5):FullStack, (0):Exit");
            System.out.print("Input> ");
            int menu = 0;
            try {
                menu = stdIn.nextInt();
            
            } catch (InputMismatchException ime){
                System.out.println("入力値が、整数ではありませんよ。処理を終了します。");
                return;
            }
            if (menu == 0) {
                System.out.println("処理を終了します。");
                return;
            } else {
                int x;
                switch(menu) {
                // Push
                case 1:
                    try {
                        System.out.println("プッシュデータ：");
                        System.out.print("push> ");
                        x = stdIn.nextInt();
                        System.out.println("スタックにデータ" + x + "を追加しました。");
                        stack.push(x);
                    } catch (IntStack.OverFlowIntStackException ofse) {
                        System.out.println("スタックが満杯です。");
                    } catch (InputMismatchException ime) {
                        System.out.println("入力値が、整数ではありませんよ。");
                    }
                    break;
                // Pop
                case 2:
                    try {
                        x = stack.pop();
                        System.out.println("ポップデータは、" + x + "です。");
                    } catch (IntStack.EmptyIntStackException eise) {
                        System.out.println("スタックが空です。");
                    }
                    break;
                // Peek
                case 3:
                    try {
                        x = stack.peek();
                        System.out.println("ピークデータは、" + x + "です。");
                    } catch (IntStack.EmptyIntStackException eise) {
                        System.out.println("スタックが空です。");
                    }
                    break;
                case 4:
                    System.out.println(" ---------- 現在のスタック状況 ---------- ");
                    stack.dump();
                    System.out.println(" ------------------------------------ ");
                    break;
                case 5:
                    System.out.println("スタックを強制的にフルスタック状態にします。");
                    for (int i = 0; i < max; i++) {
                        Random rand = new Random();
                        int pushData = rand.nextInt(1000);
                        try {
                            stack.push(pushData);
                        } catch (IntStack.OverFlowIntStackException ofse) {
                            System.out.println("スタックが満杯になりました。");
                            break;
                        }
                    }
                default:
                    System.out.println("想定外の値が入力されています。正常な値を入力してください。");
                    break;
                }
            }
        }
    }
}
