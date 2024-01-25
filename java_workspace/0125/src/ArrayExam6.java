import java.util.Scanner;

public class ArrayExam6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] carr = {'J', 'U', 'N', 'G', 'O', 'L'};
        char ch = sc.nextLine().charAt(0);
        int i = 0;
        for (; i < carr.length; i++) {
            if (carr[i] == ch) break;
        }
        if (i == carr.length) System.out.println("none");
        else System.out.println(i);
    }

}
//6개의 문자배열을 만들고{'J', 'U', 'N', 'G', 'O', 'L'} 으로 초기화 한 후
//문자 한 개를 입력받아 배열에서의 위치를 출력하는 프로그램을 작성하시오
//첫 번째 위치는 0번이며 배열에 없는 문자가 입력되면 "none" 라는 메시지를 출력하고 끝내는 프로그램을 작성하시오.

//입력
//L
//출력
//5