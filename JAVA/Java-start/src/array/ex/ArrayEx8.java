package array.ex;

import java.util.Scanner;

public class ArrayEx8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("학생수를 입력하세요:");
        int stdno = scanner.nextInt();
        int [][]score = new int[stdno][3];
        String[] subj = {"국어", "영어","수학"};
        for(int i=0; i<subj.length; i++){
            System.out.println(i+1+"번 학생의 성적을 입력하세요:");
            for(int j=0; j<score[i].length; j++) {
                System.out.print(subj[j] + "점수:");
                score[i][j] = scanner.nextInt();
            }
        }
        for(int i=0; i<score.length; i++){
            int sum=0;
            for(int j=0; j<score[i].length; j++){
                sum+=score[i][j];
            }
            double avg = sum/3.0;
            System.out.println(i+1+"번 학생의 총점:"+ sum+", 평균:"+ avg);
        }


    }
}
