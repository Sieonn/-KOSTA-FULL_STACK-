class Member {
    int num;
    String name;
    String phone;
    String email;
    String address;

    Member() {

    }

    Member(int a, String n) {
        num =a;
        name = n;
    }

}

public class ConstuctorTest1 {
    public static void main(String[] args) {
        Member m1 = new Member();
        m1.num = 100;
        m1.name = "홍길동";
        //클래스 생성시 생성자를 하나도 안만들면 기본생성자가 자동으로 만들어지는데 하나라도 만들면 기본생성자는 자동으로 만들어지지 않기때문에 기본 생성자를 만들어 줘야합니다.

        Member m2 = new Member(101, "김길동");
        System.out.println();

    }
}
