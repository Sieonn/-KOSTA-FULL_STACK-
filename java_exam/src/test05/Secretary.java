package test05;

public class Secretary extends Employee{
    public Secretary(){
        super();
    }
    public Secretary(String name, int number, String department, int salary ) {
        super(name, number, department, salary);

        }
        public void incentive(int pay){
        salary += pay*0.8;
        }
    }

