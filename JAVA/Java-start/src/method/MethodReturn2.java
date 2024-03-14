package method;

public class MethodReturn2 {
    public static void main(String[] args) {
        boolean result = checkedAge(20);
        System.out.println(result);

    }
    public static boolean checkedAge(int age){
        if(age>18){
            System.out.println(age+"살, 입니다. 입장하세요");
            return true;
        }else{
            System.out.println(age+"살, 미성년자는 출입이 불가능 합니다.");
            return false;
        }
    }
}
