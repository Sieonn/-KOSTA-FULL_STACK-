class Person { //class의 정의
    //여러개의 데이터타입을 묶어서 하나의 데이터 타입을 만든다.
    int age;
    String name;

    String info() { //호출한 애한테 주는 데이터 타입 > 호출한 애한테 문자열을 주겠다,
        return "이름: " + name + ", 나이: " + age;

    }
    Person() {} //아무것도 없는 생성자 기본 생성자
    Person(int a, String n) { //생성자는 리턴타입이 없습니다.
        age=a;
        name=n;
//        System.out.println("Person constructor");
    }
}

public class ClassTest1 {
    //클래스 안에 매소드가 들어올 수 있습니다.

    public static void main(String[] args) {
        Person p1 = new Person(); //객체 또는 인스턴스 new라는 연산자는 주소를 주는 연산자.
        p1.age = 30;
        p1.name = "홍길동";
        Person p2 = new Person(); //객체 또는 인스턴스
        p2.age = 20;
        p2.name = "고길동";

        Person p4 = new Person(25, "홍길동");

        System.out.println(p1.info());
        System.out.println(p2.info());

        System.out.println(p1.name + "," + p1.age);
        System.out.println(p2.name + "," + p2.age);

        int n;

        Person[] pers = new Person[3];
        pers[0] = new Person();

    }
}
