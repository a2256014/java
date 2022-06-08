import java.util.ArrayList;

public class Student {
    private static int studentN = 0;
    String studentName;
    int money;
    int N;
    ArrayList<Subject> subjects = new ArrayList<Subject>();
    public Student(String studentName, int money){
        this.studentName=studentName;
        this.money=money;
        this.N = ++studentN;
    }
    public void takeBus(Bus bus){
        bus.take(1000);
        this.money-=1000;
    }
    public void takeSubway(Subway subway){
        subway.take(1200);
        this.money-=1200;
    }
    public void showInfo(){
        System.out.println(this.money);
    }
    public void setSubject(String name,int score){
        subjects.add(new Subject(name,score));
    }
    public ArrayList<Subject> getSubject(){
        return this.subjects;
    }
}

