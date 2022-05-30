import java.util.Objects;

public class practice {
    public static void main(String [] args){
        class Student{
            String name;
            String number;
            int birthYear;

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Student student = (Student) o;
                return birthYear == student.birthYear && Objects.equals(name, student.name) && Objects.equals(number, student.number);
            }

            @Override
            public int hashCode() {
                return Objects.hash(name, number, birthYear);
            }
        }

        Student s1 = new Student();
        s1.birthYear = 1995;
        s1.name = "김도균";
        s1.number = "1234";
        Student s1 = new Student();
        s1.birthYear = 1995;
        s1.name = "김도균";
        s1.number = "1234";

    }
}
