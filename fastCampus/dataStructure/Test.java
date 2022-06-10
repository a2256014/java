package dataStructure;

import java.util.*;

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
        System.out.println(ma);

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

        TreeSet<String> ts = new TreeSet<>(new MyCompare());
        ts.add("c");
        ts.add("b");
        ts.add("a");
        ts.add("a");
        System.out.println(ts);

        TreeMap<Integer,String> tm = new TreeMap<>();
        tm.put(1,"d");
        tm.put(2,"c");
        tm.put(3,"b");
        tm.put(4,"a");
        System.out.println(tm);
        System.out.println(tm.entrySet());

        ArrayList<String> as = new ArrayList<>();
        as.add("1번");
        as.add("2번");
        as.add("3번");
        as.add("4번");
        as.add("5번");
        String a = as.stream().reduce("",(acc,cur)->{
            System.out.println("sum : "+ acc +" , cur : "+cur);
            return acc+cur;
        });
        System.out.println(a);
    }
    static class MyCompare implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2)*(-1);
        }
    }
}
