import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    * <검증수>
    * 컴퓨터마다 6자리 고유번호를 매김
    * 00000<= 처음 5자리 <= 99999
    * 6번째 자리 = 검증수 = 처음 5자리 숫자 각각 제곱한 수의 합 % 10
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0; // 각 5자리 숫자 제곱 합

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum += (num * num);
        }
        
        System.out.println(sum % 10);
    }
}