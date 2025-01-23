package com.abrenga.experiments;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int nTask = 8;
        int nThreads = 4;
        MyThreadPool myThreadPool = new MyThreadPool(nThreads, nTask);

        for (int i = 0; i < nTask; i++) {
            myThreadPool.submit(new MySingleTask("Task#" + i));
        }

        Thread.sleep(10000);

        myThreadPool.shutdown();
        System.out.println("ThreadPool shutdown complete.");
    }
}
