import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int N, places;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        /**
         * 맥주를 마시며 락 페스티벌 가려고 함. 맥주 한 박스 들고 상근이네 집에서 출발.
         * 한 박스에 맥주 20병. 50미터에 1병 마심.
         * 중간에 편의점 들리면, 빈병은 버리고 새 맥주 병 사기. 하지만, 한 박스에 맥주 20병 못 넘김.
         * 편의점 나선 직후에도 50미터 가기전 1병 마셔야 함.
         * 편의점, 상근이네, 락 페스티벌 좌표가 주어지고, 도착할 수 있으면 "happy", 맥주가 바닥나서 이동할 수 없으면 "sad" 출력
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int T = Integer.parseInt(br.readLine()); //테스트 수
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine()); //편의점 수
            places = N+2;
            map = new int[places][2];
            visited = new boolean[places];

            for (int j = 0; j < places; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                map[j][0] = Integer.parseInt(st.nextToken()); //x
                map[j][1] = Integer.parseInt(st.nextToken()); //y
            }

            bfs(0);
        }


    }

    private static void bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { start, 20 }); //현위치, 맥주 개수
        visited[start] = true;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            int cur = current[0];
            int beer = current[1];

            //락 페스티벌 도착할 경우 happy출력
            if(cur == N+1){
                System.out.println("happy");
                return;
            }

            for (int i = 1; i < places; i++) {
                if (!visited[i]) {
                    //현 위치와 다음 위치 간 거리
                    int distance = Math.abs(map[cur][0] - map[i][0]) + Math.abs(map[cur][1] - map[i][1]);

                    //이동이 가능하고 맥주가 충분한지 체크
                    if (distance <= beer * 50) { //50미터당 1병
                        visited[i] = true;
                        //편의점에 도착하면 맥주 20병 채우고 큐에 넣기
                        if (i != N + 1) {
                            queue.add(new int[] { i, 20 });
                        } else {
                            //편의점이 아니라면 이동 후 남은 맥주를 큐에 넣기
                            queue.add(new int[] { i, beer - (distance / 50) });
                        }
                    }
                }
            }
        }

        //페스티벌 도착하지 못하면 sad 출력
        System.out.println("sad");
    }
}