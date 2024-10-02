import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 수빈이가 있는 점 N, 동생이 있는 점 K
         * 수빈이는 걷거나 순간이동 할 수 있음 : 걷는 다면 1초 후, X-1 || X+1로 이동하고 순간이동은 1초 후에 2*X의 위치로 이동
         * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인가?
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //수빈이 위치
        int K = Integer.parseInt(st.nextToken()); //동생 위치
        int[] move = new int[100001]; //이동 거리

        if (N == K) {
            System.out.println(0);
        }else{
            bfs(N, K, move);
        }
    }

    private static void bfs(int subin, int sister, int[] move) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(subin); //수빈이 위치 넣기
        move[subin] = 1; //이동 시간

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int current = queue.poll(); //현 위치 꺼내기

                //앞으로, 뒤로, 순간이동
                for (int j = 0; j < 3; j++) {
                    int position; //위치

                    if (j == 0) {
                        //앞으로
                        position = current + 1;
                    } else if (j==1) {
                        //뒤로
                        position = current - 1;
                    } else{
                        //순간이동
                        position = current * 2;
                    }

                    //동생을 찾았다면 끝
                    if (position == sister) {
                        System.out.println(move[current]);
                        return;
                    }

                    if(position>=0 && position < move.length && move[position] == 0){
                        queue.add(position);
                        move[position] = move[current]+1;
                    }
                }
            }
        }
    }
}