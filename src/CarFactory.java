public class CarFactory {
    private static CarFactory factory = new CarFactory();
    private CarFactory(){}
    public static CarFactory getInstance(){
        return factory;
    }
    public Car createCar(){
        return new Car();
    }
}
