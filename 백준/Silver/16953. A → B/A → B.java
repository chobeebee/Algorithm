import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static long A,B;
    static int count;

    public static void main(String[] args) throws IOException {
        /**
         * 정수 A를 B로 바꾸려 함
         * - 2를 곱한다
         * - 1을 수의 가장 오른쪽에 추가
         * 바꾸는데 필요한 연산의 최소값은?
         * 만들 수 있다면, 최소값+1 / 안되면 -1 출력
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        count = 1; //연산 횟수

        bfs();
    }

    private static void bfs() {
        Queue<Long> queue = new LinkedList<>();
        queue.add(A); //A값을 담아서 연산 시작

        while (!queue.isEmpty()) {
            int size = queue.size();

            //queue에 담긴 값을 하나씩 꺼내서 연산 적용
            for (int i = 0; i < size; i++) {
                long tmp = queue.poll();

                //현재 연산됐던 값이 B와 같다면 최소값 출력 후 종료
                if (tmp == B) {
                    System.out.println(count);
                    return;
                }

                //2를 곱했을 경우
                if (tmp * 2 <= B) {
                    queue.add(tmp * 2);
                }

                //1을 가장 오른쪽에 배치할 경우
                if (tmp * 10 + 1 <= B) {
                    queue.add(tmp * 10 + 1);
                }
            }
            count++; //연산 횟수+1
        }

        //연산으로 B값을 만들지 못할 경우
        System.out.println(-1);
    }
}