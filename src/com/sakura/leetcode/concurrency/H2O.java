package com.sakura.leetcode.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class H2O {
    private Lock lock = new ReentrantLock();
    private Condition hCondition = lock.newCondition();
    private Condition oCondition = lock.newCondition();
    private volatile int h = 2;

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();
        while (h == 0) hCondition.await();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        h--;
        if (h == 0) {
            oCondition.signal();
        } else {
            hCondition.signal();
        }
        lock.unlock();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        while (h > 0) oCondition.await();
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
        h = 2;
        hCondition.signal();
        lock.unlock();
    }
}