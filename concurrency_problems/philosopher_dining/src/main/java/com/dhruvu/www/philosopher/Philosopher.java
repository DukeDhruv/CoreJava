package com.dhruvu.www.philosopher;

import com.dhruvu.www.constants.State;
import com.dhruvu.www.fork.Fork;

import java.util.Random;

public class Philosopher implements Runnable {

    private int id;
    private Fork leftFork;
    private Fork rightFork;
    private boolean full;
    private volatile int eatingCounter = 0;
    private Random random;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.random = new Random();
        this.full = false;
    }

    @Override
    public void run() {

        try {
            while (!isFull()) {
                think();
                if (leftFork.pickUp(this, State.LEFT)) {
                    if (rightFork.pickUp(this, State.RIGHT)) {
                        eat();
                        rightFork.putDown(this, State.RIGHT);
                    }
                    leftFork.putDown(this, State.LEFT);
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void think() throws InterruptedException{
        System.out.println("Philosopher " + this + " is thinking.");
        Thread.sleep(this.random.nextInt(1000));
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + this + " is eating.");
        eatingCounter++;
        Thread.sleep(1000);
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public int getEatingCounter() {
        return this.eatingCounter;
    }

    @Override
    public String toString() {
        return ""+this.id;
    }
}
