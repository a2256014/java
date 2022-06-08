public class Subway {
    int subwayNumber;
    int passengerCount;
    int money;

    public Subway(int subwayNumber){
        this.subwayNumber=subwayNumber;
    }
    public void take(int money){
        this.money+=money;
        this.passengerCount++;
    }
    public void showBusInfo(){
        System.out.println(subwayNumber+" : "+passengerCount+"명 : "+money);
    }
}
