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
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            sold[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, sold[i]);
        }

        Arrays.sort(sold);

        int count = 0;
        for(int i = 0; i < num; i++){
            if(sold[i] != i+1){
                System.out.println(i+1);
                count++;
                break;
            }
        }
        if (count == 0) {
            System.out.println(num+1);
        }
    }
}