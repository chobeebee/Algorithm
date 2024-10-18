import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 주사위 1~6, 크기 10x10의 100개 칸 보드판 1~100 숫자가 적혀있음
         * i번 칸에서 주사위 4가 나오면 i+4
         * 도착한 칸이 사다리면 사다리타고 위로 올라감, 뱀이 있다면 뱀을 따라서 내려감
         * 100번 칸에 도착하기 위해 주사위를 굴려야 하는 최솟값은?
         *
         * 1<=사다리 개수 N<= 15, 1<=뱀의 수 M<=15
         * 사다리 정보(x<y) : x번 칸에 도착하면 y번 칸으로 이동
         * 뱀의 정보(u>v) : u번 칸에 도착하면 v번 칸으로 이동
         *
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //사다리 개수
        int M = Integer.parseInt(st.nextToken()); //뱀의 수
        int[] board = new int[101]; //보드 판
        int[] visited = new int[101]; //방문 순서 체크

        //보드판 번호 입력
        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        //사다리 위치 정보
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); //사다리가 있는 칸
            int y = Integer.parseInt(st.nextToken()); //사다리로 이동하는 칸

            board[x] = y;
        }

        //뱀 위치 정보
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); //뱀이 있는 칸
            int v = Integer.parseInt(st.nextToken()); //뱀으로 이동하는 칸

            board[u] = v;
        }

        bfs(board,visited, 1);

    }

    private static void bfs(int[] board, int[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); //시작 위치 큐에 저장
        visited[start] = 0; //시작 위치 방문 처리

        while (!queue.isEmpty()) {
            int curPoint = queue.poll(); //현재 위치 꺼내기

            //주사위 수 만큼 반복
            for (int i = 1; i <= 6; i++) {
                int movePoint = curPoint + i;

                //100이 넘어가면 넘어가기
                if(movePoint > 100) continue;

                //방문하지 않았다면
                if (visited[board[movePoint]] == 0) {
                    queue.add(board[movePoint]);
                    visited[board[movePoint]] = visited[curPoint] + 1; //현위치까지 진행했던 주사위 횟수+1
                }

                //100에 도착하면 끝내기
                if(board[movePoint] == 100) break;
            }
        }
        //100번에 도착했을 때까지 진행한 횟수
        System.out.println(visited[100]);
    }
}