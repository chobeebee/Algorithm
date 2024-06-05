import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String plateStack  = br.readLine();
        boolean[] state = new boolean[plateStack.length()];
        int totalHeight = 10; //첫 그릇 10 기본

        for(int i = 0; i < plateStack.length(); i++){
            state[i] = plateStack.charAt(i) == '(';
        }

        for (int i = 0; i < plateStack.length() -1; i++) {
            if(state[i] == state[i+1]){
                totalHeight+=5;
            } else {
                totalHeight+=10;
            }
        }

        System.out.println(totalHeight);
    }
}