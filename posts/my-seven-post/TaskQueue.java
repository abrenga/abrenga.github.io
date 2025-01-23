package com.abrenga.experiments;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Questa classe rappresenta la mia coda di task da eseguire
public class TaskQueue {
    private final BlockingQueue<Runnable> queue;

    public TaskQueue(int nTaskMassimi) {
        queue = new ArrayBlockingQueue<>(nTaskMassimi);
    }

    public Boolean addTask(Runnable task) {
        try {
            return queue.add(task);
        } catch (Exception e) {
            return false;
        }
    }

    public Runnable takeTask() {
        try {
            return queue.take();
        } catch (Exception e) {
            return null;
        }
    }
}