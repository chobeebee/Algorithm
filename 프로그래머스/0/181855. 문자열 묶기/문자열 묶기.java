import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer,Integer> map = new HashMap<>();
        int answer = 0;
        
        for(String str : strArr){
            int strLength = str.length();
            map.put(strLength, map.getOrDefault(strLength,0)+1);
        }
        
        for(int val : map.values()){
            if(val > answer){
                answer = val;
            }
        }
        
        return answer;
    }
}