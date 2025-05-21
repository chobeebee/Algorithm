import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    /*
    * 소트인사이드
    * 수가 주어지면 각 자리수를 내림차순으로 정렬
    * N < 1,000,000,000
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(""); // 주어진 수를 문자 배열로 받기
        
        // 내림차순 정렬
        Arrays.sort(arr, Collections.reverseOrder());
        
        // 배열 출력
        for(String a : arr){
            System.out.print(a);
        }
    }
}