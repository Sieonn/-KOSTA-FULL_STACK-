import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

public class SequenceStreamTest2 {
    public static void main(String[] args) {
        SequenceInputStream sis = null;
        FileOutputStream fos = null;
        try {
            Vector<InputStream> list = new Vector<>();
            list.add(new FileInputStream("pubao1.txt"));
            list.add(new FileInputStream("pubao2.txt"));
            list.add(new FileInputStream("pubao3.txt"));

            sis = new SequenceInputStream(list.elements());
            fos = new FileOutputStream("pubao.txt");
            byte[] buff = new byte[1024];
            int len;
            while ((len = sis.read(buff)) > 0) {
                fos.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (sis != null) sis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
