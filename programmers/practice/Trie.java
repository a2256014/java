package practice;

import java.util.HashMap;

public class Trie {
    static class Node {
        String value;
        HashMap<Character, Node> child;

        Node(String value) {
            this.value = value;
            this.child = new HashMap<>();
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", child=" + child +
                    '}';
        }
    }

    static class MyTrie {
        Node root = new Node("");

        void insert(String str) {
            Node cur = root;

            for (char c : str.toCharArray()) {
                if (!cur.child.containsKey(c)) {
                    cur.child.put(c, new Node(cur.value + c));
                }
                cur = cur.child.get(c);
            }
        }
        void display(){
//            Node cur = root;
//            while (cur.child.size()!=0){
//                for(char c : cur.child.keySet()){
//                    System.out.println("value : " + cur.value);
//                    System.out.println("child : " + cur.child.entrySet());
//                    cur = cur.child.get(c);
//                }
//
//            }
            System.out.println(root);
        }
    }

    public static void main(String[] args) {
        MyTrie trie = new MyTrie();
        trie.insert("hello");
        trie.display();
    }
}
