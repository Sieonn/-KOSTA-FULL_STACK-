public class ArrayExam2_04_2 {
    public static void main(String[] args) {
        int ppre = 1;
        int pre =1;
        int curr;
        for(int i=2; i<40; i++){
            curr =  ppre+ pre;
            ppre = pre; //전과 전전 항의 값을 저장하는 순서가 매우 중요합니다
            pre = curr; //값을 덮어쓰는 개념이기 때문에 초기 값이 달라질 수 있습니다.
            if(i%10==9) {
                System.out.println(String.format("피보나치 수열 %d 항: %d",i+1, curr ));
            }
        }
    }
}
//배열을 사용하지 않고 피보나치 수열 출력하기.
