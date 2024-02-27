class Variables {
    int iv;
    static  int sv;//인스턴스 변수는 객체소속인데 객체생성될 대마다 새로 생성이 됩니다. static은 클래스안에 생성, class소속이 됩니다.

    void method() {
        System.out.println(iv);
        int lv = 20; //메소드 안에 선언된 변수는 지역변수입니다. 지역변수는 초기화 하지 않으면 사용할 수 없습니다.
        System.out.println(lv);
    }
    void method2() {
        int lv = 30;
        System.out.println(lv);// 에러 특정 블럭 안에셔 선언된 지역 변수는 다른 곳에서 사용할 수 없습니다.
    }
}
public class VariableTest1 {
    public static void main(String[] args) {
        Variables v  = new Variables();
        v.iv = 10;
        Variables.sv = 1000; //스테텍 변수 대문자를 가지고 가져다 쓰는애들은 static
        v.method();
        v.method();
        //lv는 method와 method2에서 동시에 실행되지 않고, 이름이 같아도 같은 메모리는 아닙니다.
        Variables v2 = new Variables();
        v2.iv = 100;
        System.out.println(v2.sv);
    }
}
//객체를 호출하는 시점에 할당되는데 인스턴스변수
//클래스를 호출하는 시점에 클래스 변수