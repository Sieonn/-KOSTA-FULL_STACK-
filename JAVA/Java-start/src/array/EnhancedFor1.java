package array;

public class EnhancedFor1 {
    public static void main(String[] args) {
        int [] numbers = {1, 2, 3, 4,5};
        //일반 for문
        for(int i =0; i<numbers.length; i++){
            int number = numbers[i];
            System.out.println(number);
        }
        //향상된 for문,for-each문
        //for( 변수 : 배열) 배열을 청므부터 끝까지 하나씪 순회를 합니다.
       //인덱스를 사용하고  종료 조건을 주지 않아도 된다
        // 단순히 해당 배열을 처음부터 끝까지 탐색한다.
        //오른쪽에는 탐색할 배열 왼쪽에는 탐색으로 찾은 값을 저장할 변수를 선언.
        //하나씩 증가하는 것이 아니라 증가하는 값을 설정해 주어야할 때는
        //향상된 배열의 값을 사용하지 못합니다.
        for(int number: numbers) {
            System.out.println(number);
        }
    }
}
