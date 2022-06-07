import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

public class practice {
    public static void main(String [] args) throws FileNotFoundException {
        class Student{
            String name;
            String number;
            int birthYear;
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Student student = (Student) o;
                return birthYear == student.birthYear && Objects.equals(name, student.name) && Objects.equals(number, student.number);
            }
            @Override
            public int hashCode() {
                return Objects.hash(name, number, birthYear);
            }
            @Override
            public String toString() {
                return "Student{" +
                        "name='" + name + '\'' +
                        ", number='" + number + '\'' +
                        ", birthYear=" + birthYear +
                        '}';
            }
        }

        Student s1 = new Student();
        s1.birthYear = 1995;
        s1.name = "김도균";
        s1.number = "1234";
        Student s2 = new Student();
        s2.birthYear = 1995;
        s2.name = "김도균";
        s2.number = "1234";
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode()+","+s2.hashCode());
        System.out.println(s1.toString());

        class Box<E>{
            private E obj;
            public void setObj(E obj){
                this.obj=obj;
            }
            public E getObj(){
                return this.obj;
            }
        }
        Box<String> box = new Box<>();//제너릭

        Set<String> set1 = new HashSet<>();
        set1.add("kim");
        set1.add("kim1");
        set1.add("kim2");
        Iterator<String> iter = set1.iterator();
        while (iter.hasNext()) System.out.println(iter.next());
        for (String s : set1) System.out.println(s);

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("2");

        for(String str : list){
            System.out.println(str);
        }

        Map<String,String> map = new HashMap<>();
        map.put("kim","dogyun");
        map.put("lee","doyup");
        for(String str : map.keySet()){
            System.out.println(str);
        }
        try {
            FileInputStream file;
            file = new FileInputStream("src/practice.java");
            FileOutputStream fileout;
            fileout = new FileOutputStream("src/byte.txt");
            int read;
            while ((read=file.read())!=-1){
                fileout.write(read);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        PrintWriter pw=null;
        try {
            pw = new PrintWriter(new FileWriter("src/test.txt"));
            pw.print("안녕하세요. PrintWriter입니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (pw != null) {
                pw.close();
            }
        }
        class myHello{
            @Count100
            void hello() {
                System.out.println("hello");
            }
        }
        myHello halo = new myHello();
        try {
            Method method = halo.getClass().getDeclaredMethod("hello");
            if(method.isAnnotationPresent(Count100.class)){
                System.out.println(method+" ");
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
/*
        MyThread t1 = new MyThread("*");
        MyThread2 t2 = new MyThread2("-");
        t1.start();
        Thread thread2 = new Thread(t2);
        thread2.start();
        System.out.println("main end!");
*/
        MusicBox musicBox = new MusicBox();
        MusicPlayer kim = new MusicPlayer(1,musicBox);
        MusicPlayer lee = new MusicPlayer(2,musicBox);
        MusicPlayer park = new MusicPlayer(3,musicBox);
        kim.start();
        lee.start();
        park.start();
    }
}