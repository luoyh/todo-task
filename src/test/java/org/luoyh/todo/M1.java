package org.luoyh.todo;

import java.time.LocalDateTime;

/**
 * <p>Created: Feb 1, 2018 1:43:36 PM</p>
 * 
 * @author luoyh(Roy)
 * @version 1.0
 * @since 1.7
 */
public class M1 {
    
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        Pool pool = new Pool();
        pool.init();
        
        pool.push(20, () -> {
            System.out.println(LocalDateTime.now());
        });
        pool.push(30, () -> {
            System.out.println(LocalDateTime.now());
        });
        pool.push(20, () -> {
            System.out.println(LocalDateTime.now());
        });
        pool.push(10, () -> {
            System.out.println(LocalDateTime.now());
        });
        pool.push(5, () -> {
            System.out.println(LocalDateTime.now());
        });
        pool.push(2, () -> {
            System.out.println(LocalDateTime.now());
        });
        pool.push(3, () -> {
            System.out.println(LocalDateTime.now());
        });
    }

}
