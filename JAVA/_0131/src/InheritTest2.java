class Base {
    int n;

    void method1() {
        System.out.println("Base method1");
    }
}

class Dervied extends Base {
    int m;

    void method2() {
        System.out.println("Derived method2");

    }

    @Override
    void method1() {
        System.out.println("Derived method1");
    }
}

public class InheritTest2 {
    public static void main(String[] args) {
        Base b = new Base();
        b.n = 10;
        b.method1();

        Dervied d = new Dervied();
        d.n = 100;
        d.m = 200;
        d.method1(); //Derived method1
        d.method2();
    }
}
