package emp;

public class SpecialAccount extends Account {
    String grade;
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public SpecialAccount(String id, String name, int balance, String grade) {
        super(id,name,balance);
        this.grade=grade;
    }

    @Override
    public String info() {
        return super.info()+", 등급:"+grade;
    }

    @Override
    public void deposit(int money) {
        double rate=0;
        switch(grade.toUpperCase()) {
            case "VIP": rate=0.04; break;
            case "GOLD": rate=0.03; break;
            case "SILVER": rate=0.02; break;
            case "NORMAL": rate=0.01; break;
        }
        super.deposit(money+(int)(money*rate));
    }
}