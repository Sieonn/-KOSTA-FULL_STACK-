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

        Member m2 = new Member(101, "김길동");
        System.out.println();

    }
}
