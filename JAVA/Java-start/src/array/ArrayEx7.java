package array;

import java.util.Scanner;

public class ArrayEx7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //내가 작성한 코드---------------------------------
//        int [] students = new int[4];
//        for (int i =0; i<students.length; i++){
//            int sum=0;
//            System.out.println((i+1)+"번 학생의 성적을 입력하세요.");
//            System.out.print("국어점수: ");
//            int kor = scanner.nextInt();
//            sum += kor;
//            System.out.print("영어 점수:");
//            int eng = scanner.nextInt();
//            sum += eng;
//            System.out.print("수학 점수:");
//            int math = scanner.nextInt();
//            sum += math;
//            students[i] +=sum;
//        }
//        for(int i=0; i<students.length; i++){
//            System.out.println((i+1)+"번 학생의 총점:"+students[i]+", "+"평균: "+(double)students[i]/3 );
//        }


        // 답안 정답! 이차원 배열을 사용했음.
        int[][] score = new int[4][3];
        String[] subjects = {"국어","영어", "수학"};

        for(int i=0; i<4; i++){
            System.out.println((i+1)+"번 학생의 성적을 입력하세요.");
            for(int j=0; j<3; j++){
                System.out.print(subjects[j]+" 점수:");
                score[i][j] =scanner.nextInt();
            }
        }
        for(int i=0; i<4; i++){
            int total=0;
            for(int j=0; j<3; j++){
                total+= score[i][j];
            }
            double average = total/3.0;
            System.out.println((i+1)+"번 학생의 총점: "+total+", 평균: "+ average);
        }
    }
}
