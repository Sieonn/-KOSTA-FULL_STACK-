package chapter09;

public class Exam10 {

        static String format(String str, int lenth, int aligment) {
            if (lenth < str.length()) return str.substring(0, lenth);
            char[] tchar = new char[lenth];
            for (int i = 0; i < tchar.length; i++) {
                tchar[i] = ' ';
            }
            int startIdx;
            if (aligment == 0) {
                startIdx = 0;
            } else if (aligment == 1) {
                startIdx = (lenth - str.length()) / 2;
            } else {
                startIdx = lenth - str.length();
            }
            System.arraycopy(str.toCharArray(), 0, tchar, startIdx, str.length());
            return new String(tchar);

        }

        /*
         (1) format메서드를 작성하시오.
        1. length의 값이 str의 길이보다 작으면 length만큼만 잘라서 반환한다.
        2. 1의 경우가 아니면, length크기의 char배열을 생성하고 공백으로 채운다.
        3. 정렬조건(alignment)의 값에 따라 문자열(str)을 복사할 위치를 결정한다.
         (System.arraycopy()사용)
        4. 2에서 생성한 char배열을 문자열로 만들어서 반환한다.
        */
        public static void main(String[] args) {
            String str = "가나다";
            System.out.println(format(str, 7, 0)); // 왼쪽 정렬
            System.out.println(format(str, 7, 1)); // 가운데 정렬
            System.out.println(format(str, 7, 2)); // 오른쪽 정렬
        }
    }
