class Account {
    String id;
    String name;
    int balance;

    String info() { //호출한 애한테 주는 데이터 타입 > 호출한 애한테 문자열을 주겠다,
        return "계좌번호: " + id + ", 이름: " + name + ", 잔액: " + balance;
    }
    //리턴하지 않아도 되는 값
    void deposit(int money){
        balance += money;

    }
    void withdraw(int money) {
        balance -= money;
    }
}

public class ClassTest2 {

    public static void main(String[] args) {
        Account acc = new Account();
        acc.id = "10001";
        acc.name = "홍길동";
        acc.balance = 1000000;
        System.out.println(acc.info());
        acc.deposit(10000);
        System.out.println(acc.info());
        acc.withdraw(5000);
        System.out.println(acc.info());
    }
}
