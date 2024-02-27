package chapter09;

import java.util.SplittableRandom;

public class Exam09 {
    // 특정 문자들을 제거하는 메소드
    static String delChar(String src, String delCh) {
        StringBuffer sb = new StringBuffer(src);  // 문자열을 수정할 StringBuffer 객체 생성

        // delCh 문자열에 포함된 각 문자에 대해 반복
        for (int i = 0; i < delCh.length(); i++) {
            int pos = 0;  // 문자의 위치를 나타내는 변수 초기화
            char ch = delCh.charAt(i);  // 현재 반복에서 처리할 문자 가져오기

            // StringBuffer에서 해당 문자를 찾아서 삭제하는 작업을 반복
            while (true) {
                pos = sb.indexOf(ch + "");  // 문자의 위치 찾기
                if (pos == -1) break;  // 더 이상 해당 문자가 없으면 반복문 종료
                sb.deleteCharAt(pos);  // 문자 삭제
            }
        }

        return sb.toString();  // 수정된 문자열을 String 형태로 반환
    }

    // 메인 메소드: delChar 메소드를 테스트하는 용도
    public static void main(String[] args) {
        // 테스트 케이스 1: "(1!2@3^4~5)" 문자열에서 "~!@#$%^&&*()"에 해당하는 문자 제거
        System.out.println("(1!2@3^4~5)" + "->" + delChar("(1!2@3^4~5)", "~!@#$%^&&*()"));
        // 결과: "12345"

        // 테스트 케이스 2: "(1 2 3 4\t5)" 문자열에서 "\t"에 해당하는 문자 제거 (탭 문자)
        System.out.println("(1 2 3 4\t5)" + "->" + delChar("(1 2 3 4\t5)", "\t"));
        // 결과: "12345"
    }
}
