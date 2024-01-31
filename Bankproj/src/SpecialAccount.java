
public class SpecialAccount extends Account {
    String grade;

    SpecialAccount(String id, String name, int balance, String grade) {
        super(id, name, balance);
        this.grade = grade;
    }

    @Override
    String info() {
        return super.info() + ", 등급:" + grade;
    }

    @Override
    void deposit(int money) {
        double rate = 0;
        switch (grade.toUpperCase()) {
            case "VIP":
                rate = 0.04;
                break;
            case "GOLD":
                rate = 0.03;
                break;
            case "SILVER":
                rate = 0.02;
                break;
            case "NORMAL":
                rate = 0.01;
                break;
        }
        super.deposit(money + (int) (money * rate));
    }

    public static void main(String[] args) {
        SpecialAccount sacc = new SpecialAccount("1001", "홍길동", 100000, "gold");
        System.out.println(sacc.info());
        sacc.deposit(10000);
        System.out.println(sacc.info());
        sacc.withdraw(5000);
        System.out.println(sacc.info());

    }
}
//계좌번호:1001, 이름:홍길동, 잔액:100000, 등급:VIP
//계좌번호:1001, 이름:홍길동, 잔액:110400, 등급:VIP
//계좌번호:1001, 이름:홍길동, 잔액:105400, 등급:VIP