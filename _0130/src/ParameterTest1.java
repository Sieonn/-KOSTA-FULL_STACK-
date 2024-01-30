class  Data {
    int n;
}
public class ParameterTest1 {
    public static  void plusData(int n) {
        n++;
        System.out.println(n);
    }
    public static void plusData(Data d) {
        d.n++;
        System.out.println(d.n); //클래스 이름이 같은데 파라미터이름까지 같을수 없다.
    }
    public static void main(String[] args) {
        Data data = new Data();
        data.n=100;
        plusData(data.n);
        System.out.println(data.n);
        System.out.println("==============");
        plusData(data); //1
        System.out.println(data.n);
        System.out.println("==============");

        Data data2  = data; //2
        data2.n++;
        System.out.println(data2.n);
        System.out.println(data.n);
    }
}//레퍼런스를 넘겨서 데이터를 바꾸면 원본이 바뀌고 파라미터를 바꾸면 복사복이 바뀌는거라 원본은 변하지 않습니다.
