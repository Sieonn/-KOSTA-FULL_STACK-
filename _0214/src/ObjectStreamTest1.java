import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class Person implements Serializable {
    int age;
    String name;
    transient String password;
    Person(String name, int age, String password){
        this.name = name;
        this.age = age;
        this.password = password;
    }
}
public class ObjectStreamTest1 {
    public static void main(String[] args) {
        ObjectOutputStream oos =null;
        ArrayList<Person> pers = new ArrayList<>();
        Person p1 = new Person("hong", 20, "1q2w3e");
        Person p2 = new Person("gong", 30, "qwer1234");
        Person p3 = new Person("dong", 10, "qwer4321");
        pers.add(p1);
        pers.add(p2);
        pers.add(p3);
        try {
            oos = new ObjectOutputStream(new FileOutputStream("pers.ser"));
//            oos.writeInt(3);
//            oos.writeObject(pers);
//            oos.writeObject(p1);
//            oos.writeObject(p2);
//            oos.writeObject(p3);
            oos.writeObject(pers);
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if(oos !=null) oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
