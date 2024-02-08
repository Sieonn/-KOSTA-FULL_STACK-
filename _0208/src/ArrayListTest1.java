import java.util.ArrayList;

class Person {
    String name;
    int age;
    Person(String name, int age){
        this.name=name;
        this.age =age;
    }
    public String info() {
        return "이름:" +name+",나이:"+age;
    }
    @Override
    public String toString() {
        return "이름:" + name+", 나이:"+ age;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Person)) return false;
        Person p = (Person) obj;
        return name.equals(p.name) && age== p.age ;

    }

    @Override
    public int hashCode() {
        return super.hashCode() +age;
    }
}
public class ArrayListTest1 {
    public static void main(String[] args) {
        ArrayList<Person> al = new ArrayList<>();
        al.add(new Person("hong",20));
        al.add(new Person("song",30));
        al.add(new Person("gong",35));

//        for(int i=0;i<al.size(); i++) {
//            System.out.println(al.get(i));
//        }
        for(Person p: al) { //for-each
            System.out.println(p.info());
        }
    }

}
