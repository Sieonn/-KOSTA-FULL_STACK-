class Variables2 {
    int iv; //instance variable
    static  int sv; //class variable

    void imethod() { //instance method
        System.out.println(iv);
        sv++; //instancce method에서는 static variable 시용힐 수 있습니다.
        smethod();
    }
    static void smethod() {
        sv++;
//        System.out.println(iv); //static method에서 instanc variable 사용할 수 없습니다.
        //imethod(); //imethod()가 사용되지 않았다고 해도 선언되는 것 만으로도 사용되고 있다고 보기 때문에 사용할 수 없습니다.
    }
}
public class StaticTest1 {
    public static void main(String[] args) {
        Variables2.smethod();
    }
}
