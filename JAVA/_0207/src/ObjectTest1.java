class Data
class Person {
    int age;
    String name;

    // 이름과 나이를 받아 Person 객체를 초기화하는 생성자
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // equals 메서드를 오버라이드하여 이름과 나이를 기반으로 Person 객체를 비교
    @Override
    public boolean equals(Object obj) {
        // obj가 Person 클래스의 인스턴스인지 확인
        if (!(obj instanceof Person)) return false;

        // 맞다면 Person 객체로 캐스팅
        Person per = (Person) obj;

        // 현재 Person 객체의 이름과 나이를 다른 Person 객체와 비교
        return name.equals(per.name) && age == per.age;
    }
    @Override
    public int hashCode() {

        return 0;
    }
}

// 테스트를 위한 메인 클래스
public class ObjectTest1 {
    public static void main(String[] args) {
        // 서로 다른 이름과 나이를 갖는 세 개의 Person 객체 생성
        Person p1 = new Person("홀길동", 20);
        Person p2 = new Person("홀길동", 20);
        Person p3 = new Person("홀길동", 21);

        // p1과 p2의 메모리 주소를 비교
        System.out.println(p1 == p2); // 결과: false

        // equals 메서드를 사용하여 p1과 p2의 내용을 비교 (이름과 나이)
        System.out.println(p1.equals(p2)); // 결과: true

        // equals 메서드를 사용하여 p1과 p3의 내용을 비교 (이름과 나이)
        System.out.println(p1.equals(p3)); // 결과: false
    }
}