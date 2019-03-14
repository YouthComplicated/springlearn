package com.lanmo.aop;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author NJ
 * @date 2019/3/13 8:40
 */
public class DistrubuteApple {


    /**
     * 分苹果
     */
    public void distrubute(){
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++){
            pool.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        pool.shutdown();
    }

}
