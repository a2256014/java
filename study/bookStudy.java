import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.*;

public class bookStudy {
    public static void main(String[] args) {
        add("a", "b", "c");
        add();
        add("a");

        Car car1 = new Car();
        Car car2 = new Car("red");
        Car car3 = new Car("red");
        System.out.println(car1.toString());
        System.out.println(car2.toString());
        Car firecar = new FireCar("fire");
        System.out.println(firecar.toString());
        FireCar realFire = (FireCar) firecar;
        realFire.water();
        System.out.println(firecar.getClass());
        car1.damaged(20);
        System.out.println(car1.toString());
        car1.repair();
        System.out.println(car1.toString());
        firecar.damaged(20);
        System.out.println(firecar.toString());
        firecar.repair();
        System.out.println(firecar.toString());
        System.out.println(car2.equals(car3));
        System.out.println(car2.hashCode());
        System.out.println(car3.hashCode());

        String[] a = {};
        Integer[] b = {};
        int[] c = {};
        ArrayList<String> alist = new ArrayList<>(Arrays.asList(a));
        ArrayList<Integer> blist = new ArrayList<>(Arrays.asList(b));
        HashSet<String> clist = new HashSet<>(alist);

        Properties prop = new Properties();
        System.out.println(Arrays.toString(args));

    }

    static void add(String @NotNull ... arg) {
        for (Object str : arg) {
            System.out.println(str);
        }
    }
}

class Car implements Repairable {
    final int MAX_STATUS = 100;
    static int count = 0;
    int status = 100;
    String color;
    final String num;

    {
        count++;
        color = "white";
        num = count + "";
    }

    Car() {
    }

    Car(String color) {
        this.color = color;
    }

    void damaged(int damage) {
        this.status -= damage;
    }

    @Override
    public void repair() {
        this.status = MAX_STATUS;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", num='" + num + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(this.color, car.color) && Objects.equals(this.num, car.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.color, this.num);
    }
}

class FireCar extends Car {
    String type;

    FireCar(String type) {
        super();
        this.type = type;
    }

    void water() {
        System.out.println("water~~");
    }

    @Override
    public String toString() {
        return super.toString() + "FireCar{" +
                "type='" + type + '\'' +
                '}';
    }
}

interface Repairable {
    void repair();
}