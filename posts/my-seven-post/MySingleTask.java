package com.abrenga.experiments;

public class MySingleTask implements Runnable {
    private final String name;

    public MySingleTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task [" + name + "] eseguito su thread " + Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }
    }
}
