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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        List<String> totalList = new ArrayList<>();
        int length = 1;

        for (int i = 0; i < 5; i++) {
            String word = br.readLine();
            totalList.add(word);

            length = Math.max(word.length(), length);
        }

        for (int i = 0; i < length; i++) {
            for(int j = 0; j < 5; j++) {
                if(totalList.get(j).length() > i){
                    sb.append(totalList.get(j).charAt(i));
                }
            }
        }

        System.out.println(sb);
    }
}