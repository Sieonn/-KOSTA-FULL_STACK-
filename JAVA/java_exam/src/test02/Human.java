package test02;

public class Human {
    String name;
    int age;
    int height;
    int weight;
    public Human() {
        super();
    }
    public Human(String name, int age, int height, int weight){
        this.age=age;
        this.name=name;
        this.height=height;
        this.weight=weight;
    }

    @Override
    public String toString() {
        return name+" "+ age+ " "+ height+" "+ weight+" ";
    }
}
