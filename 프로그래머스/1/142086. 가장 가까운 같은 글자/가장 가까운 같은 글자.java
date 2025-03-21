import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            
            char c = s.charAt(i); //기준 글자
            
            //map에 글자가 이미 있다면,
            //현재 index에서 해당 글자가 마지막을 발결된 위치를 뺌
            if(map.containsKey(c)){
                answer[i] = i - map.get(c);
            }else{
                //처음 등장한 경우, -1
                answer[i] = -1;
            }
            
            //map에 현재 글자와 위치 넣음
            map.put(c, i);
        }
        
        return answer;
    }
}