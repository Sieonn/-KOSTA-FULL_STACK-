import java.util.Scanner;

public class ArrayExam2_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ppre = 100;
        int pre = sc.nextInt();
        int curr;
        System.out.print(ppre + "\t" + pre + " ");
        for (int i = 3; i <= 100; i++) {
            curr = ppre - pre;
            System.out.print(curr + " ");
            if (curr < 0) break;
            ppre = pre;
            pre = curr;
        }

    }
}

//100이하의 자연수를 입력받아 첫 번째 100으로 두 번째 항은 입력받은 수로 초기화하고 다음 항 부터는 전전항에서 전항을 밴 수로 채워나가는 수열을 작성하여 그 수가 음수가 나올 때까지 출력하는 프로그램을 작성하시오.