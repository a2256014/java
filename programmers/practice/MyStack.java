package practice;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MyStack {
    public static void main(String[] args) {


        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.contains(3);
        PriorityQueue<User> priorityQueue = new PriorityQueue<>((x1, x2) -> x1.age- x2.age);
        priorityQueue.add(new User("lee",10));
        priorityQueue.add(new User("abc",16));
        priorityQueue.add(new User("cbc",3));
        System.out.println(priorityQueue.poll().toString());
        System.out.println(priorityQueue.poll().toString());
        System.out.println(priorityQueue.poll().toString());
    }

    static class User {
        String name;
        int age;

        User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
