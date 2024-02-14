package test05;

public abstract class Employee {
    String name;
    int number;
    String deparment;
    int salary;

    public Employee(){
        super();
    }
    public Employee(String name, int number, String deparment, int salary){
        this.name=name;
        this.deparment=deparment;
        this.number=number;
        this.salary=salary;
    }
    public void tax(int pay) {
        salary -= (double)salary*pay*0.01;
    }
}
