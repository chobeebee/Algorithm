import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        int[] mountains = new int[num];
        int count = 0;
        int maxCount = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            mountains[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < num; i++){
            for(int j = i+1; j < num; j++){
                if(mountains[i] > mountains[j]){
                    count++;
                }else {
                    break;
                }
            }
            maxCount = Math.max(maxCount, count);
            count = 0;
        }
        System.out.println(maxCount);
    }
}