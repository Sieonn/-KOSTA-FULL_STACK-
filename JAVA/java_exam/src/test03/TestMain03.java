package test03;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TestMain03 {
    public static void main(String[] args) {
        String str = "1.22,4.12,5.93,8.71,9.34";
        double data[] = new double[5];
        double sum = 0;

        String [] stl = str.split(",");
        int index =0;
        for(String s: stl) {
            data[index] = Double.parseDouble(s);
            sum+= data[index++];
        }
        System.out.printf("%.3f%n",sum);
        System.out.printf("%.3f",sum/stl.length);

    }
}
