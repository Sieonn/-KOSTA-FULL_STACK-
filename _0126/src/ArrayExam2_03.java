import java.util.Scanner;

public class ArrayExam2_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] count = new int[10];
        int num;
        while (true) {
            num = sc.nextInt();
            if (num == 0) break;
            count[num - 1]++; //count[num%10]++로 표현할 수 있음. 선생님은 주석과 같이 쓰셨음.
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                System.out.println(String.format("%d : %d개", i+1, count[i]));
            }
        }
    }
}
//정수를 입력받다가 0이 입력되면 마지막에 입력된 0을 제외하고 그 때까지 입력된 정수의 일의 자리 숫자가 각각 몇개 인지 작은 수 부터 출력하는 프로그램을 작성하시오. (0제외)