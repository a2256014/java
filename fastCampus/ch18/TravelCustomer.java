package ch18;

public class TravelCustomer {
    String name;
    int age;
    int cost;
    TravelCustomer(String name,int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "TravelCustomer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cost=" + cost +
                '}';
    }
}
