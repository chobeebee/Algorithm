import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 10진법 N을 B진법으로 바꿔서 출력
         * 10진법을 넘어가는 자리는 알파벳 대문자로 대체
         * A:10, B:11~ Z:35
         *
         * 2<=B<=36
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        while (N > 0) {
            if (N % B < 10) {
                if(N % B == 0) {
                    sb.append("0");
                }else{
                    sb.append(N % B); //나머지가 10미만이면 그대로 숫자 출력
                }
            }else{
                sb.append((char) (N % B - 10 + 'A')); //'A'(65)를 기준으로 알파벳 계산
            }
            N = N / B; //B로 나누고 남은 N값
        }

        System.out.println(sb.reverse());
    }
}