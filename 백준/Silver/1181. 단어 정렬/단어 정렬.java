import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static final int m = 1234567891;
    static final int r = 31;

    public static void main(String[] args) throws IOException {
        /**
         * N개 단어 : 짧은 순, 길이가 같을 시 사전 순
         * 중복 단어는 하나만
         * 문자열 길이 < 50
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(list.contains(s)) {
                continue;
            }
            list.add(s);
        }

        Collections.sort(list, (a, b) ->{
            if(a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        for(String s : list) {
            System.out.println(s);
        }
    }
}