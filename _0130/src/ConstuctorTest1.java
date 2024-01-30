class Member {
    int num;
    String name;
    String phone;
    String email;
    String address;

    Member() {
        num = 0;
        name = "이름없음";
    }  //클래스 생성시 생성자를 하나도 안만들면 기본생성자가 자동으로 만들어지는데 하나라도 만들면 기본생성자는 자동으로 만들어지지 않기때문에 기본 생성자를 만들어 줘야합니다.
    Member(int a, String n) {
        this.num =a;
        this.name = n;
    }

    Member(int a, String n, String aphone, String  aemail) {
        this(a, n); //생성자에서 다른 생성자 호출 ()가있는건 함수
        this.phone = aphone; //this.은 변수
        this.email = aemail;
    }
    Member(int a, String n, String aphone, String  aemail, String aaddress) {
        this(a, n, aphone, aemail);
        this.address = aaddress;
//        num =a;
//        name = n;
//        phone = aphone;
//        email = aemail;
//        address = aaddress;
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
