import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    /*
    * 소트인사이드
    * 수가 주어지면 각 자리수를 내림차순으로 정렬
    * N < 1,000,000,000
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(""); // 주어진 수를 문자 배열로 받기
        List<Integer> list = new ArrayList<>();
        
        // 정렬을 위해 리스트에 각 숫자 넣기
        for (String s : arr) {
            list.add(Integer.parseInt(s));
        }
        // 내림차순 정렬
        list.sort(Collections.reverseOrder());
        // 리스트를 문자로 이어서 출력
        for(int l : list){
            System.out.print(l+"");
        }
    }
}