package method.ex;

public class MethodEx2 {
    public static void main(String[] args) {
        banbok(3,"Hello Java!");
        System.out.println("========================");
        banbok(5,"Hello Java!");
    }
    public static void banbok(int a,String b){
        for(int i =0; i<a; i++){
            System.out.println(b);
        }
    }
}
