import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int sum = 1;
        int idx = 1;

		if(N == 1){
			System.out.println(1);
			return;
		}
		
        while (true) {
            int gob = 6*idx;
            sum+=gob;
            if (N <= sum) {
                break;
            }else{
                idx++;
            }
        }

        System.out.println(idx+1);
    }
}