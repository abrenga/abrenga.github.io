package com.abrenga.experiments;

import java.util.ArrayList;
import java.util.List;

public class MyThreadPool {
    private List<MyThread> threads;
    private TaskQueue taskQueue;

    public MyThreadPool(int nThread, int nTask) {
        threads = new ArrayList<>();

        taskQueue = new TaskQueue(nTask);

        for (int i = 0; i < nThread; i++) {
            MyThread myThread = new MyThread(taskQueue);
            threads.add(myThread);
            myThread.start();
        }
    }

    public Boolean submit(Runnable task) {
        return taskQueue.addTask(task);
    }

    public void shutdown() {
        for (MyThread thread : threads) {
            thread.shutdown();
        }
    }
}
