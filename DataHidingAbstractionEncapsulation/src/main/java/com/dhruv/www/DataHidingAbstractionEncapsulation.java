package com.dhruv.www;

/**
 * Data members recommended to be private
 * Should be accessed by getters and setters
 *
 * Implemented interface therefore full abstraction
 *
 * All members are private tightly encapsulated
 */
public class DataHidingAbstractionEncapsulation implements DemoInterface {
    private int rollNo;
    private String name;

    public int getRollNo() {
        System.out.println(getHello());
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        System.out.println(getHello());
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String getHello() {
        return "Hello";
    }
}
