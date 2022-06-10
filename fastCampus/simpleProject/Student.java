package simpleProject;

import java.util.ArrayList;

public class Student {
    private int studentId;
    private String studentName;
    private Subject major;
    private ArrayList<Score> scoreList = new ArrayList<>();

    public Student(int studentId, String studentName, Subject major){
        this.studentId = studentId;
        this.studentName = studentName;
        this.major = major;
    }
    public void addSubjectScore(Score score){
        scoreList.add(score);
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public Subject getMajor() {
        return major;
    }


    public ArrayList<Score> getScoreList() {
        return scoreList;
    }

}
