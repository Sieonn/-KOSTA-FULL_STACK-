package array;

import java.util.Scanner;

public class ArrayEx8 {
    public static void main(String[] args) {
        System.out.print("학생수를 입력하세요: ");
        Scanner scanner = new Scanner(System.in);
        int stud = scanner.nextInt();

        int [][] sarr = new int[stud][3];
        String [] subj = {"국어", "영어", "수학"};

        for(int i=0; i<sarr.length; i++){
            System.out.println((i+1)+"번 학생의 성적을 입력하세요.");
            for (int j=0; j<sarr[i].length; j++){
                System.out.print(subj[j]+" 점수:");
                sarr[i][j] = scanner.nextInt();
            }
        }

        for(int i=0; i<sarr.length; i++) {
            int sum = 0;
            for (int j = 0; j < sarr[i].length; j++) {

                sum += sarr[i][j];
            }
            System.out.println((i+1)+"번 학생의 총점: "+sum+", 평균:"+ sum/3.0);
        }

    }
}
