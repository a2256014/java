package dataStructure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        MyArray ma = new MyArray(5);
        ma.addElement(1);
        ma.addElement(2);
        ma.addElement(3);
        ma.addElement(4);
        ma.addElement(5);

        ma.removeElement(3);
        ma.insertElement(2,13);
        System.out.println(ma.toString());

        MyLinkedList mll = new MyLinkedList();
        mll.addElement("a");
        mll.addElement("b");
        mll.addElement("c");
        mll.printAll();

        MyQueue mq = new MyQueue();
        mq.enQueue("a queue");
        mq.enQueue("b queue");
        mq.enQueue("c queue");
        mq.printAll();

    }
}
