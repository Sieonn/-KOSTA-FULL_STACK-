package test01;

public class TestMain01 {
    public static void main(String[] args) {
        int [][] arrs = {{12, 41, 36, 56, 21},
                {82, 10, 12, 61, 45},
                {14, 16, 18, 78, 65},
                {45, 26, 72, 23, 34}};
        double sum = 0;
        double average;
        for(int i=0; i < arrs.length; i++) {
            for(int j=0; j < arrs[i].length; j++) {
                sum += arrs[i][j];
            }
        } average = sum / 20;
        System.out.println("합계:"+ sum);
        System.out.println("평균:"+ average);
    }
}
