import java.sql.SQLOutput;

public class ExceptionTest1 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try {
            System.out.println(3);
            int a = 10 / 0;
            System.out.println(4);
        } catch (NumberFormatException e) {
            System.out.println("예외처리");
        } catch (Exception e) {
            System.out.println("예외처리 2");
        }
        System.out.println("종료");
    }
}
