package designPattern.decorator;

public class CoffeeTest {
    public static void main(String[] args) {
        Coffee ethiopiaCoffee = new Ethiopia();
        ethiopiaCoffee.brewing();
        Coffee kenyaCoffee = new Kenya();
        kenyaCoffee.brewing();

        Coffee ethiopiaLatte = new Latte(ethiopiaCoffee);
        ethiopiaLatte.brewing();

        Coffee ethiopiaMocha = new Mocha(ethiopiaCoffee);
        ethiopiaMocha.brewing();

        Coffee kenyaLatteMocha = new Mocha(new Latte(kenyaCoffee));
        kenyaLatteMocha.brewing();
    }
}
