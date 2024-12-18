import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int sum = sides[0] + sides[1];
        
        Arrays.sort(sides);
        
        for(int i=sides[1]+1; i<sum; i++){
            answer++;
        }
        
        for(int i=sides[1]-sides[0]+1; i<=sides[1]; i++){
            answer ++;
        }
                
        return answer;
    }
}