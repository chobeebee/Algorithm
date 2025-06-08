import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    * <알람 시계>
    * 45분 일찍 알람 설정하기
    *
    * 0 <= 정수 H(시) <= 23, 0<= 정수 M(분) <= 59
    *---------------------------
    * 45분 기준으로 M이 작으면 H-- (= 0보다 작으면 23)
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken()); // 시간
        int M = Integer.parseInt(st.nextToken()); // 분

        if (M < 45) {
            H--;
            if (H < 0) H = 23;

            System.out.println(H + " " + ( 60 - (45 - M)));

        } else {
            System.out.println(H + " " + (M - 45));
        }
    }
}