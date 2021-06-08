package com.dhruvu.www.fork;

import com.dhruvu.www.constants.State;
import com.dhruvu.www.philosopher.Philosopher;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {

    private int id;
    Lock lock;

    public Fork(int id) {
        this.id = id;
        lock = new ReentrantLock();
    }

    public boolean pickUp(Philosopher philosopher, State state) throws InterruptedException {
        if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
            System.out.println("Philosopher " + philosopher + " get " + state + " fork " + this);
            return true;
        }
        return false;
    }

    public void putDown(Philosopher philosopher, State state) {
        lock.unlock();
        System.out.println("Philosopher " + philosopher + " put down " + state + " fork " + this);
    }

    @Override
    public String toString() {
        return ""+this.id;
    }
}
