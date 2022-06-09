package ch17;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class c = Class.forName("java.lang.String");

        Constructor[] cons = c.getConstructors();
        for(Constructor con : cons){
            System.out.println(con);
        }

        Method[] ms = c.getMethods();
        for(Method m : ms){
            System.out.println(m);
        }

        Class c2 = Class.forName("ch17.Person");

        Person person = (Person) c2.newInstance();
        person.setName("kim");
        person.setAge(26);
        System.out.println(person);
    }
}
