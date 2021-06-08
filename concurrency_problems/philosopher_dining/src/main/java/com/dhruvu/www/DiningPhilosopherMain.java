package com.dhruvu.www;

import com.dhruvu.www.fork.Fork;
import com.dhruvu.www.philosopher.Philosopher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.dhruvu.www.constants.PhilosopherDiningConstants.*;

public class DiningPhilosopherMain {

    public static void main(String[] args) throws InterruptedException {

        Philosopher[] philosophers = new Philosopher[NUMBER_OF_PHILOSOPHERS];
        Fork[] forks = new Fork[NUMBER_OF_FORKS];

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_PHILOSOPHERS);

        try{
            for (int i=0; i<NUMBER_OF_FORKS; i++) {
                forks[i] = new Fork(i);
            }

            for (int i=0; i<NUMBER_OF_PHILOSOPHERS; i++) {
                philosophers[i] = new Philosopher(i,forks[i], forks[(i+1)%NUMBER_OF_FORKS]);
                executorService.execute(philosophers[i]);
            }

            Thread.sleep(SIMULATION_TIME);

            executorService.shutdown();

            for (Philosopher philosopher : philosophers) {
                philosopher.setFull(true);
            }

        }finally {
            while (!executorService.isTerminated()) {
                Thread.sleep(1000);
            }

            for (Philosopher philosopher : philosophers) {
                System.out.println("Philosopher " + philosopher + " eat " + philosopher.getEatingCounter() + " times");
            }

        }

    }
}
