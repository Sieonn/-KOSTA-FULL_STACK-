package emp;

import exp.BankError;
import exp.BankException;

public class Account {
    String id;
    String name;
    int balance;

    public String getId() { return id;}
    public void setId(String id) { this.id=id;}
    public String getName() { return name; }
    public void setName(String name) {this.name=name;}
    public int getBalance() { return balance; }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public Account() {}
    public Account(String id, String name, int balance) {
        this.id=id;
        this.name=name;
        this.balance=balance;
    }
    public Account(String id, String name) {
        this(id,name,0);
    }

    public String info() {
        return String.format("계좌번호, 이름, 금액:%d",id,name,balance);
    }

    public void deposit(int money) {
        if(money>0) balance += money;
    }

    public void withdraw(int money) throws BankException {
        if(balance<money) {
            throw new BankException(BankError.OVERDRAWN);
        }
        balance -= money;
    }
}