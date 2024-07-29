import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i=0; i<N; i++){
            int num = i;
            int sum = 0;

            while(num != 0){
                sum += num % 10;
                num /= 10;
            }

            if(i + sum == N){
                result = i;
                break;
            }
        }
        
        System.out.println(result);        
    }
}