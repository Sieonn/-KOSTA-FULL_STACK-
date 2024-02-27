public class CallbyRefTest1 {
    public static void changePerson1(Person p) {
        p.age =30;
        changePerson2(p);
    }
    public static void changePerson2(Person p) {
        p.name = "허동길";
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age = 25;
        p1.name = "하길동";

        System.out.println(p1.info());
        changePerson1(p1);
        System.out.println(p1.info());
        //공유 원본을 넘기는 것이다. 원본이 다른 값으로 덮어씌워진다.

    }
}
