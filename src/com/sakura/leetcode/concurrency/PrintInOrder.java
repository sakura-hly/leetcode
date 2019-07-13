package com.sakura.leetcode.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrder {

    private Lock lock = new ReentrantLock();
    // private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    private volatile boolean begin2 = false;
    private volatile boolean begin3 = false;

    public PrintInOrder() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        c2.signal();
        begin2 = true;
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        while (!begin2) c2.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        c3.signal();
        begin3 = true;
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        while (!begin3) c3.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        lock.unlock();
    }
}
