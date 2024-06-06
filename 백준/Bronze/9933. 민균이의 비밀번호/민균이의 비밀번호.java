import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int wordsNum = Integer.parseInt(br.readLine());
        String[] words = new String[wordsNum];

        for(int i = 0; i < wordsNum; i++){
            words[i] = br.readLine();
        }

        for(int i = 0; i < words.length-1; i++){
            for(int j = 0; j < words.length; j++){
                StringBuilder reverse = new StringBuilder(words[j]);

                if(words[i].equals(reverse.reverse().toString())){
                    int length = words[i].length();
                    int idx = length/2;

                    System.out.println(length +" "+ words[i].charAt(idx));
                    return;
                }
            }
        }
    }
}