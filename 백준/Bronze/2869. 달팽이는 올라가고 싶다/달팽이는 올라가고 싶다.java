import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    * <달팽이는 올라가고 싶다>
    * - 높이가 V미터인 나무 막대
    * - 달팽이는 낮에 A미터 올라갈 수 있음
    * - 밤에는 B미터 미끄러짐
    * - 나무 막대를 모두 올라가려면 며칠이 걸리는지 구하시오.
    *
    * 1 <= B <= A <= 1,000,000,000
    *
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 낮에 올라가는 길이
        int B = Integer.parseInt(st.nextToken()); // 밤에 미끄러지는 길이
        int V = Integer.parseInt(st.nextToken()); // 나무 막대 길이
        int days = (int)Math.ceil((V - A) / (double)(A - B)) + 1;

        System.out.println(days);
    }
}