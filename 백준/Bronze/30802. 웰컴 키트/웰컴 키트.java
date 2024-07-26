import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 티셔츠 6가지 사이즈, 같은 사이즈 T장 묶음 구매만 가능, 펜은 1종류 - P자루 묶음 || 1자루
         * N명 참가자 / 티셔츠 부족 X, 펜은 참가자 수 만큼
         * => 티셔츠 T장씩 최소 몇 묶음, 펜 P자루씩 최대 몇 묶음 && 한 자루씩 몇 개 주문?`
         *
         * 티셔츠 T보다 작으면 1묶음, 이상은 T기준 +1묶음
         * P*묶음+ 1묶음 개수 = N
         *
         * for문을 돌려서 T기준 묶음 수 판별 -> 모두 더 하기
         * 펜 1묵은 개수 = N % P
         *
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //참가자 수
        List<Integer> list = new ArrayList<>();
        int T = 0; //티셔츠 개수
        int P = 0; //펜 묶음 수
        int pen = 0;
        int mook = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 6; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        
        int sum = 0;
        for(int k = 0; k < 6; k++) {
            sum += Math.ceil((double)list.get(k)/T);
        }

        System.out.println(sum);

        pen = N % P;
        mook = N / P;

        System.out.print(mook + " " + pen);
    }
}