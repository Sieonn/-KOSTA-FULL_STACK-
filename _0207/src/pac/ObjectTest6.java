package pac;



public class ObjectTest6 {
    public static void main(String[] args) {
        Data data1 = new main()
        Person p1 = new Person("김길동", 20);
        Person p2 = (Person) p1.clone();

        p1.age = 30;
        System.out.println(p1);
        System.out.println(p2);
    }
}
