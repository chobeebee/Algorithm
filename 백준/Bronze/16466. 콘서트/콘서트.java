import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        int[] sold = new int[num];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < num; i++){
            sold[i] = Integer.parseInt(st.nextToken()); //팔린 티켓
        }

        Arrays.sort(sold);

        int count = 1;
        for(int i = 0; i < num; i++){
            if(sold[i] != i+1){
                break;
            }
            count++;
        }

        System.out.println(count);
    }
}