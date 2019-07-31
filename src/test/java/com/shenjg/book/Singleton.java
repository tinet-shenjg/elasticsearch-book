package com.shenjg.book;

/**
 * 懒汉式单例---线程安全
 *
 * @author shenjg
 * @date 2019/07/15
 */
public class Singleton {

    private static Singleton signleton;

    private Singleton() {

    }

    /**
     * synchronized同步方法实现线程安全，效率较低
     *
     * @return
     */
    private static synchronized Singleton getSignleton() {
        if (signleton == null) {
            return new Singleton();
        }
        return signleton;
    }

}
