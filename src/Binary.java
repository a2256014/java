public class Binary {
    public static void main(String[] args) {
        int num = 10;
        int bNum = 0B1010;
        int oNum = 012;
        int xNum = 0XA;
        System.out.println(num);
        System.out.println(bNum);
        System.out.println(oNum);
        System.out.println(xNum);

        Student student1 = new Student("James",5000);
        Student student2 = new Student("Tomas",10000);
        Bus bus100 = new Bus(100);
        Subway subway = new Subway(2);
        student1.takeBus(bus100);
        student2.takeSubway(subway);

        student1.showInfo();
        student2.showInfo();
        bus100.showBusInfo();
        subway.showBusInfo();

        CarFactory factory = CarFactory.getInstance();
        Car mySonata = factory.createCar();
        Car yourSonata = factory.createCar();
        System.out.println(mySonata.toString());
        System.out.println(yourSonata.toString());
        student1.setSubject("국어",60);
        student1.setSubject("수학",50);
        student2.setSubject("수학",100);
        student2.setSubject("국어",90);
        student2.setSubject("영어",60);

        for(Subject subject : student1.getSubject()){
            int sum = 0;
            System.out.println(subject.name+" : "+subject.score);
        }
    }
}
