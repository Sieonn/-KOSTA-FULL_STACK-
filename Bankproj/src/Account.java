public class Account {
    String id;
    String name;
    int balance;

//    String info() { //호출한 애한테 주는 데이터 타입 > 호출한 애한테 문자열을 주겠다,
//        return "계좌번호: " + id + ", 이름: " + name + ", 잔액: " + balance;
//    }
    String info() {
        return String.format("계좌번호: %s, 이름: %s, 잔액: %d", id, name, balance);
    }

    //리턴하지 않아도 되는 값
    void deposit(int money) {
        if(money>0) balance += money;

    }
    void withdraw(int money) {
        if(balance>=money)
            balance -= money;
    }

Account() {
}

Account(String id, String name, int balance) {
    this.id = id;
    this.name = name;
    this.balance = balance;
}

Account(String id, String name) {
    this(id, name, 0);

}

public static void main(String[] args) {
    Account acc1 = new Account();
    acc1.id = "1001";
    acc1.name = "김길동";
    acc1.balance = 200000;
    Account acc2 = new Account("1002", "홀길동", 100000);
    Account acc3 = new Account("1003", "강길동");
    System.out.println(acc1.info());
    acc1.deposit(10000);
    System.out.println(acc1.info());
    acc1.withdraw(5000);
    System.out.println(acc1.info());
}
}
