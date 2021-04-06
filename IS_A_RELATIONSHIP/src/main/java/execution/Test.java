package execution;

import com.dhruv.www.Child;
import com.dhruv.www.Parent;

public class Test {

    public static void main(String[] args) {
        //parent object can access method1 only
        Parent p = new Parent();
        System.out.println(p.method1());

        //child object can access both parent method (method1) and child method (method2)
        Child c = new Child();
        System.out.println(c.method1());
        System.out.println(c.method2());
    }
}
