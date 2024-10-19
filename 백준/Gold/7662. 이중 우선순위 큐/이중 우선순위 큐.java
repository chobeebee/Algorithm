import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 이중 우선순위 큐
         * 차이점은 데이터를 삭제할 때 연산 명령에 따라 우선순위가 가장 높은 데이터 || 가장 낮은 데이터 중 하나를 삭제
         * 두 가지 연산 : 삽입, 삭제(우선 순위 가장 높은 것, 낮은 것)
         *
         * 테스트 데이터 수 T, 각 테스트 첫 줄의 연산 개수 k <=1,000,000
         * I : 삽입 연산, D : 삭제 연산, D -1 : 최솟값 삭제
         * 모든 연산 처리 후 Q에 남아 있는 값 중 최대값, 최소값을 출력!
         * Q가 비어있다면 'EMPTY' 출력
         *
         * -------
         * 우선순위 큐를 두 개 사용하면, O(n)의 시간 복잡도가 발생 -> 시간이 초과
         * 대신, 키 값으로 정렬하는 TreeMap 자료 구조 이용
         * key: 정수, value: 정수가 입력된 횟수
         * 입력된 횟수를 이용하여 같은 정수가 또 입력되어도 1개 삭제 되도록 할 수 있음
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); //테스트 데이터 수

        for (int i = 0; i < T; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine()); //연산의 개수

            //입력된 연산 만큼 반복
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String cal = st.nextToken(); //연산
                int num = Integer.parseInt(st.nextToken()); //정수

                //I이면 삽입, D면 삭제, D -1이면 최솟값 삭제, map이 비었다면 연산X
                if (cal.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }else if(map.isEmpty()){
                    continue;
                }else{
                    //num이 1이면 최댓값, -1이면 최솟값
                    int key = num == 1? map.lastKey() : map.firstKey();
                    int cnt = map.get(key); //해당 정수의 입력 횟수

                    //정수가 1개라면 삭제, 1개 이상이면 -1 차감
                    if (cnt == 1) {
                        map.remove(key);
                    }else{
                        map.put(key, cnt - 1);
                    }
                }
            }

            //map이 비었으면 EMPTY 출력, 아니면 최댓값 최솟값 출력
            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            }else{
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}