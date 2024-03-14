package method;

public class MethodValue3 {
    public static void main(String[] args) {
        int num1 = 5;
        System.out.println("changeNumber 호출 전, num1: " + num1);//5
        num1 = changeNumber(num1);
        System.out.println("changeNumber 호출 후, num1: "+num1);//5
    }
    public static int changeNumber(int num2) {
        num2 = num2 *2;
        return num2;
    }
}
//자바는 항상 변수의 값을 복사해서 대입합니다.
//참조형은 차조형 변수에 있는 값인 참조값을 복사하는 것입니다.