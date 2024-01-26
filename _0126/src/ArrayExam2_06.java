import java.util.Scanner;

public class ArrayExam2_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();

        int[][] score = new int[5][4];

        int sum = 0;
        int num = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < i; j++) {
                sum += num;
                score[i][j] = num;

            }
//            if (sum / 4 < 80) break;
//            {
//                System.out.print("fail" + cnt);
//            } else {
//                sum = 0;
//                cnt++;
//            }
        }System.out.print("Pass");

    }
}

// 5명 학생의 국어 영어 수학 과학 4과목의 점수를 입력 받아서 각 개인벼롤 평균이 80이상이면 "Pass" 그렇지 않으면 "fail"을 출력하고 합격한 사람의 수를 출력하는 프로그램을 작성하시오.