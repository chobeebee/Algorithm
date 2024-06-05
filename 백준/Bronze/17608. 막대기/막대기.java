import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int stickNum = Integer.parseInt(br.readLine());
        int[] woodSticks = new int[stickNum];
        int count = 0;

        for (int i = 0; i < stickNum; i++) {
            woodSticks[i] = Integer.parseInt(br.readLine());
        }
        
        int maxStick = woodSticks[stickNum - 1];
        for (int i = stickNum-2; i >=0; i--) {
            if(woodSticks[i] > maxStick) {
                count++;
                maxStick = woodSticks[i];
            }
        }

        System.out.println(count+1);
    }
}