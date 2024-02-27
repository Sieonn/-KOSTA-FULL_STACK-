package chapter04;

public class Exam12 {
    public static void main(String[] args) {
        for (int i = 0, dan = 2; i < 3; i++, dan += 3) {
            for (int j = 1; j <= 3; j++) {
                for (int k = dan; k <= (dan + 2 < 10 ? dan + 2 : 9); k++) {
                    System.out.printf("%d*%d=%d\t", k, j, k * j);
                }
                System.out.println();
            }
            System.out.println();
//        for(int i = 1; i<=3; i++) {
//            for(int dan=5; dan<=7; dan++) {
//                System.out.printf("%d*%d=%d", dan,i,dan*i);
//            }
//        }System.out.println();
//        for(int i = 1; i<=3; i++) {
//            for(int dan=8; dan<=8; dan++) {
//                System.out.printf("%d*%d=%d", dan,i,dan*i);
//            }
        }
    }
}
//초기화를 동시에할때는 개수를 쓰면 안된다. 갯수를 쓸수 있는것은 new뒤에