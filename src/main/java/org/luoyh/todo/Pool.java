package org.luoyh.todo;

import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <p>Created: Jan 31, 2018 3:07:31 PM</p>
 * 
 * @author luoyh(Roy)
 * @version 1.0
 * @since 1.8
 */
public class Pool {
    
    private static final ExecutorService executor = Executors.newCachedThreadPool();
    private static final ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();

    private int index = 0;
    private TaskPool[] pool = new TaskPool[3600];
    
    public static void main(String[] args) {
        new Pool().init();
    }
    
    // delay = s
    public void push(int delay, Callback callback) {
        delay = delay + index;
        int pIdex = delay % 3600;
        TaskPool tp = pool[pIdex];
        if (null == tp) {
            tp = new TaskPool();
            pool[pIdex] = tp;
        }
        Task task = new Task();
        task.setIndex(delay / 3600);
        task.setCallback(callback);
        tp.getPool().add(task);
    }
    
    public void init() {
        // schedule.
        schedule.scheduleAtFixedRate(() -> {
            index = ++ index % 3600;
            TaskPool taskPool = pool[index];
            if (null != taskPool) {
                Iterator<Task> tasks = taskPool.getPool().iterator();
                while (tasks.hasNext()) {
                    Task task = tasks.next();
                    int idx = task.getIndex();
                    idx --;
                    if (idx <= 0) {
                        executor.execute(() -> {
                            task.getCallback().execute();
                        });
                        tasks.remove();
                    }
                    task.setIndex(idx);
                }
            }
        }, 1, 1, TimeUnit.SECONDS);
    }
    
    public int getIndex() {
        return index;
    }
    
}
