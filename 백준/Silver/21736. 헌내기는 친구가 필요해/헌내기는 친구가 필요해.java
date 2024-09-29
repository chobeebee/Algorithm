import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        /**
         * 도연이 캠퍼스 크기 : NxM, 이동 방법 : 상하좌우
         * 도연이가 만날 수 있는 사람의 수 출력
         * o : 빈공간, x : 벽, I : 도연이, p : 시람
         * 아무도 만나지 못하면 TT 출력
         *
         * BFS로 풀면 될 것 같다!
         * 상하좌우에 대한 디렉션 변수 만들고
         * 방문 체크 배열로 만난 사람 체크하고
         * 큐로 좌표 탐색
         * p를 만나면 count++, x를 만나면 멈춤
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //캠퍼스 가로
        int M = Integer.parseInt(st.nextToken()); //캠퍼스 세로
        String[][] campus = new String[N][M]; //캠퍼스 구성
        boolean[][] visited = new boolean[N][M]; //방문 체크
        int startX=0; //도연이가 위치한 x좌표
        int startY=0; //도연이가 위치한 y좌표

        //입력된 캠퍼스 구성
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                String now = line.substring(j, j+1);
                campus[i][j] = now;
                //I가 나오면 위치 값 저장
                if(now.equals("I")){
                    startX = i;
                    startY = j;
                }
            }
        }
        bfs(campus, visited, N, M, startX, startY);
    }

    private static void bfs(String[][] campus, boolean[][] visited, int N, int M, int StartX, int StartY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{StartX,StartY});
        visited[StartX][StartY] = true; //현재 위치 방문 표시
        int freind = 0; //만나는 친구 체크

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (campus[x][y].equals("P")) {
                freind++;
            }
            
            //사방 탐색
            for (int i = 0; i < dx.length; i++) {
                int newX = x + dx[i]; //현 위치에서 좌우 위치
                int newY = y + dy[i]; //현 위치에서 상하 위치
                
                //캠퍼스 범위를 넘지 않고 방문하지 않은 위치일 때
                if (newX < N && newY < M && newX >= 0 && newY >= 0 && !visited[newX][newY]) {
                    if (campus[newX][newY].equals("X")) {
                        continue;
                    }
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        //친구 출력
        if (freind == 0) {
            System.out.println("TT");
        }else{
            System.out.println(freind);
        }
    }
}