import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int size = friends.length;
        Map<String, Integer> map = new HashMap<>(); // 각 친구의 index
        int[][] giftCount = new int[size][size]; // 선물 주고 받은 횟수
        int[] given = new int[size]; // 각자 준 선물 개수
        int[] receive = new int[size]; // 각자 받은 선물 개수
        
        // Map에 각 친구의 Index 저장
        for(int i=0; i<size; i++) {
            map.put(friends[i], i);
        }
        
        // 주고 받은 선물 개수 세기
        for(int i=0; i<gifts.length; i++) {
            String[] giveTake = gifts[i].split(" ");
            int giver = map.get(giveTake[0]); // 선물 준 사람 index
            int receiver = map.get(giveTake[1]); // 선물 받은 사람 index
            
            // 선물 주고 받은 개수 카운트
            giftCount[giver][receiver]++;
            given[giver]++;
            receive[receiver]++;
        }
        
        // 선물 지수 계산
        int[] giftPoint = new int[size];
        for(int i=0; i<size; i++) {
            giftPoint[i] = given[i] - receive[i];
        }
        
        // 다음달 받을 선물 수
        int[] nextMonth = new int[size];
        
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(i == j) continue; // 자기자신 건너뛰기
                
                if(giftCount[i][j] > giftCount[j][i]){
                    nextMonth[i]++;
                } else if(giftCount[i][j] == giftCount[j][i]) {
                    if(giftPoint[i] > giftPoint[j]) {
                        nextMonth[i]++;
                    }
                }
            }
        }
        
        // 다음달 최대 선물 수
        for(int next : nextMonth) {
            answer = Math.max(answer, next);
        }        
        
        return answer;
    }
}