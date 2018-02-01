package org.luoyh.todo;

import java.util.LinkedList;

import com.google.common.collect.Lists;

/**
 * <p>Created: Jan 31, 2018 4:11:37 PM</p>
 * 
 * @author luoyh(Roy)
 * @version 1.0
 * @since 1.7
 */
public class TaskPool {
    
    private LinkedList<Task> pool = Lists.newLinkedList();
    
    public static void main(String[] args) {
        new TaskPool().pool.remove(0);
        
    }

    public LinkedList<Task> getPool() {
        return pool;
    }

    public void setPool(LinkedList<Task> pool) {
        this.pool = pool;
    }

}
