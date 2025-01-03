import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 구름 레벨에서 제공하는 알고리즘 문제 풀려 함
         * 구름 레벨 1~5까지, 난이도가 같거나 증가하는 순서대로 풀려고 함
         * N개 문제들을 푸는데 걸릴 예상 시간 체크
         * 문제 간 휴식 시간이 필요. 난이도가 같다면 두 문제를 푼 시간 차이 만큼이고 난이도가 증가할 땐 60분 시간 필요.
         * 즉, 구름이가 문제를 푸는 데 걸린 시간= 풀 문제의 예상 시간 합 + 문제 사이 휴식 시간
         * 구름이가 계획한 문제를 푸는데 필요한 최소 시간 구하기.
         *
         * 5<= 문제 수 N <= 1000
         * 난이도별 풀어야 하는 문제 수 p1,p2,p3,p4,p5 (1<=pi< N, 1<=i<=5)
         * 1<= 문제 푸는 시간 t <=300
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //문제
        int total = 0; //총 문제 풀 시간
        int prevTime = 0; //휴식 시간

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[5]; //난이도별 풀 문제 수
        for (int i = 0; i < 5; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, List<Integer>> solvedInfo = new HashMap<>();
        //초기화
        for (int i = 1; i <= 5; i++) {
            solvedInfo.put(i, new ArrayList<>());
        }
        //N개 문제 별, 난이도와 푸는데 걸리는 시간 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int problems = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            solvedInfo.get(problems).add(time);
        }

        //각 난이도별 처리
        for (int i = 0; i < 5; i++) {
            List<Integer> problemTimes = solvedInfo.get(i + 1);
            Collections.sort(problemTimes); //걸리는 시간 오름차순 정렬

            //현재 난이도에서 풀어야 할 문제 수만큼 처리
            for (int j = 0; j < numbers[i]; j++) {
                int currentTime = problemTimes.get(j);
                total += currentTime; //문제 풀이 시간 추가

                //첫 문제가 아닐 경우
                if (!(i == 0 && j == 0)) {
                    if (j == 0 && i > 0) {
                        //난이도가 증가 시, 60분 휴식 시간
                        total += 60;
                    } else {
                        //같은 난이도일 때, 시간 차이만큼 휴식
                        total += Math.abs(currentTime - prevTime);
                    }
                }
                prevTime = currentTime;
            }
        }

        //총 소요 시간
        System.out.println(total);
    }
}