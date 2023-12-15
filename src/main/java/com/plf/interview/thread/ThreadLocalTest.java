package com.plf.interview.thread;

import org.junit.jupiter.api.Test;

/**
 * ThreadLocal 实现父子线程通信
 * @author Lancer
 * @date 2023-12-15
 */
public class ThreadLocalTest {

    /**
     * 在Thread类中存在InheritableThreadLocal变量，简单来说就是使用
     * InheritableThreadLocal来进行传递，当父线程的InheritableThreadLocal不为空时，就会将这个值传到
     * 当前子线程的InheritableThreadLocal
     */
    @Test
    public void testInheritableThreadLocal(){
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("我是ThreadLocal");

        ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        inheritableThreadLocal.set("我是InheritableThreadLocal");

        Thread thread = new Thread(()->{
            System.out.println("ThreadLocal ===>" + threadLocal.get());
            System.out.println("InheritableThreadLocal ===>" + inheritableThreadLocal.get());
        });

        thread.start();

        //ThreadLocal ===>null
        //InheritableThreadLocal ===>我是InheritableThreadLocal
    }
}
