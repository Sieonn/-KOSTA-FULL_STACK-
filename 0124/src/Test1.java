import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dan1 = sc.nextInt();
        int dan2 = sc.nextInt();

        for(int i = 1; i <= 9; i++) {
            if (dan1 > dan2) {
                for (int dan = dan1; dan >= dan2; dan--) {
                    System.out.printf("%d*%d= %2d   ", dan, i, dan * i);
                }
            } else {
                for (int dan = dan1; dan <= dan2; dan++) {
                    System.out.printf("%d*%d= %2d   ", dan, i, dan * i);
                }

            }
        System.out.println();

        }
    }//2d는 정수가 두개라는뜻입니다. .2d여야 더블
}

