import java.io.*;

public class FileInputStreamTest1 {
    public static void main(String[] args) {
        if(args.length<2) return;
        String readFile = args[0];
        String writeFile = args[1];

        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            fis = new FileInputStream("cat.jpg");
            fos = new FileOutputStream("cat2.jpg");

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buff = new byte[10];
            int len;
            while((len=bis.read(buff))>0) {
                bos.write(buff,0,len);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fis!=null)
                    fis.close();
                if(fos!=null) fos.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
