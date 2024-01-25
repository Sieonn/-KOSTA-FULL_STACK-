import java.util.Arrays;
import java.util.Scanner;

public class ArrayExam10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] narr = new int[cnt];

        for (int i = 0; i < narr.length; i++) {
            narr[i] = sc.nextInt();
        }
        Arrays.sort(narr);
        for (int i = narr.length-1; i >= 0; i--) {
            System.out.print(narr[i]+" ");

        }

    }
}

//20이하의 점수 n을 입력받고 n명의 점수를 입력받아 높은 점수부터 차례로 출력하는 프로그램을 작성하시오
//입력
//5
//35 10 35 100 64
//출력
//100
// 64
//35
//35
//30