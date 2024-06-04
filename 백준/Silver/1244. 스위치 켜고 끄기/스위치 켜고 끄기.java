import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;

        int sw = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        boolean[] state = new boolean[sw];
        int[] state2 = new int[sw];

        for(int i = 0; i < sw; i++) {
            int tt = Integer.parseInt(st.nextToken());
            if(1 == tt){
                state[i] = true;
            }else{
                state[i] = false;
            }
        }

        int student = Integer.parseInt(br.readLine());
        int girlNum = 0;
        int boyNum = 0;

        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken()) -1;

            if(gender == 1) {
                for(int j = 1; j <= sw; j++) {
                    if(j % (number+1) == 0){
                        state[j-1] = !state[j-1];
                    }
                }
            }else if(gender == 2) {
                state[number] = !state[number];

                for(int j = 0; j < sw; j++) {
                    if(number+j >= sw || number-j < 0) break;

                    if(state[number+j] == state[number-j]){
                        state[number+j] = !state[number+j];
                        state[number-j] = !state[number-j];
                    }else {
                        break;
                    }
                }
            }
        }

        for(int i = 0; i < sw; i++) {
            if(state[i]){
                state2[i] = 1;
            }else{
                state2[i] = 0;
            }
        }
        for(int i = 0; i < sw; i++) {
            System.out.print(state2[i] + " ");
            if((i+1) % 20 == 0){
                System.out.println();
            }
        }
    }
}