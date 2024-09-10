import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 한번 입었던 옷은 다시 입지 않는다
         * 알몸이 아닌 상태로 며칠 동안 돌아다닐 수 있는가?
         * 의상의 이름과 의상의 종류
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                map.put(type, map.getOrDefault(type,0) +1);
            }
            int ans = 1;
            for (int val : map.values()) {
                ans*= val + 1;
            }
            System.out.println(ans - 1);
        }
    }
}