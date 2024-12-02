import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 자신의 결혼식에 자신의 학교 동기 중 친구와 친구의 친구를 초대
         * 상근이 동기는 모두 N명, 학번은 1~N, 상근이 학번은 1
         * 결혼식에 초대하는 동기의 수는?
         *
         * 상근이와 직접 연관된 친구 뽑고
         * 그 친구와 바로 관계된 친구를 뽑으면 될 것 같다!
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //동기 수
        int M = Integer.parseInt(br.readLine()); //리스트 길이
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> friends = new HashSet<>();

        //map 초기화
        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }

        //친구 관계 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            map.get(b).add(a);
        }

        //상근이 친구
        for (int m : map.get(1)) {
            friends.add(m);

            //상근이 친구의 친구
            for (int next : map.get(m)) {
                //상근이 제외
                if (next != 1) {
                    friends.add(next);
                }
            }
        }

        //상근이가 초대할 동기 수 출력
        System.out.println(friends.size());
    }
}