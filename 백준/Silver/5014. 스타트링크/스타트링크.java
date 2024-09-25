import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 총 F층 건물, 스타트링크는 G층, 강호가 있는 곳은 S층
         * 강호가 탄 엘베는 버튼 2개만 있음 : 위로 U층, 아래로 D층
         * G층에 도착하려면 적어도 몇 번 눌러야 하는지 구하시오.
         * 갈 수 없다면 "use the stairs" 출력
         *
         * 1층부터 시작, 가장 높은 층은 F
         * S층에서 G층으로 가기 위한 버튼의 수 최솟값
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken()); //총 건물 높이
        int S = Integer.parseInt(st.nextToken()); //현재 위치한 층
        int G = Integer.parseInt(st.nextToken()); //목적지
        int U = Integer.parseInt(st.nextToken()); //위로 올라가는 층수
        int D = Integer.parseInt(st.nextToken()); //아래로 내려가는 층수
        int[] upDown = {U,-D};

        boolean[] visited = new boolean[F+1]; //방문 체크

        bfs(visited, F, S, G, upDown);
    }

    private static void bfs(boolean[] visited, int F, int S, int G, int[] upDown) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{S, 0});
        visited[S] = true;

        while (!queue.isEmpty()) {
            int[] curArr = queue.poll(); //현재 있는 위치
            int current = curArr[0];
            int count = curArr[1];
            visited[current] = true; //현재 위치 방문 체크

            if(current == G) {
                System.out.println(count);
                break;
            }

            //엘레베이터 상하 이동
            for (int i = 0; i < upDown.length; i++) {
                int move = current + upDown[i];

                if (move <= F && move >= 1 && !visited[move]) {
                    visited[move] = true;
                    queue.add(new int[]{move,count+1});
                }
            }

            if (queue.isEmpty()) {
                System.out.println("use the stairs");
            }
        }
    }
}