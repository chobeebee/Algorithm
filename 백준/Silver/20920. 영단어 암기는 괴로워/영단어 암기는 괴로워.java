import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 영어 단어장 단어 순서의 우선 순위를 차례로 적용
         * 1. 자주 나오는 단어일수록 앞에 배치
         * 2. 해당 단어의 길이 길수록 앞에 배치
         * 3. 알파벳 사전 순
         *
         * M이상의 단어들만 외움
         *
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //단어 개수
        int M = Integer.parseInt(st.nextToken()); //단어 길이 기준

        Map<String, Integer> map = new HashMap<>(); //길이가 M이상인 단어들 각 개수

        //단어 입력
        for (int i = 0; i < N; i++) {

            String word = br.readLine(); //입력 단어

            //길이가 M이상일 경우 map에 추가
            if(word.length() >= M){
                map.put(word, map.getOrDefault(word, 0) +1);
            }
        }

        //map을 List로 변환
        List<String> list = new ArrayList<>(map.keySet());

        //정렬
        list.sort((o1, o2) -> {
            //빈도수 내림차순
            if (!map.get(o1).equals(map.get(o2))) {
                return map.get(o2) - map.get(o1);
            }
            //길이 내림차순
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }
            //사전 순
            return o1.compareTo(o2);
        });

        //단어장 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String word : list) {
            bw.write(word);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}