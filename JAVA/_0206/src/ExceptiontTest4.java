public class ExceptiontTest4 {
    public static void func() throws Exception
    {
        String str = null;
        try {
            System.out.println(str.toString());
        } catch (Exception e) {
            System.out.println("func exception 처리");
            throw new Exception("새로운 예외");
//        System.out.println(str.toSTring());
    }

        }
    public static void main(String[] args) {
//        String str = null;
//        System.out.ptinyln(str.toString())
        try {
            func();
        } catch(Exception e) {
            System.out.println("Main exception 처리");
        }
    }

}
