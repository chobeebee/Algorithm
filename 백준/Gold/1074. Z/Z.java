import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 2^N*2^N 2차원 배열을 Z모양으로 탐색 : 왼쪾 위 > 오른쪽 위 > 왼쪽 아래 > 오른쪽 아래
         * N>1인 경우, 4등분 하여 재귀적으로 순서대로 방문
         * r행 c열을 몇 번째 방문하는 지 출력
         *
         * [0,0],[0,1],[1,0],[1,1]
         * [0,2],[0,3],[1,2],[1,3]
         * [2,0],[2,1],[3,0],[3,1]
         * [2,2],[2,3],[3,2],[3,3]
         *
         * x+1,x-1 y+1,x+1
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //제곱수
        int r = Integer.parseInt(st.nextToken()); //행
        int c = Integer.parseInt(st.nextToken()); //열
        int size = (int) Math.pow(2, N); //한 변 길이
        int count = 0; //방문 횟수

        root(r,c,size,count);
    }

    private static void root(int r, int c,int size,int count) {
        int newSize = size/2; //4등분한 한 변의 길이
        
        //크기가 1이면 방문 횟수 출력
        if(size == 1){
            System.out.println(count);
            return;
        }

        if (r < newSize && c < newSize) {
            //1사분면
            count += newSize * newSize * 0;
            root(r,c,newSize,count);
        }else if(r<newSize && c<newSize+newSize){
            //2사분면
            count+= newSize * newSize * 1;
            root(r,c-newSize,newSize,count);
        }else if (r < newSize + newSize && c < newSize) {
            //3사분면
            count+= newSize * newSize * 2;
            root(r-newSize,c,newSize,count);
        } else if (r < newSize + newSize && c < newSize + newSize) {
            //4사분면
            count+= newSize * newSize * 3;
            root(r-newSize,c-newSize,newSize,count);
        }
    }
}