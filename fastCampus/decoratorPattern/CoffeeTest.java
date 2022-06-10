package decoratorPattern;

public class CoffeeTest {
    public static void main(String[] args) {
        Coffee etiopiaCoffee = new Etiopia();
        etiopiaCoffee.brewing();
        Coffee keyaCoffee = new Keya();
        keyaCoffee.brewing();

        Coffee etiopiaLatte = new Latte(etiopiaCoffee);
        etiopiaLatte.brewing();

        Coffee etiopiaMocha = new Mocha(etiopiaCoffee);
        etiopiaMocha.brewing();

        Coffee keyaLatteMocha = new Mocha(new Latte(keyaCoffee));
        keyaLatteMocha.brewing();
    }
}
