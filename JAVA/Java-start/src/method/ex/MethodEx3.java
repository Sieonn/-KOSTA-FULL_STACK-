package method.ex;

public class MethodEx3 {
    public static void main(String[] args) {
        int balance = 100000;

        balance = deposit(1000,balance);
        balance = withdraw(2000, balance);

        System.out.println("최종 잔액: "+ balance+"원");

    }
    public static int deposit(int a, int amount){
        amount += a;
        System.out.println(a+"원을 입금하였습니다. 현재잔액: "+amount+"원");
        return amount;
    }
    public static int withdraw(int b, int amount){
        if(amount>=b){
            amount -= b;
            System.out.println(b+"원을 출금하였습니다. 현재 잔액: "+amount+"원");
        }else {
            System.out.println(b+"원을 출금하려 했으나 잔액이 부족합니다.");
        }
        return amount;
    }
}
