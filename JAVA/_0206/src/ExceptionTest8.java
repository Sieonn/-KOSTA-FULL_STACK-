public class ExceptionTest8 {
    public static void main(String[] args) {
        try {
            String str = null;
            System.out.println(str.toString());
            System.out.println("마무리 처리");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("마무리 처리");//예외가 발생하든 하지 않든 꼭 처리해야할 문장
        }
    }
}
