import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0,-1, 1};

    static int N;
    static int M;
    static int[][] paper;
    static boolean[][] visited;
    static int maxSum = 0; //합의 최대값

    public static void main(String[] args) throws IOException {
        /**
         * 폴리오미노 : 1*1 정사각형을 이어붙인 도형
         * 변끼리 연결
         * 테트로미노 : 정사각형 4개를 이어붙인 도형
         *
         * 아름이는 크기가 N*M인 종이 위에 테트로미노를 하나 놓으려고 함
         * 종이는 1*1 크기 칸에 정수가 하나씩 쓰여 있음
         * 테트로미노가 올려진 칸의 수들의 최대 합을 구하기
         *
         * M*N (가로*세로), 4<=N,M<=500
         * 각 칸의 수(자연수) <= 1000
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로

        paper = new int[N][M]; //숫자가 적힌 종이
        visited = new boolean[N][M]; //겹치면 안되서 방문 처리 체크

        //종이의 칸 번호 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //종이 모든 칸을 중점으로 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j, paper[i][j],1);
                    visited[i][j] = false;
                }
            }
        }

        //최대 합 출력
        System.out.println(maxSum);
    }

    private static void dfs(int startX, int startY, int sum, int count) {

        //테트로미노가 되면 각 칸의 숫자 합을 현재 최대값과 비교 후 리턴
        if (count == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        //4방탐색
        for (int i = 0; i < 4; i++) {
            int curX = startX + dx[i];
            int curY = startY + dy[i];

            //종이 범위를 벗어나지 않고 방문했던 적이 없을 경우
            if (curX >= 0 && curY >= 0 && curX < N && curY < M && !visited[curX][curY]) {

                //ㅗ모양의 도형을 만들기 위해
                if (count == 2) {
                    visited[curX][curY] = true;
                    dfs(startX, startY, sum+paper[curX][curY], count+1);
                    visited[curX][curY]=false;
                }

                visited[curX][curY] = true;
                dfs(curX, curY, sum+paper[curX][curY], count+1);
                visited[curX][curY]=false;
            }
        }
    }
}