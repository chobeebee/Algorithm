import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 2명이서 하는 게임
         * 돌 N개, 턴을 돌면서 1개 또는 3개 가져갈 수 있음
         * 마지막 돌을 가져가는 사람이 이기는 게임
         *
         * 게임을 상근이가 먼저 시작 함
         * 상근이가 이기면 SK, 창영이가 이기면 CY 출력
         *
         *
         * 돌 5개
         * 상근 : 1 1
         * 창영 : 3
         *
         * 상근 : 3 1
         * 창영 : 1
         *
         * 상근 : 1 1 1
         * 창영 : 1 1
         * ------------------
         * 돌 6개
         * 상근 : 1 1
         * 창영 : 1 3
         *
         * 상근 : 1 1
         * 창영 : 3 1
         *
         * 상근 : 1 3
         * 창영 : 1 1
         *
         * 상근 : 3 1
         * 창영 : 1 1
         *
         * 상근 : 3
         * 창영 : 3
         *
         * N이 홀수 면 상근 win, 짝수면 창영 win
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println( N%2==0 ? "CY" : "SK");
    }
}