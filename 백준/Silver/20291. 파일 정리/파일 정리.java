import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 파일의 확장자 별로 정리 : 개수 확인
         * 확장자들을 사전 순 정렬
         *
         * 1<= 파일 개수 N <= 50,000
         * 3<= 파일 이름 길이 <= 100
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int N = Integer.parseInt(br.readLine()); //파일 개수
        Map<String, Integer> files = new TreeMap<>(); //파일들

        //확장자와 개수 파악
        for (int i = 0; i < N; i++) {
            String[] fileName = br.readLine().split("\\."); //파일명
            String extension = fileName[fileName.length - 1]; //확장자
            files.put(extension, files.getOrDefault(extension, 0) + 1);
        }

        // 결과 출력
        for (Map.Entry<String, Integer> entry : files.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}