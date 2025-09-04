import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0; // 담을 귤 크기 개수
        
        // 귤 크기별 개수
        Map<Integer, Integer> sizeCount = new HashMap<>();
        for(int t : tangerine) {
            sizeCount.put(t, sizeCount.getOrDefault(t,0)+1);
        }
        
        // 개수 기준 내림차순
        List<Integer> list = new ArrayList<>(sizeCount.values());
        list.sort(Collections.reverseOrder());
        
        // 귤 종류 개수 구하기
        int sum = 0;
        for(int l : list) {
            sum += l;
            answer++;
            
            if(sum >= k ) break;
        }
        
        return answer;
    }
}