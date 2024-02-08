import java.util.HashSet;

public class HashSetTest1 {
    public static void main(String[] args) {
        HashSet<Integer> hs =new HashSet<>();
        hs.add(20);
        hs.add(10);
        hs.add(20);
        hs.add(10);
        hs.add(5);
        hs.add(30);

        System.out.println(hs.size());//Set이기 때문에 중복데이터를 취급하지 않습니다.
        System.out.println(hs);
        HashSet <Person> phs = new HashSet<>();
        phs.add(new Person("홍길동",20));
        phs.add(new Person("홍길동",20));
        phs.add(new Person("김길동",10));
        phs.add(new Person("김길동",20));
        System.out.println(phs.size());
        System.out.println(phs);

        HashSet<String> shs = new HashSet<>();
        shs.add("홍길동");
        shs.add("홍길동");
        shs.add("김길동");
        shs.add("김길동");

        System.out.println(shs);
    }
}
