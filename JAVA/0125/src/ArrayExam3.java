public class ArrayExam3 {
    public static void main(String[] args) {
        int[][] score = {
                {50, 50, 50, 50},
                {60, 60, 60, 60},
                {70, 70, 70, 70}};
        int[][] tot = new int[score.length + 1][score[0].length + 1];
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                tot[i][j] = score[i][j]; //행열 복사하는 법
                tot[i][tot[i].length - 1] += tot[i][j]; //tot[i][4] += tot[i][j]
                tot[tot.length - 1][j] += tot[i][j];
                tot[tot.length - 1][tot[i].length - 1] += tot[i][j];

            }
        }
        for (int i = 0; i < tot.length; i++) {
            for (int j = 0; j < tot[i].length; j++) {
                System.out.print(tot[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
//50 50 50 50 200
//60 60 60 60 240
//70 70 70 70 280
//50 50 50 50 0