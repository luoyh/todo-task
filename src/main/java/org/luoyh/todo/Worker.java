package org.luoyh.todo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <p>Created: Jan 31, 2018 3:15:37 PM</p>
 * 
 * @author luoyh(Roy)
 * @version 1.0
 * @since 1.8
 */
public class Worker {

    private static final ExecutorService executor = Executors.newCachedThreadPool();
    private static final ExecutorService worker = Executors.newFixedThreadPool(1);
    private static final ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();
    
    public static void main(String[] args) {
        new Worker().init();
    }
    
    public void init() {
        // schedule.
        schedule.scheduleAtFixedRate(() -> {
            System.out.println(System.currentTimeMillis());
        }, 1, 1, TimeUnit.SECONDS);
    }
    
    public static void run() {
        
    }
    
    
}
