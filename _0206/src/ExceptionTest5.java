public class ExceptionTest5 {
    static void func2() throws Exception {
        func();
    }

    static void func() throws Exception {


        Exception exp = new Exception("내가 만든 예외");
        throw exp;
    }

    public static void main(String[] args) {
        try {
//            Exception exp = new Exception("내가만든 예외");
//            throw exp;
            func2();
        } catch (Exception e) {
            System.out.println("예외처리됨");
//            e.printStackTrace();
        }
    }
}
