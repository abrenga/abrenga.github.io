package com.abrenga.experiments;

public class MyThread extends java.lang.Thread {
    private final TaskQueue taskQueue;
    private boolean running;

    public MyThread(TaskQueue taskQueue) {
        this.taskQueue = taskQueue;
        this.running = false;
    }

    @Override
    public void run() {
        this.running = true;

        while (running) {
            try {

                Runnable myTask = taskQueue.takeTask();
                if (myTask != null) {
                    myTask.run();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void shutdown() {
        running = false;
        this.interrupt();
    }
}