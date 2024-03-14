package loop.ex;

public class WhileEx3 {
    public static void main(String[] args) {
        int max = 100;
        int count = 1;
        int sum=0;
        while (count<=max){
            sum += count;
            System.out.println("max="+count);
            System.out.println(sum);
            count++;
        }
    }
}
