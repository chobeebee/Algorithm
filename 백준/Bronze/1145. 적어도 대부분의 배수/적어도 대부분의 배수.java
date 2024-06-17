import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;

        int[] arr = new int[5];
        int count = 0;
        int num = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            for (int i = 0; i < 5; i++) {
                if (num % arr[i] == 0) {
                    count++;
                }
            }
            if (count >= 3) {
                System.out.println(num);
                return;
            }else{
                num++;
                count = 0;
            }
        }
    }
}