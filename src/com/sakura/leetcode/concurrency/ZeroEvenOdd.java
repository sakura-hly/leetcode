package com.sakura.leetcode.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private Lock lock = new ReentrantLock();
    private Condition zeroCondition = lock.newCondition();
    private Condition evenCondition = lock.newCondition();
    private Condition oddCondition = lock.newCondition();
    private volatile boolean beginZero = true;
    private volatile boolean beginEven = false;
    private volatile boolean beginOdd = false;
    private int i = 1;
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        while (i <= n) {
            while (!beginZero) zeroCondition.await();
            if (i > n) break;
            printNumber.accept(0);
            beginZero = false;
            if ((i & 1) == 1) {
                beginOdd = true;
                oddCondition.signal();
            } else {
                beginEven = true;
                evenCondition.signal();
            }
        }
        beginOdd = true;
        oddCondition.signal();
        beginEven = true;
        evenCondition.signal();
        lock.unlock();
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        while (i <= n) {
            while (!beginEven) evenCondition.await();
            if (i > n) break;
            printNumber.accept(i++);
            beginEven = false;
            beginZero = true;
            zeroCondition.signal();
        }
        lock.unlock();
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        while (i <= n) {
            while (!beginOdd) oddCondition.await();
            if (i > n) break;
            printNumber.accept(i++);
            beginOdd = false;
            beginZero = true;
            zeroCondition.signal();
        }
        lock.unlock();
    }
}