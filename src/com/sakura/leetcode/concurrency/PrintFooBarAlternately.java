package com.sakura.leetcode.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintFooBarAlternately {

    private int n;
    private Lock lock = new ReentrantLock();
    private Condition fooCondition = lock.newCondition();
    private Condition barCondition = lock.newCondition();
    private volatile boolean beginFoo = true;
    private volatile boolean beginBar = false;

    public PrintFooBarAlternately(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        lock.lock();
        for (int i = 0; i < n; i++) {
            while (!beginFoo) fooCondition.await();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            beginFoo = false;
            beginBar = true;
            barCondition.signal();
        }
        lock.unlock();
    }

    public void bar(Runnable printBar) throws InterruptedException {
        lock.lock();
        for (int i = 0; i < n; i++) {
            while (!beginBar) barCondition.await();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            beginBar = false;
            beginFoo = true;
            fooCondition.signal();
        }
        lock.unlock();
    }
}
