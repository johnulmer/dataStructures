package dataStructures;

import org.junit.Test;

public class ArrayListTester {
	
    public static void main(String[] args) {
        MyArrayList aList = new MyArrayList();
        System.out.println(aList.append("Test1"));
        System.out.println(aList.append("Test2!"));
        System.out.println(aList.append("Test3!"));
        System.out.println(aList.append("Test4!"));
        System.out.println(aList.append("Test5"));
        System.out.println(aList.getSize());
        System.out.println(aList.getThing(0));
        Object o = aList.remove(2);
        System.out.println(o);
        System.out.println(aList.getSize());
    }
}
