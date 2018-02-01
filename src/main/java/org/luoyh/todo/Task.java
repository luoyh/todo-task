package org.luoyh.todo;

import java.util.concurrent.ExecutorService;

/**
 * <p>Created: Jan 31, 2018 3:06:25 PM</p>
 * 
 * @author luoyh(Roy)
 * @version 1.0
 * @since 1.8
 */
public class Task {
    
    private int index;
    private Callback callback;
    
    public void todo(ExecutorService executor) {
        index --;
        if (index <= 0) {
            executor.execute(() -> {
                callback.execute();
            });
        }
    }
    
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public Callback getCallback() {
        return callback;
    }
    public void setCallback(Callback callback) {
        this.callback = callback;
    }

}
