import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        // map에 선수, 현재 등수 입력
        for(int i=0; i<players.length; i++){
            map.put(players[i], i);
        }
        
        // 해설진이 부른 추월 선수
        for(String call : callings){
            
            int rank = map.get(call); // 이름 불린 선수 등수
            String frontPlayer = players[rank-1]; // 앞에 있는 선수

            // 선수 위치 바꾸기
            players[rank-1] = call;
            players[rank] = frontPlayer;

            // 선수의 바뀐 등수 업데이트
            map.put(call, rank-1);
            map.put(frontPlayer, rank);
        }
        
        return players;
    }
}