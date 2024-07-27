import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 소수 찾기
         * 1과 자기 자신으로만 나누어지는 것
         * 어떻게..?
         *
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int num;
        int count = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            boolean prime = false;

            if(num == 1){
                continue;
            }

            for(int j =2; j<num; j++) {
                if(num % j == 0) {
                    prime =true;
                }
            }

            if(!prime) {
                count++;
            }
        }
        System.out.println(count);
    }
}