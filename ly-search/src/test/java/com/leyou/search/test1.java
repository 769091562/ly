package com.leyou.search;


import java.util.concurrent.*;

public class test1 {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));
        ExecutorService pool=Executors.newCachedThreadPool();


        MyThread myThread1 = new MyThread(1);

        MyThread myThread2 = new MyThread(2);

        threadPoolExecutor.execute(myThread1);
        threadPoolExecutor.execute(myThread2);

        //myThread1.start();
        //myThread2.start();
    }


    static class MyThread extends Thread {

        private int i;

        private long currentTime;

        MyThread(int i) {
            this.i = i;
        }

        @Override
        public void run() {

            for (int j = 0; j < 10; j++) {
                System.out.println("输出" + i + "=======" + System.currentTimeMillis() + "=======" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
