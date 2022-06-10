package ch20;

import java.io.*;

class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = -1503252402544036183L;
    String name;
    String job;
    String type;

    public Person() {
    }

    public Person(String name, String job, String type) {
        this.name = name;
        this.job = job;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

class Person2 implements Externalizable {

    String name;
    String job;
    String type;

    public Person2() {
    }

    public Person2(String name, String job, String type) {
        this.name = name;
        this.job = job;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeUTF(job);
        out.writeUTF(type);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        job = in.readUTF();
        type = in.readUTF();
    }

}

public class SerializableTest {
    public static void main(String[] args) {
        Person personKim = new Person("김도균", "클라우드 개발자", "serial");
        Person personLee = new Person("이도엽", "농부", "serial");
        Person2 person2Kim = new Person2("김도균", "클라우드 개발자", "external");
        Person2 person2Lee = new Person2("이도엽", "농부", "external");

        try (FileOutputStream fos = new FileOutputStream("fastCampus/ch20/serial.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(personKim);
            oos.writeObject(personLee);
            oos.writeObject(person2Kim);
            oos.writeObject(person2Lee);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileInputStream fis = new FileInputStream("fastCampus/ch20/serial.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Person cKim = (Person) ois.readObject();
            Person cLee = (Person) ois.readObject();
            Person2 cKim2 = (Person2) ois.readObject();
            Person2 cLee2 = (Person2) ois.readObject();
            System.out.println(cKim);
            System.out.println(cLee);
            System.out.println(cKim2);
            System.out.println(cLee2);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
