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
        for(int number: numbers) {
            System.out.println(number);
        }
        //for-each문을 사용할 수 없는 경우는 증가하는 index값이 필요할 때입니다.
        for(int i=0; i<numbers.length; i++){
            System.out.println("number"+i+"번의 결과는:"+numbers[i]);
        }

    }
}
