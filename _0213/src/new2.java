import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class new2 {
    public static void main(String[] args) {
        if(args.length<2) return;
        String readFile = args[0];
        String writeFile = args[1];

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(readFile);
            fos = new FileOutputStream(writeFile);
            byte[] buff = new byte[10];
            int len;
            while((len=fis.read(buff))>0) {
                fos.write(buff,0,len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null) fis.close();
                if(fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
