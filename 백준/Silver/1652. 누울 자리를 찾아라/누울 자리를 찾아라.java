import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int N = Integer.parseInt(br.readLine()); //방 크기
        boolean[][] room = new boolean[N][N];
        int verCount = 0;
        int horCount = 0;

        //방 구조 상황
        for(int i = 0; i < N; i++) {
            String state = br.readLine();

            for(int j = 0; j < N; j++) {
                room[i][j] = state.charAt(j) == '.';
            }
        }

        int counth=0; int countv=0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                //가로
                if(room[i][j]){
                    counth++;
                }
                if(!room[i][j] || (j==N-1)) {
                    if(counth >= 2){
                        horCount++;
                    }
                    counth =0;
                }
                
                //세로
                if(room[j][i]) {
                    countv++;
                }
                if(!room[j][i] || (j==N-1)) {
                    if(countv >= 2){
                        verCount++;
                    }
                    countv =0;
                }
            }
        }

        System.out.println(horCount +" "+ verCount);
    }
}