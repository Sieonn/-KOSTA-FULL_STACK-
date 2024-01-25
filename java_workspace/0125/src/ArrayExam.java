import jdk.jshell.spi.ExecutionControl;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.net.SocketOption;

public class ArrayExam {
    public static void main(String[] args) {
        //psvm public머시기 바로호다닥 나온다.
//        char[] hex = {'c', 'a', 'f', 'e'};  //329dfc
        char[] hex = {'3', '2', '9', 'D', 'E', 'F'}; //001100101001110111101111
        String[] binary = {
                "0000", "0001", "0010", "0011",
                "0100", "0101", "0110", "0111",
                "1000", "1001", "1010", "1011",
                "1100", "1101", "1110", "1111",
        };
        String result = "";
        for(int i = 0; i< hex.length; i++) {
            if(hex[i]>='0' && hex[i]<='9') {  //숫자형 문자
                result += binary[hex[i]-'0'];
            } else if(hex[i]>='A' && hex[i]<='Z') {//대문자
                result += binary[hex[i]-'A'+10];
            } else { //소문자
                result += binary[hex[i] -'a'+10];
                
            }

        }
        System.out.println(result);
    }
}

//hex코드는 16진스
