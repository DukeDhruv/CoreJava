package execution;

import com.dhruv.www.DataHidingAbstractionEncapsulation;
import com.dhruv.www.DemoInterface;

/**
 * demo can access methods declared in interface
 * Demo class will never know with DemoInterface that what is actual implementation of methods
 * Ex: printing hello
 */
public class Demo {
    public static void main(String[] args) {

        DemoInterface demo = new DataHidingAbstractionEncapsulation();
        demo.setRollNo(10);
        demo.setName("Abc");

        System.out.println(demo.getRollNo());
        System.out.println(demo.getName());
    }
}
