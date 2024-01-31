package chapter06;

public class Exam20 {
    static int[] shuffle(int[] arr) {
        for (int i = 0; i < 200; i++) {
            int idx1 = (int) (Math.random() * 9);
            int idx2 = (int) (Math.random() * 9);
            int tmp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = tmp;
        }
        return arr;
    }
    public static void main(String[] args)
    {
        int[] original = {1,2,3,4,5,6,7,8,9};
        System.out.println(java.util.Arrays.toString(original));
        int[] result = shuffle(original);
        System.out.println(java.util.Arrays.toString(result));
    }
}
