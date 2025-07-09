import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stageCount = new int[N+2]; // N+1 : 스테이지 통과한 사람
        int players = stages.length; // 전제 사용자 수
        Map<Integer, Double> failureMap = new HashMap<>(); // 스테이지 별 실패율
        
        // 각 스테이지에 도달한 사람 수
        for(int stage : stages) {
            stageCount[stage]++;
        }
        
        // 각 스테이지 실패율 구하기
        for(int i=1; i<=N; i++) {
            int challengers = stageCount[i];
            double failureRate = 0; // 실패율
            
            if(players != 0) {
                failureRate = (double) challengers / players;
            }
            
            failureMap.put(i, failureRate); // 스테이지 별 실패율 입력
            players -= challengers; // 다음 스테이지로 넘어간 사용자 수
        }
        
        // 정렬을 위해 List 이용
        List<Integer> stageList = new ArrayList<>(failureMap.keySet());
        stageList.sort((a,b) -> {
            double rateA = failureMap.get(a);
            double rateB = failureMap.get(b);
            
            // 실패율 같으면 오름차순
            if (rateA == rateB) {
                return Integer.compare(a, b);
            }
            
            // 실패율 내림차순
            return Double.compare(rateB, rateA);
        });
        
        // 결과 반환
        for(int i=0; i<N; i++) {
            answer[i] = stageList.get(i);
        }
        
        return answer;
    }
}