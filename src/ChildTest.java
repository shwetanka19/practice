import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChildTest extends Base{
    @Override
    void overrideme(){
        System.out.println("chile override");
    }

    @Override
    void populate(){
        System.out.println("Chile pop");
    }

    ChildTest(){
        System.out.println("In child constructor");
        overrideme();
        populate();
    }

    public static void main(String [] args){
        ChildTest c = new ChildTest();

        List<String> names = new ArrayList<>();
        names.add("java");
        names.add("php");
        names.add("angular 2");
        names.add("ruby");

        List<String> first2 = names.subList(0, 2);
        System.out.println(names +", "+ first2);
        names.set(1, "javascript");
        System.out.println(names +", "+ first2);
        names.add("nodejs");

        System.out.println(names +", "+ first2);
    }
}

abstract class Base {
    Base(){
        overrideme();
        populate();
    }
    abstract void overrideme();

    void populate(){
        System.out.println("Base populate"+this.getClass().toString());
    }
}


