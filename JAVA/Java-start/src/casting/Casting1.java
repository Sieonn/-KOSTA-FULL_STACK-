package casting;

public class Casting1 {
    public static void main(String[] args) {
        int intValus = 10;
        long longValue;
        double doubleValue;

        longValue = intValus;
        System.out.println("longValue = " +longValue);

        doubleValue = intValus;
        System.out.println("doubleValue = " + doubleValue);

        doubleValue = 20L;
        System.out.println(doubleValue);

    }
}
