import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> map = new HashMap<>(); // 참가자 명단 등록 횟수
        
        // 명단에 있으면 기존 값에 +1, 없으면 1
        for(String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        // 완주자 명단을 탐색하여 map에서 일치하는 참여자 횟수 차감
        for(String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        
        // map에서 값이 1인 사람 출력(미완주)
        for(String key : map.keySet()) {
            if(map.get(key) > 0) answer = key;
        }
        
        return answer;
    }
}