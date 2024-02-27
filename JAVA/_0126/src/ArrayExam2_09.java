import java.util.Scanner;

public class ArrayExam2_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] score = new int[11];
        int val;
        while (true) {
            val = sc.nextInt();
            if (val == 0) break;
            score[val / 10]++;
        }
        for (int i = score.length - 1; i >= 0; i--) {
            if (score[i] != 0) {
                System.out.println(String.format("%d : %d person", i * 10, score[i]));
            }
        }
    }
}
