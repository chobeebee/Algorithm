import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * N+1개의 I와 N개의 O
         * 문자열 S안에 Pn이 몇 군데 포함인지 구하시오.
         * P1 = IOI
         * P2 = IOIOI
         * p3 = IOIOIOI
         * ...
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //N
        int S = Integer.parseInt(br.readLine()); //문자열 길이
        String[] str = br.readLine().split(""); //문자열

        int count = 0; //Pn개수
        int pattern = 0; //'IOI'패턴 연속 횟수
        
        for (int i = 1; i < S - 1; i++) {
            if (str[i - 1].equals("I") && str[i].equals("O") && str[i + 1].equals("I")) {
                pattern++;
                if (pattern == N) {
                    pattern--;
                    count++;
                }
                i++;
            }else{
                pattern = 0;
            }
        }

        System.out.println(count);
    }
}