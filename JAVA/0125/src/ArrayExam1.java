public class ArrayExam1 {
    public static void main(String[] args) {
        char[] carr = {'A','E', 'C', 'X', 'y', 'c', 'b', 'z', 'e'};
        //carr의 순서를 거꾸로 출력하기
        for(int i=carr.length-1; i>=0; i--) {
            System.out.print(carr[i]+" ");
        }
//        System.out.print(carr);
    }
}
