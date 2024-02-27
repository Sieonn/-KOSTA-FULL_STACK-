class Exception2 extends Exception {
    Exception2() {
        super("사용자예외1");
    }

    Exception2(String msg) {
        super(msg);
    }
}

class Exception3 extends Exception {
    Exception3() {
        super("사용자 예외3");
    }
}

class Exception4 extends Exception {
    Exception4() {
        super("사용자예외4");
    }
}

public class ExceptionTest7 {
    public static void func() throws Exception2 {
        throw new Exception2();

    }

    public static void func2() throws Exception3 {
        throw new Exception3();
    }

    public static void func3() throws Exception4 {
        throw new Exception4();
    }

    public static void main(String[] args) {
        try {
            func();
            func2();
            func3();
        } catch (Exception3 e4) {
            System.out.println("func2의 대체처리");
        } catch (Exception2 e2) {
            System.out.println("func의 대체처리");
        } catch (Exception4 e2) {
            System.out.println("func4의 대체처리");
        }

    }
}
