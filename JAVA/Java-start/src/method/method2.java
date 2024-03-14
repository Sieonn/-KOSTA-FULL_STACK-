package method;

import javax.xml.transform.Source;
import java.security.PublicKey;

public class method2 {
    public static void main(String[] args) {
        printHeader();
        System.out.println("=프로그램이 동작합니다.=");
        printFooter();
    }
    public static void printHeader() {
        System.out.println("=프로그램을 시작합니다.=");
        return; //return을 생략가능.

    }
    public static void printFooter() {
        System.out.println("=프로그램을 종료합니다.=");
    }
}
