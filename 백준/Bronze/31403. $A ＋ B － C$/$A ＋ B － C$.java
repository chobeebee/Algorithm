import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    * <A+B-C>
    * 문자열에서 + 는 이어붙이기, - 는 양쪽 문자열을 수로 해석 후 빼는 의미
    * 각 수 A,B,C 가 주어지고 수일때와 문자열일때, A + B - C 출력
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        // 숫자일 때
        System.out.println(Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C));

        // 문자열일 때
        System.out.println(Integer.parseInt(A + B) - Integer.parseInt(C));
    }
}