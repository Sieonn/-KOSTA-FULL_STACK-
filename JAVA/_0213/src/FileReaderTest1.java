import java.io.*;
import java.util.ArrayList;

public class FileReaderTest1 {
    public static void main(String[] args) {
        FileReader fis = null;
        FileWriter fw = null;
        try {
            fis= new FileReader("news.txt");
            fw = new FileWriter("news-copy.txt");


            //배열을 이용해서 파일 복사
            char[] buff = new char[128];
            int len;
            while((len = fis.read(buff))>0) {
                fw.write(buff,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if(fis!=null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
