import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int unit = 10;
        String word = br.readLine();

        for (int i = 0; i < word.length(); i+=unit) {
            String cutWord;
            int endLength = i+unit;

            if(word.length() < endLength){
                cutWord = word.substring(i);
            }else {
                cutWord = word.substring(i,endLength);
            }
            System.out.println(cutWord);
        }
    }
}